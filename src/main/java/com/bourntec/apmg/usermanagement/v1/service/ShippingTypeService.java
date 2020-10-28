package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.usermanagement.v1.dto.request.ShippingTypeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ShippingTypeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.service.impl.ShippingTypeServiceImpl;
/**
 * interface for  ShippingType services
 * @author Tinu
 *@see ShippingTypeServiceImpl
 */
public interface ShippingTypeService {
	/**
	 *    Method for retrieving  all ShippingType details
	 * 
	 * @return List<ShippingTypeResponseDTO>
	 * @throws Exception
	 */
    List<ShippingTypeResponseDTO> getAll() throws Exception;

	/**
	 *    Method for retrieving  ShippingType with given id
	 * 
	 * @param id
	 * @return ShippingTypeResponseDTO
	 * @throws Exception
	 */
    ShippingTypeResponseDTO getById(Long id) throws Exception;

    /**
	 * Method for saving ShippingType
	 * 
	 * @param ShippingTypeRequestDTO
	 * @return ShippingTypeResponseDTO
	 * @throws Exception
	 */
	ShippingTypeResponseDTO saveShippingType(ShippingTypeRequestDTO shippingTypeRequestDTO) throws Exception;

	/**
	 * This is the main method which is used to search ShippingType dynamically
	 * 
	 * @param ShippingTypeRequestDTO
	 * @return List<ShippingTypeResponseDTO>
	 */
	List<ShippingTypeResponseDTO> searchForShippingType(ShippingTypeRequestDTO shippingTypeRequestDTO) throws Exception;

	/**
	 *    Method for deleting  ShippingType
	 * 
	 * @param id
	 * @return ShippingTypeResponseDTO
	 * @throws Exception
	 */
	ShippingTypeResponseDTO deleteShippingType(Long id) throws Exception;
	
	/**
	 *    Method for updating  ShippingType
	 * 
	 * @param id
	 * @param ShippingTypeRequestDTO
	 * @return ShippingTypeResponseDTO
	 * @throws Exception
	 */
	ShippingTypeResponseDTO updateShippingType(Long id,ShippingTypeRequestDTO shippingTypeRequestDTO) throws Exception;
	
	
}
