package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.PassAccessList;
import com.bourntec.apmg.usermanagement.v1.dto.request.PassAccessListRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassAccessListResponseDTO;

public interface PassAccessListService {

	List<PassAccessList> getAll() throws Exception;

	List<PassAccessList> getById(String userId) throws Exception;

	PassAccessListResponseDTO saveUserRole(PassAccessListRequestDTO accessListRequestDTO) throws Exception;

	PassAccessListResponseDTO updateUserRole(List<PassAccessListRequestDTO> accessListRequestDTO) throws Exception;

	PassAccessListResponseDTO deleteUserRole(Long id) throws Exception;

	List<PassAccessListResponseDTO> search(PassAccessListRequestDTO accessListRequestDTO,int page, int size) throws Exception;
}
