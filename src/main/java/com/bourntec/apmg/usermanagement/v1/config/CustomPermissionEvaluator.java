package com.bourntec.apmg.usermanagement.v1.config;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ForbiddenException;

/**
 * com.bourntec.apmg.usermanagement
 * 
 * @author Srijini T.S
 *
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean hasPermission(Authentication auth, Object targetDomainObject, Object permission) {
		return hasPrivilege(auth, permission.toString().toUpperCase());
	}

	@Override
	public boolean hasPermission(Authentication auth, Serializable targetId, String targetType, Object permission) {
		if ((auth == null) || (targetType == null) || !(permission instanceof String)) {
			return false;
		}
		return hasPrivilege(auth, targetType.toUpperCase(), permission.toString().toUpperCase());
	}

	private boolean hasPrivilege(Authentication auth, String targetType, String permission) {
		for (GrantedAuthority grantedAuth : auth.getAuthorities()) {
			if (grantedAuth.getAuthority().startsWith(targetType)) {
				if (grantedAuth.getAuthority().contains(permission)) {
					return true;
				}
			}
		}
		throw new ForbiddenException(ErrorCodes.ACCESS_DENIED.getMessage());
	}

	private boolean hasPrivilege(Authentication auth, String permission) {
		Map<Object, Map<Object, List<Object>>> userPermissionList = getAllUsersRoleFromcache();
		List<Object> userUrlList = getUsersUrlList(auth.getName(), permission, userPermissionList);

		for (GrantedAuthority grantedAuth : auth.getAuthorities()) {
			if (userUrlList != null && userUrlList.contains(grantedAuth.getAuthority().trim())) {
				return true;
			}
		}
		throw new ForbiddenException(ErrorCodes.ACCESS_DENIED.getMessage());
	}

	private List<Object> getUsersUrlList(String authUser, String permission,
			Map<Object, Map<Object, List<Object>>> usersPermissionList) {

		for (Entry<Object, Map<Object, List<Object>>> entry : usersPermissionList.entrySet()) {
			if (entry.getKey().equals(authUser)) {
				for (Entry<Object, List<Object>> urls : entry.getValue().entrySet()) {
					if (urls.getKey() != null && permission.equalsIgnoreCase((String) urls.getKey())) {
						return urls.getValue();
					}
				}
			}
		}
		return null;
	}

	private Map<Object, Map<Object, List<Object>>> getAllUsersRoleFromcache() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Map<Object, Map<Object, List<Object>>>> entity = new HttpEntity<Map<Object, Map<Object, List<Object>>>>(
				headers);
		try {
			return restTemplate.exchange("http://192.168.10.127:8082/usermanagement/v1/getAllUserPermissionList",
					HttpMethod.GET, entity, Map.class).getBody();
		} catch (Exception e) {
			System.out.println();
		}
		return null;

	}

}
