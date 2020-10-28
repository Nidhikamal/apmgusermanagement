package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.NewArrivals;
import com.bourntec.apmg.usermanagement.v1.dto.request.ArrivalsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ArrivalsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.repository.NewArrivalsRepository;
import com.bourntec.apmg.usermanagement.v1.searchspec.GenericSpesification;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchCriteria;
import com.bourntec.apmg.usermanagement.v1.searchspec.SearchOperation;
import com.bourntec.apmg.usermanagement.v1.service.NewArrivalService;

/**
 * 
 * Service class implementation for employee Entity
 * 
 * @author Amal Chandra N A
 *
 */
@Service(value = "NewArrivalServiceImpl")
public class NewArrivalServiceImpl implements NewArrivalService {

	private static final Logger logger = LogManager.getLogger(NewArrivalServiceImpl.class);

	@Autowired
	private NewArrivalsRepository arrivalsRepository;

	/**
	 * * @author amal This is the main method which is used to get arrivals by id
	 */

	public ArrivalsResponseDTO getArrivalsById(Long id) {
		ArrivalsResponseDTO arrivalRespDTO = new ArrivalsResponseDTO();
		try {
			logger.info("Fetching arrivals");
			Optional<NewArrivals> arrivals = arrivalsRepository.findById(id);
			if (arrivals.isPresent()) {
				NewArrivals newArrivals = arrivals.get();
				BeanUtils.copyProperties(newArrivals, arrivalRespDTO);
			} else {
				logger.info("Arrivals doesn't exist");
				arrivalRespDTO.setResponseMessage("Arrivals doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Fetch: getArrivalsById:" + e);
			throw e;
		}
		return arrivalRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all arrivals
	 * 
	 */
	public List<NewArrivals> findAllNewArrivals() {
		logger.info("Fetching all arrivals");
		return arrivalsRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to save arrivals
	 */

	public ArrivalsResponseDTO saveArrivals(ArrivalsRequestDTO arrivalReqDTO) {
		ArrivalsResponseDTO arrivalsRespDTO = new ArrivalsResponseDTO();
		try {
			NewArrivals arrivals = arrivalReqDTO.toModel(arrivalReqDTO);
			NewArrivals arrivalsEntity = arrivalsRepository.save(arrivals);
			if (arrivalsEntity != null) {
				BeanUtils.copyProperties(arrivalsEntity, arrivalsRespDTO);
				arrivalsRespDTO.setResponseMessage("Saved  arrivals successfully");
				logger.info("saved  arrivals successfully");
			} else {
				arrivalsRespDTO.setResponseMessage("Failed to save  arrivals");
				logger.error("Failed to save  arrivals");
			}
		} catch (Exception e) {
			logger.error("Save: saveArrivals:" + e);
			throw e;
		}
		return arrivalsRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to update arrivals by Id
	 */
	public ArrivalsResponseDTO updateArrivals(Long id, ArrivalsRequestDTO arrivalsReqDTO) {
		ArrivalsResponseDTO savedRespArrivals = new ArrivalsResponseDTO();
		try {
			Optional<NewArrivals> arrivals = arrivalsRepository.findById(id);
			if (arrivals.isPresent()) {
				NewArrivals newArrivals = arrivalsReqDTO.toModel(arrivalsReqDTO);
				newArrivals.setId(id);
				NewArrivals arrivalsEntity = arrivalsRepository.save(newArrivals);
				if (arrivalsEntity != null) {
					BeanUtils.copyProperties(arrivalsEntity, savedRespArrivals);
					savedRespArrivals.setResponseMessage("Updated  arrivals successfully");
					logger.info("Updated  arrivals successfully");
				} else {
					savedRespArrivals.setResponseMessage("Arrivals updation failed");
					logger.error("Arrivals updation failed");
				}
			} else {
				logger.error("Arrivals doesn't exist");
				savedRespArrivals.setResponseMessage("Failed");
			}
		} catch (Exception e) {
			logger.error("Update:updateArrivals:" + e);
			throw e;
		}
		return savedRespArrivals;
	}

	public List<NewArrivals> findArrivalsDataByCriteria(ArrivalsRequestDTO arrivalReqDTO) {
		GenericSpesification<NewArrivals> genericSpesification = new GenericSpesification<NewArrivals>();
		logger.info("Fetching  arrivals");
		if (arrivalReqDTO.getId() != null) {
			genericSpesification.add(new SearchCriteria("id", arrivalReqDTO.getId(), SearchOperation.EQUAL));
		}
		if (arrivalReqDTO.getItemCode() != null) {
			genericSpesification
					.add(new SearchCriteria("itemCode", arrivalReqDTO.getItemCode(), SearchOperation.MATCH));
		}

		return arrivalsRepository.findAll(genericSpesification);
	}

	@Override
	public ArrivalsResponseDTO deleteNewArrivals(Long id) {
		ArrivalsResponseDTO respArrivals = new ArrivalsResponseDTO();
		arrivalsRepository.deleteById(id);
		respArrivals.setResponseMessage("Deleted successfully");
		return respArrivals;
	}

}
