package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.PassTable;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassModuleOptionListRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassTableRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassTableResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.SuccessResponseDTO;

public interface UserService {

	List<PassTable> getAll();

	List<PassTableResponseDTO> searchForUser(PassTableRequestDTO userRequestDTO, int page, int size) throws Exception;

	SuccessResponseDTO setUserForNewRole(String newUserId, String userId) throws Exception;

	SuccessResponseDTO updateUserRole(String userId, List<PassModuleOptionListRequestDTO> optionListRequestDTOs)
			throws Exception;
}
