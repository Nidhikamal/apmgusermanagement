package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.usermanagement.v1.dto.request.PassModuleOptionListRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PassModuleOptionListResponseDTO;

public interface PassModuleOptionService {

	List<PassModuleOptionListResponseDTO> getAll() throws Exception;

	List<PassModuleOptionListResponseDTO> getById(String optionname) throws Exception;

	PassModuleOptionListResponseDTO saveOptions(List<PassModuleOptionListRequestDTO> listRequestDTOs) throws Exception;

	PassModuleOptionListResponseDTO updateOption(List<PassModuleOptionListRequestDTO> accessListRequestDTO)
			throws Exception;

	PassModuleOptionListResponseDTO deleteOption(String option) throws Exception;

	List<PassModuleOptionListResponseDTO> search(PassModuleOptionListRequestDTO accessListRequestDTO,int page, int size) throws Exception;
}
