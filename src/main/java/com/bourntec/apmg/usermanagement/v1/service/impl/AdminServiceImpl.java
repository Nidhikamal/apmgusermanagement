/**
 * 
 */
package com.bourntec.apmg.usermanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.BankAccounts;
import com.bourntec.apmg.entity.BrandDetails;
import com.bourntec.apmg.entity.Brokers;
import com.bourntec.apmg.entity.CodesPacking;
import com.bourntec.apmg.entity.CollectionSubKeyword;
import com.bourntec.apmg.entity.CompanyData;
import com.bourntec.apmg.entity.CountryCodes;
import com.bourntec.apmg.entity.CreditcardNames;
import com.bourntec.apmg.entity.CurrencyCode;
import com.bourntec.apmg.entity.FaqDetails;
import com.bourntec.apmg.entity.Incidents;
import com.bourntec.apmg.entity.LabourCharge;
import com.bourntec.apmg.entity.CodesLocation;
import com.bourntec.apmg.entity.MerchandiseCategory;
import com.bourntec.apmg.entity.MerchandiseSubCategory;
import com.bourntec.apmg.entity.NewArrivals;
import com.bourntec.apmg.entity.ParcelDetails;
import com.bourntec.apmg.entity.PaymentTerms;
import com.bourntec.apmg.entity.PotentialGroup;
import com.bourntec.apmg.entity.RfidScanner;
import com.bourntec.apmg.entity.ShippingCodes;
import com.bourntec.apmg.entity.StateCodes;
import com.bourntec.apmg.entity.VendorCountryCodes;
import com.bourntec.apmg.entity.VendorStateCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.ArrivalsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.BankAccountRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrandRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrokersRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CodesPackingRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CompanyRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CountryCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CreditcardsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CurrencyCodeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.FaqDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.IncidentsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.LabourChargeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CodesLocationRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.MerchandiseCategoryRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.ParcelDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.PaymentTermsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.PotentialCustomerGroupRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.RfidRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.ShippingCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.VendorCountryCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ArrivalsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BankAccountResponsetDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrandResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.BrokersResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CodesPackingResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CompanyResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CountryCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CreditcardResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CurrencyCodeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.FaqResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.IncidentsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.LabourChargeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CodesLocationResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.MerchandiseCategoryResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ParcelDetailResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PaymentTermsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PotentialCustomerGroupResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.RfidScannerResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ShippingCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorCountryCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.exception.ErrorCodes;
import com.bourntec.apmg.usermanagement.v1.exception.ResourceNotFoundException;
import com.bourntec.apmg.usermanagement.v1.repository.BankAccountRepository;
import com.bourntec.apmg.usermanagement.v1.repository.BrandRepository;
import com.bourntec.apmg.usermanagement.v1.repository.BrokersRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CodesPackingRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CompanyDataRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CountryCodesRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CreditcardRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CurrencyCodeRepository;
import com.bourntec.apmg.usermanagement.v1.repository.FaqDetailsRepository;
import com.bourntec.apmg.usermanagement.v1.repository.IncidentsRepository;
import com.bourntec.apmg.usermanagement.v1.repository.LabourChargeRepository;
import com.bourntec.apmg.usermanagement.v1.repository.CodesLocationRepository;
import com.bourntec.apmg.usermanagement.v1.repository.MerchandiseCategoryRepository;
import com.bourntec.apmg.usermanagement.v1.repository.NewArrivalsRepository;
import com.bourntec.apmg.usermanagement.v1.repository.ParcelRepository;
import com.bourntec.apmg.usermanagement.v1.repository.PaymentTermsRepository;
import com.bourntec.apmg.usermanagement.v1.repository.PotentialCustomerGroupRepository;
import com.bourntec.apmg.usermanagement.v1.repository.RfidScannerRepository;
import com.bourntec.apmg.usermanagement.v1.repository.ShippingCodesRepository;
import com.bourntec.apmg.usermanagement.v1.repository.StateCodesRepository;
import com.bourntec.apmg.usermanagement.v1.repository.VendorCountryCodesRepository;
import com.bourntec.apmg.usermanagement.v1.repository.VendorStateCodesRepository;
import com.bourntec.apmg.usermanagement.v1.service.AdminService;

/**
 * 
 * Service class implementation for employee
 * 
 * @author Naveen Radakrishnan
 *
 */
@Deprecated
@Service(value = "AdminServiceImpl")

public class AdminServiceImpl implements AdminService {

	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private CountryCodesRepository countryRepository;

	@Autowired
	private StateCodesRepository stateRepository;

	@Autowired
	private VendorCountryCodesRepository vendorCountryRepository;

	@Autowired
	private VendorStateCodesRepository vendorStateRepository;

	@Autowired
	private CodesLocationRepository locationCodeRepository;

	@Autowired
	private LabourChargeRepository labourChargeRepository;

	@Autowired
	private PotentialCustomerGroupRepository potentialCustomerGroupRepository;

	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Autowired
	private CurrencyCodeRepository currencyCodeRepository;

	@Autowired
	MerchandiseCategoryRepository merchandiseCategoryRepository;
	@Autowired
	PaymentTermsRepository paymentTermsRepository;
	@Autowired
	BrokersRepository brokersRepository;
	@Autowired
	ParcelRepository parcelRepository;
	@Autowired
	IncidentsRepository incidentsRepository;
	@Autowired
	FaqDetailsRepository faqDetailsRepository;

	@Autowired
	BrandRepository brandRepository;

	@Autowired
	NewArrivalsRepository arrivalsRepository;

	@Autowired
	CodesPackingRepository codesPackingRepository;

	@Autowired
	ShippingCodesRepository shippingRepository;

	@Autowired
	RfidScannerRepository rfidRepository;

	@Autowired
	CompanyDataRepository companyRepository;

	@Autowired
	CreditcardRepository creditCardRepository;

	/**
	 * @author naveen This is the main method which is used to save country data
	 * 
	 */

	public CountryCodesResponseDTO saveCustomerCountry(CountryCodesRequestDTO countryRequestDTO) {

		CountryCodesResponseDTO countrycodeResponseDTO = new CountryCodesResponseDTO();
		try {
			CountryCodes countryCodestomodel = countryRequestDTO.toModel(countryRequestDTO);
			
			/*
			 * Set<StateCodes> stateCodesList = countryRequestDTO.getStateCodesSet(); if
			 * (stateCodesList != null && stateCodesList.size() > 0) {
			 * stateCodesList.forEach((subkeywordobj) -> { //
			 * subkeywordobj.setCountryCodes(countryCodestomodel);
			 * 
			 * 
			 * });
			 * 
			 * CountryCodes country = countryRepository.save(countryCodestomodel); if
			 * (country != null) { BeanUtils.copyProperties(country,
			 * countrycodeResponseDTO);
			 * logger.info(" customer country  saved successfully"); } } else {
			 * logger.error(" customer country to not saved  "); }
			 */
		} catch (Exception e) {
			logger.error(" saveCustomerCountry failed" + e);
			throw e;
		}

		return countrycodeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to get update Country
	 * @param CountryRequestDTO,String countryCode
	 * @return CountrycodeResponseDTO
	 */
	public CountryCodesResponseDTO updateCountry(String countryCode, CountryCodesRequestDTO countryRequestDTO) {

		Optional<CountryCodes> countryList = countryRepository.findById(countryCode);

		CountryCodes country = countryList.get();
		CountryCodesResponseDTO countrycodeResponseDTO = new CountryCodesResponseDTO();

		try {
			if (country == null) {
				logger.info("The country details doesn't exists!!!");
				countrycodeResponseDTO.setResponseMessage("The countrydetails doesn't exists");
			} else {

				CountryCodes countryCodes = countryRequestDTO.toModel(countryRequestDTO);

				countryCodes.setCountryCode(countryCode);
			
				
				/*
				 * Set<StateCodes> vendorStateCodesList =countryRequestDTO.getStateCodesSet();
				 * if (vendorStateCodesList != null && vendorStateCodesList.size() > 0) {
				 * vendorStateCodesList.forEach((venderobj) -> { //
				 * venderobj.setCountryCodes(countryCodes);
				 * 
				 * }); }
				 */
				CountryCodes countryCodesSave = countryRepository.save(countryCodes);
				if (countryCodesSave != null) {
					logger.info("countrydetails is updated");
					BeanUtils.copyProperties(countryCodesSave, countrycodeResponseDTO);
					countrycodeResponseDTO.setResponseMessage("countryd details is updated in DB");
				}
				
			}
		} catch (Exception e) {
			logger.error("  updateCountry failed" + e);

			throw e;
		}
		return countrycodeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to save Vendorcountry
	 *         data
	 * 
	 */
	public VendorCountryCodesResponseDTO saveVendorCountry(VendorCountryCodesRequestDTO vendorCountryRequestDTO) {

		VendorCountryCodesResponseDTO vendorCountrycodeResponseDTO = new VendorCountryCodesResponseDTO();
		try {
			VendorCountryCodes vendorCountryCodes = vendorCountryRequestDTO.toModel(vendorCountryRequestDTO);
		
		
			
			/*
			 * Set<VendorStateCodes> vendorStateCodesList
			 * =vendorCountryRequestDTO.getStateCodesSet(); if (vendorStateCodesList != null
			 * && vendorStateCodesList.size() > 0) {
			 * vendorStateCodesList.forEach((venderobj) -> {
			 * venderobj.setVendorCountryCodes(vendorCountryCodes);
			 * 
			 * 
			 * }); }
			 */
			VendorCountryCodes vendercountry =vendorCountryRepository.save(vendorCountryCodes);
			if (vendercountry != null) {
				logger.info("vendorCountry Details is saved");
				BeanUtils.copyProperties(vendercountry, vendorCountrycodeResponseDTO);

				
			}
		} catch (Exception e) {
			logger.error(" vendorCountry Details save failed" + e);
			throw e;
		}

		return vendorCountrycodeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to update Vendorcountry
	 *         data
	 * 
	 */
	public VendorCountryCodesResponseDTO updateVendorCountry(String countryCode,
			VendorCountryCodesRequestDTO countryRequestDTO) {
		Optional<VendorCountryCodes> VendorcountryList = vendorCountryRepository.findById(countryCode);

		VendorCountryCodes vendorccountry = VendorcountryList.get();
		VendorCountryCodesResponseDTO countrycodeResponseDTO = new VendorCountryCodesResponseDTO();

		try {
			if (vendorccountry == null) {
				logger.info("The vendorccountry doesn't exists!!!");
				countrycodeResponseDTO.setResponseMessage("The countryCodes doesn't exists");
			} else {

				VendorCountryCodes countryCodes = countryRequestDTO.toModel(countryRequestDTO);
				countryCodes.setCountryCode(countryCode);
			
				logger.info("vendorcountry Details is updated");
				/*
				 * for (VendorStateCodes statecode : countryRequestDTO.getStateCodesSet()) {
				 * statecode.setVendorCountryCodes(countryCodes);
				 * logger.info("VendorStateCodes Details is updated");
				 * 
				 * }
				 */
				VendorCountryCodes countryCodesSave = vendorCountryRepository.save(countryCodes);
				BeanUtils.copyProperties(countryCodesSave, countrycodeResponseDTO);
				countrycodeResponseDTO.setResponseMessage("vendorcountry details is updated in DB");
			}
		} catch (Exception e) {
			logger.error(" updateVendorCountry ls failed" + e);

			throw e;
		}
		return countrycodeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to save LocationCode
	 *         data
	 * 
	 */
	public CodesLocationResponseDTO saveLocationCode(CodesLocationRequestDTO locationCodeRequestDTO) {

		CodesLocationResponseDTO locationCodeResponseDTO = new CodesLocationResponseDTO();
		try {
			CodesLocation locationCode = locationCodeRequestDTO.toModel(locationCodeRequestDTO);
			CodesLocation locationCodes = locationCodeRepository.save(locationCode);
			if (locationCodes != null) {
				logger.info("locationCodes details  is saved");
				BeanUtils.copyProperties(locationCodes, locationCodeResponseDTO);
			} else {
				logger.info("locationCodes  details is not saved in DB");
			}

		} catch (Exception e) {
			logger.error(" saveLocationCode  failed" + e);
			throw e;
		}

		return locationCodeResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update LocationCode
	 *         data
	 * 
	 */

	public CodesLocationResponseDTO updateLocationCode(String locationCode,
			CodesLocationRequestDTO locationCodeRequestDTO) {
		Optional<CodesLocation> locationCodeList = locationCodeRepository.findById(locationCode);
		CodesLocation lcodes = locationCodeList.get();
		CodesLocationResponseDTO locationCodeResponseDTO = new CodesLocationResponseDTO();

		try {
			if (lcodes == null) {
				logger.info("The locationCode doesn't exists!!!");
				locationCodeResponseDTO.setResponseMessage("The locationCode doesn't exists");
			} else {

				CodesLocation lcode = locationCodeRequestDTO.toModel(locationCodeRequestDTO);
				lcode.setLocationCode(locationCode);

				CodesLocation countryCodesSave = locationCodeRepository.save(lcode);
				logger.info("locationCode Details is updated");

				BeanUtils.copyProperties(countryCodesSave, locationCodeResponseDTO);
				locationCodeResponseDTO.setResponseMessage("locationCode details is updated in DB");
			}
		} catch (Exception e) {
			logger.error(" locationCode updates ls failed" + e);

			throw e;
		}
		return locationCodeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to save LabourCharge  data
	 * 
	 */
	public LabourChargeResponseDTO savelabour(LabourChargeRequestDTO labourChargeRequestDTO) {

		LabourChargeResponseDTO labourChargeResponseDTO = new LabourChargeResponseDTO();
		try {
			LabourCharge labourCharge = labourChargeRequestDTO.toModel(labourChargeRequestDTO);
			LabourCharge labourCharges = labourChargeRepository.save(labourCharge);
			if (labourCharges != null) {
				logger.info("labourCharges details is saved");
				BeanUtils.copyProperties(labourCharges, labourChargeResponseDTO);
			} else {
				logger.info("labourCharges is not saved in DB");
			}
		} catch (Exception e) {
			logger.error(" savelabours ls failed" + e);

			throw e;
		}
		return labourChargeResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update LabourCharge   data
	 * 
	 */

	public LabourChargeResponseDTO updatelabour(Long id, LabourChargeRequestDTO labourChargeRequestDTO) {
		Optional<LabourCharge> labourCharge = labourChargeRepository.findById(id);
		LabourChargeResponseDTO labourChargeResponseDTO = new LabourChargeResponseDTO();

		try {
			if (labourCharge == null) {
				logger.info("The labourCharge doesn't exists!!!");
				labourChargeResponseDTO.setResponseMessage("The labourCharge doesn't exists");
			} else {

				LabourCharge labourCharges = labourChargeRequestDTO.toModel(labourChargeRequestDTO);

				labourCharges.setId(id);
				LabourCharge labour = labourChargeRepository.save(labourCharges);
				logger.info("labourCharge Details is updated");

				BeanUtils.copyProperties(labour, labourChargeResponseDTO);
				labourChargeResponseDTO.setResponseMessage("labourCharge is updated in DB");
			}
		} catch (Exception e) {
			logger.error(" updatelabour ls failed" + e);

			throw e;
		}
		return labourChargeResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to save
	 *         PotentialCustomer data
	 * 
	 */

	public PotentialCustomerGroupResponseDTO potentialcustomersave(
			PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO) {

		PotentialCustomerGroupResponseDTO potentialCustomerGroupResponseDTO = new PotentialCustomerGroupResponseDTO();
		try {
			PotentialGroup potentialCustomerGroup = potentialCustomerGroupRequestDTO
					.toModel(potentialCustomerGroupRequestDTO);
			PotentialGroup potentialCustomerGroups = potentialCustomerGroupRepository
					.save(potentialCustomerGroup);
			if (potentialCustomerGroups != null) {
				logger.info("potentialCustomerGroup details is saved");
				BeanUtils.copyProperties(potentialCustomerGroups, potentialCustomerGroupResponseDTO);
			} else {
				logger.info("potentialCustomerGroup is not saved in DB");
			}

		} catch (Exception e) {
			logger.error(" potentialCustomerGroup saves ls failed" + e);

			throw e;
		}
		return potentialCustomerGroupResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update
	 *         PotentialCustomer data
	 * 
	 */
	public PotentialCustomerGroupResponseDTO updatePotentialcustomer(Long id,
			PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO) {
		Optional<PotentialGroup> potentialCustomerGroups = potentialCustomerGroupRepository.findById(id);
		PotentialCustomerGroupResponseDTO potentialCustomerGroupResponseDTO = new PotentialCustomerGroupResponseDTO();

		try {
			if (potentialCustomerGroups == null) {
				logger.info("The PotentialCustomerGroup doesn't exists!!!");
				potentialCustomerGroupResponseDTO.setResponseMessage("The id doesn't exists");
			} else {

				PotentialGroup potentialCustomerGroup = potentialCustomerGroupRequestDTO
						.toModel(potentialCustomerGroupRequestDTO);

		//		potentialCustomerGroup.setId(id);
				PotentialGroup labour = potentialCustomerGroupRepository.save(potentialCustomerGroup);
				logger.info("PotentialCustomerGroup Details is updated");

				BeanUtils.copyProperties(labour, potentialCustomerGroupResponseDTO);
				potentialCustomerGroupResponseDTO.setResponseMessage("PotentialCustomerGroup is updated in DB");
			}
		} catch (Exception e) {
			logger.error(" potentialCustomerGroup update  failed" + e);

			throw e;
		}
		return potentialCustomerGroupResponseDTO;
	}

	/**
	 * @author naveen This is the main method which is used to save BankAccount data
	 * 
	 */
	public BankAccountResponsetDTO saveBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {

		logger.info("Entering BankAccount details {}", bankAccountRequestDTO);
		BankAccountResponsetDTO bankAccountResponsetDTO = new BankAccountResponsetDTO();
		try {
			BankAccounts bAccount = bankAccountRequestDTO.toModel(bankAccountRequestDTO);
			BankAccounts emp = bankAccountRepository.save(bAccount);
			if (emp != null) {
				logger.info("BankAccount Details is saved");
				BeanUtils.copyProperties(emp, bankAccountResponsetDTO);
			} else {
				logger.info("BankAccount is not saved in DB");
				bankAccountResponsetDTO.setResponseMessage("BankAccount is not  in DB");
			}
		}

		catch (Exception e) {
			logger.error(" BankAccount save  failed" + e);

			throw e;
		}
		return bankAccountResponsetDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update BankAccount
	 *         data
	 * 
	 */
	public BankAccountResponsetDTO updateBankAccount(String bankNo, BankAccountRequestDTO bankAccountRequestDTO) {

		Optional<BankAccounts> bankAccountList = bankAccountRepository.findById(bankNo);

		BankAccounts bankAccountEntity = bankAccountList.get();

		BankAccountResponsetDTO bankAccountResponsetDTO = new BankAccountResponsetDTO();

		try {

			if (bankAccountEntity == null) {
				logger.info("The bankAccountEntity doesn't exists!!!");
				bankAccountResponsetDTO.setResponseMessage("The BankAccounts doesn't exists");
				return bankAccountResponsetDTO;
			} else {

				BankAccounts bankAccountData = bankAccountRequestDTO.toModel(bankAccountRequestDTO);

				bankAccountData.setBankNo(bankNo);
				BankAccounts empSave = bankAccountRepository.save(bankAccountData);
				logger.info("BankAccounts Details is updated");

				BeanUtils.copyProperties(empSave, bankAccountResponsetDTO);
				bankAccountResponsetDTO.setResponseMessage("BankAccounts is updated in DB");
			}
		} catch (Exception e) {
			logger.error(" BankAccount updates  failed" + e);

			throw e;
		}
		return bankAccountResponsetDTO;
	}

	/**
	 * @author naveen This is the main method which is used to save currencyCode
	 *         data
	 * 
	 */
	public CurrencyCodeResponseDTO currencyCodesave(CurrencyCodeRequestDTO currencyCodeRequestDTO) {

		logger.info("Entering currencyCode details {}", currencyCodeRequestDTO);

		CurrencyCodeResponseDTO currencyCodeResponseDTO = new CurrencyCodeResponseDTO();
		CurrencyCode currencyCode = new CurrencyCode();
		try {
			CurrencyCode curCode = currencyCodeRequestDTO.toModel(currencyCodeRequestDTO);
			CurrencyCode emp = currencyCodeRepository.save(curCode);
			if (emp != null) {
				logger.info("currencyCode Details is saved");
				BeanUtils.copyProperties(emp, currencyCodeResponseDTO);
			} else {
				logger.info("currencyCode is not persisted in DB");
				currencyCodeResponseDTO.setResponseMessage("currencyCode is persisted in DB");
			}
		} catch (Exception e) {
			logger.error(" currencyCode saved  failed" + e);

			throw e;
		}
		return currencyCodeResponseDTO;

	}

	/**
	 * @author naveen This is the main method which is used to update currencyCode
	 *  data
	 * 
	 */
	public CurrencyCodeResponseDTO currencyCodeupdate(String currencyCode,
			CurrencyCodeRequestDTO currencyCodeRequestDTO) {

		Optional<CurrencyCode> currencyCodeList = currencyCodeRepository.findById(currencyCode);

		CurrencyCode currency = currencyCodeList.get();

		CurrencyCodeResponseDTO currencyCodeResponseDTO = new CurrencyCodeResponseDTO();

		try {

			if (currency == null) {
				logger.info("The currency doesn't exists!!!");
				currencyCodeResponseDTO.setResponseMessage("The currency doesn't exists");
			} else {

				CurrencyCode code = currencyCodeRequestDTO.toModel(currencyCodeRequestDTO);

				code.setCurrencyCode(currencyCode);
				CurrencyCode currencyCodeSave = currencyCodeRepository.save(code);
				logger.info("currency Details is updated");

				BeanUtils.copyProperties(currencyCodeSave, currencyCodeResponseDTO);
				currencyCodeResponseDTO.setResponseMessage("currency is updated in DB");
			}
		} catch (Exception e) {
			logger.error(" currencyCode updates  failed" + e);

			throw e;
		}
		return currencyCodeResponseDTO;
	}

	/**
	 * This method findBycountryCode
	 * 
	 * @param countryCode
	 * @return CountrycodeResponseDTO
	 * @throws Exception
	 */

	public CountryCodesResponseDTO findBycountryCode(String countryCode) {

		logger.info("Entering countryCode  {}", countryCode);

		CountryCodesResponseDTO countrycodeResponseDTO = new CountryCodesResponseDTO();
		try {

			Optional<CountryCodes> countryList = countryRepository.findById(countryCode);

			CountryCodes CountryCodes = countryList.get();
			if (CountryCodes != null) {
				BeanUtils.copyProperties(CountryCodes, countrycodeResponseDTO);
			} else {
				throw new ResourceNotFoundException("");
			}

		} catch (Exception e) {
			logger.error(" countryCode failed" + e);
			throw e;
		}
		return countrycodeResponseDTO;

	}

	/**
	 * This method findByVendorcountryCode
	 * 
	 * @param countryCode
	 * @return CountrycodeResponseDTO
	 * @throws Exception
	 */
	public VendorCountryCodesResponseDTO findByVendorcountryCode(String countryCode) {

		logger.info("Entering vendorcountryCode  {}", countryCode);

		VendorCountryCodesResponseDTO vendorCountrycodeResponseDTO = new VendorCountryCodesResponseDTO();
		try {

			Optional<VendorCountryCodes> VendorcountryList = vendorCountryRepository.findById(countryCode);

			VendorCountryCodes vendorCountryCodes = VendorcountryList.get();
			if (vendorCountryCodes != null) {
				BeanUtils.copyProperties(vendorCountryCodes, vendorCountrycodeResponseDTO);
			} else {
				throw new ResourceNotFoundException("");
			}

		} catch (Exception e) {
			logger.error(" vendorcountryCode failed" + e);
			throw e;
		}
		return vendorCountrycodeResponseDTO;

	}

	/**
	 * This method findBylocationCode
	 * 
	 * @param locationCode
	 * @return LocationCodeResponseDTO
	 * @throws Exception
	 */
	public CodesLocationResponseDTO findBylocationCode(String locationCode) {

		logger.info("Entering locationCode  {}", locationCode);

		CodesLocationResponseDTO locationCodeResponseDTO = new CodesLocationResponseDTO();
		try {

			Optional<CodesLocation> locationCodeList = locationCodeRepository.findById(locationCode);
			CodesLocation lcodes = locationCodeList.get();

			if (lcodes != null) {
				BeanUtils.copyProperties(lcodes, locationCodeResponseDTO);
			} else {
				throw new ResourceNotFoundException("");
			}

		} catch (Exception e) {
			logger.error(" locationCode failed" + e);
			throw e;
		}
		return locationCodeResponseDTO;

	}

	/**
	 * This method findBylabourid
	 * 
	 * @param id
	 * @return LabourChargeResponseDTO
	 * @throws Exception
	 */
	public LabourChargeResponseDTO findBylabourid(Long id) {

		logger.info("Entering id  {}", id);

		LabourChargeResponseDTO labourChargeResponseDTO = new LabourChargeResponseDTO();
		try {

			Optional<LabourCharge> labourChargeList = labourChargeRepository.findById(id);
			LabourCharge labourCharge = labourChargeList.get();

			if (labourCharge != null) {
				BeanUtils.copyProperties(labourCharge, labourChargeResponseDTO);
			} else {
				throw new ResourceNotFoundException("");
			}

		} catch (Exception e) {
			logger.error(" id failed" + e);
			throw e;
		}
		return labourChargeResponseDTO;

	}

	/**
	 * This method findBypotentialcustomerid
	 * 
	 * @param id
	 * @return PotentialCustomerGroupResponseDTO
	 * @throws Exception
	 */
	public PotentialCustomerGroupResponseDTO findBypotentialcustomerid(Long id) {

		logger.info("Entering id  {}", id);

		PotentialCustomerGroupResponseDTO potentialCustomerGroupResponseDTO = new PotentialCustomerGroupResponseDTO();
		try {

			Optional<PotentialGroup> potentialCustomerGroueList = potentialCustomerGroupRepository.findById(id);
			PotentialGroup potentialCustomerGroupEntity = potentialCustomerGroueList.get();

			if (potentialCustomerGroupEntity != null) {
				BeanUtils.copyProperties(potentialCustomerGroupEntity, potentialCustomerGroupResponseDTO);
			} else {
				throw new ResourceNotFoundException("");
			}

		} catch (Exception e) {
			logger.error(" id failed" + e);
			throw e;
		}
		return potentialCustomerGroupResponseDTO;
	}

	/**
	 * This method findBybankNo
	 * 
	 * @param idbankNo
	 * @return BankAccountResponsetDTO
	 * @throws Exception
	 */
	public BankAccountResponsetDTO findBybankNo(String bankNo) {

		logger.info("Entering bankNo  {}", bankNo);

		BankAccountResponsetDTO bankAccountResponsetDTO = new BankAccountResponsetDTO();
		try {

			Optional<BankAccounts> bankAccountsList = bankAccountRepository.findById(bankNo);
			BankAccounts bankAccounts = bankAccountsList.get();

			if (bankAccounts != null) {
				BeanUtils.copyProperties(bankAccounts, bankAccountResponsetDTO);
			} else {
				throw new ResourceNotFoundException("");
			}

		} catch (Exception e) {
			logger.error(" id failed" + e);
			throw e;
		}
		return bankAccountResponsetDTO;
	}

	/**
	 * This method findBycurrencyCode
	 * 
	 * @param currencyCode
	 * @return CurrencyCodeResponseDTO
	 * @throws Exception
	 */
	public CurrencyCodeResponseDTO findBycurrencyCode(String currencyCode) {
		logger.info("Entering currencyCode  {}", currencyCode);

		CurrencyCodeResponseDTO bankAccountResponsetDTO = new CurrencyCodeResponseDTO();
		try {

			Optional<CurrencyCode> CurrencyCodeList = currencyCodeRepository.findById(currencyCode);
			CurrencyCode CurrencyCodeEntity = CurrencyCodeList.get();

			if (CurrencyCodeEntity != null) {
				BeanUtils.copyProperties(CurrencyCodeEntity, bankAccountResponsetDTO);
			} else {
				throw new ResourceNotFoundException("");
			}

		} catch (Exception e) {
			logger.error(" currencyCode failed" + e);
			throw e;
		}
		return bankAccountResponsetDTO;
	}

	/**
	 * @author naveen This is the main method which is used to get all CountryCode
	 * 
	 */
	public List<CountryCodes> fetchAllCountryCode() {
		logger.info("Fetching all countrycode   ...");

		return countryRepository.findAll();
	}

	/**
	 * @author naveen This is the main method which is used to get all VendorCountry
	 * 
	 */
	public List<VendorCountryCodes> findAllVendorCountry() {
		logger.info("Fetching all vendorcountry details  ...");

		return vendorCountryRepository.findAll();
	}

	/**
	 * @author naveen This is the main method which is used to get all Locationcode
	 * 
	 */
	public List<CodesLocation> findAllLocationcode() {
		logger.info("Fetching all LocationCode details  ...");

		return locationCodeRepository.findAll();
	}

	/**
	 * @author naveen This is the main method which is used to get all Labourcharge
	 * 
	 */
	public List<LabourCharge> findAllLabours() {
		logger.info("Fetching all Labour details  ...");

		return labourChargeRepository.findAll();
	}

	/**
	 * @author naveen This is the main method which is used to get all
	 *         PotentialCustomer
	 * 
	 */
	public List<PotentialGroup> findAllPotentialCustomer() {
		logger.info("Fetching all BankAccounts  ...");

		return potentialCustomerGroupRepository.findAll();
	}

	/**
	 * @author naveen This is the main method which is used to get all BankAccounts
	 * 
	 */
	public List<BankAccounts> findAllBankAccounts() {
		logger.info("Fetching all BankAccounts  ...");

		return bankAccountRepository.findAll();
	}

	/**
	 * @author naveen This is the main method which is used to get CurrencyCode
	 * 
	 */
	public List<CurrencyCode> findAllCurrencyCode() {
		logger.info("Fetching all CurrencyCode  ...");

		return currencyCodeRepository.findAll();
	}

	/*
	 * @author vidya.p save MerchandiseCategory
	 * 
	 * @param categorycode
	 * 
	 * @param categorycode
	 * 
	 * @return merchandiseCategoryResponseDTO
	 * 
	 * @throws Exception
	 */

	public MerchandiseCategoryResponseDTO addMerchandiseCategory(
			MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO) throws Exception {
		try {
			logger.info("MerchandiseCategory is going to save");
			MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseCategoryResponseDTO();
			MerchandiseCategory merchandiseCategory = merchandiseCategoryRequestDTO
					.toModel(merchandiseCategoryRequestDTO);
			if (merchandiseCategory != null) {
//				Set<MerchandiseSubCategory> merchandiseSubCategorySet = merchandiseCategory.getSubcategory();
//				merchandiseSubCategorySet.forEach((merchandiseSubCategory) -> {
//					merchandiseSubCategory.setMerchandiseCategory(merchandiseCategory);
//				});
//				merchandiseCategory.setSubcategory(merchandiseSubCategorySet);
				MerchandiseCategory merchandiseCategoryreturn = merchandiseCategoryRepository.save(merchandiseCategory);
				logger.info("MerchandiseCategoryObject is  persisted in DB");
				BeanUtils.copyProperties(merchandiseCategoryreturn, merchandiseCategoryResponseDTO);
			} else {
				logger.info("MerchandiseCategoryObject is not persisted in DB");
			}
			return merchandiseCategoryResponseDTO;
		} catch (Exception e) {
			logger.error(" addMerchandiseCategory failed" + e);
			throw e;
		}
	}

	/**
	 * update MerchandiseCategory
	 * 
	 * @param categorycode
	 * @param MerchandiseCategoryRequestDTO
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */

	public MerchandiseCategoryResponseDTO updateMerchandiseCategory(String categoryCode,
			MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO) throws Exception {

		try {
			logger.info("MerchandiseCategory is going to update");
			MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseCategoryResponseDTO();
			MerchandiseCategory merchandiseCategory = merchandiseCategoryRequestDTO
					.toModel(merchandiseCategoryRequestDTO);
			merchandiseCategory.setCategoryCode(categoryCode);
			merchandiseCategory.setCategoryDescription(merchandiseCategoryRequestDTO.getCategoryDescription());
			merchandiseCategory.setLocationCode(merchandiseCategoryRequestDTO.getLocationCode());

//			Set<MerchandiseSubCategory> merchandiseSubCategorySet = merchandiseCategoryRequestDTO
//					.getMerchandiseSubCategory();
//			merchandiseSubCategorySet.forEach((merchandiseSubCategory) -> {
////				merchandiseSubCategory.setMerchandiseCategory(merchandiseCategory);
//
//			});

//			merchandiseCategory.setSubcategory(merchandiseSubCategorySet);
			MerchandiseCategory merchandiseCategoryreturn = merchandiseCategoryRepository.save(merchandiseCategory);
			logger.info("MerchandiseCategoryObject is  updated in DB");
			BeanUtils.copyProperties(merchandiseCategoryreturn, merchandiseCategoryResponseDTO);
			return merchandiseCategoryResponseDTO;
		} catch (Exception e) {
			logger.error(" updateMerchandiseCategory failed" + e);
			throw e;
		}
	}

	/**
	 * retrieveAllMerchandiseCategory
	 * 
	 * @param categorycode
	 * @param MerchandiseCategoryRequestDTO
	 * @return merchandiseCategoryResponseDTO list
	 * @throws Exception
	 */
	public List<MerchandiseCategoryResponseDTO> retrieveAllMerchandiseCategory() throws Exception {

		logger.info("MerchandiseCategory is going to retrieveAllMerchandiseCategory");
		List<MerchandiseCategoryResponseDTO> merchandiseResponseList = new ArrayList<MerchandiseCategoryResponseDTO>();
		try {
			List<MerchandiseCategory> merchandiseCategoryList = merchandiseCategoryRepository.findAll();
			if (merchandiseCategoryList != null && merchandiseCategoryList.size() > 0) {
				merchandiseCategoryList.forEach((merchandiseCategory) -> {
					MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseCategoryResponseDTO();
					BeanUtils.copyProperties(merchandiseCategory, merchandiseCategoryResponseDTO);
					merchandiseResponseList.add(merchandiseCategoryResponseDTO);
				});
				logger.info("MerchandiseCategory is  retrieveAllMerchandiseCategory");
				return merchandiseResponseList;
			}

		} catch (Exception e) {
			logger.error(" retrieveAllMerchandiseCategory failed" + e);
			throw e;
		}
		return merchandiseResponseList;

	}

	/**
	 * findMerchandiseCategoryByID
	 * 
	 * @param categorycode
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */
	public MerchandiseCategoryResponseDTO findMerchandiseCategoryByID(String id) throws Exception {

		logger.info(" Going to retrieveAllMerchafindMerchandiseCategoryByID");

		try {
			MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = new MerchandiseCategoryResponseDTO();
			Optional<MerchandiseCategory> merchandiseCategory = merchandiseCategoryRepository.findById(id);
			if (merchandiseCategory != null) {
				BeanUtils.copyProperties(merchandiseCategory.get(), merchandiseCategoryResponseDTO);
				logger.info("MerchandiseCategory is going to retrieveAllMerchandiseCategory");
				return merchandiseCategoryResponseDTO;
			} else {
				throw new ResourceNotFoundException(ErrorCodes.MERCH_NOT_FOUND.getMessage());
			}
		}

		catch (Exception e) {
			logger.error(" findMerchandiseCategoryByID failed" + e);
			throw e;
		}

	}

	/**
	 * updatePaymentTerms
	 * 
	 * @param termsId,paymentTermsRequestDTO
	 * @return paymentTermsResponseDTO
	 * @throws Exception
	 */
	public PaymentTermsResponseDTO updatePaymentTerms(Long termsId, PaymentTermsRequestDTO paymentTermsRequestDTO)
			throws Exception {

		logger.info("Going to update payment terms");

		try {
			PaymentTermsResponseDTO paymentTermsResponseDTO = new PaymentTermsResponseDTO();
			PaymentTerms paymentTerms = paymentTermsRequestDTO.toModel(paymentTermsRequestDTO);
			paymentTerms.setTerms(termsId);
			PaymentTerms paymentTermsrepo = paymentTermsRepository.save(paymentTerms);
			logger.info("Update payment terms");
			if (paymentTermsrepo != null) {
				BeanUtils.copyProperties(paymentTermsrepo, paymentTermsResponseDTO);
			} else {
				logger.error(" Error in update paymentTerms");
				paymentTermsResponseDTO.setResponseMessage("Error in update paymentTerms");
			}
			return paymentTermsResponseDTO;
		} catch (Exception e) {
			logger.error(" updatePaymentTerms failed" + e);
			throw e;
		}

	}

	/**
	 * savePaymentTerms
	 * 
	 * @param termsId,paymentTermsRequestDTO
	 * @return paymentTermsResponseDTO
	 * @throws Exception
	 */
	public PaymentTermsResponseDTO savePaymentTerms(PaymentTermsRequestDTO paymentTermsRequestDTO) throws Exception {

		logger.info(" PaymentTerms is going to save");
		PaymentTermsResponseDTO paymentTermsResponseDTO = new PaymentTermsResponseDTO();
		try {
			PaymentTerms paymentTerms = paymentTermsRequestDTO.toModel(paymentTermsRequestDTO);
			PaymentTerms paymentTermsrepo = paymentTermsRepository.save(paymentTerms);
			logger.info(" PaymentTerms persisted in Db");
			if (paymentTermsrepo != null) {
				BeanUtils.copyProperties(paymentTermsrepo, paymentTermsResponseDTO);
			} else {
				logger.error(" Error in savePaymentTerms ");
				paymentTermsResponseDTO.setResponseMessage("Error in savePaymentTerms");
			}
			return paymentTermsResponseDTO;
		} catch (Exception e) {
			logger.error(" savePaymentTerms failed" + e);
			throw e;
		}
	}

	/**
	 * findPaymentTermsById
	 * 
	 * @param terms
	 * @return paymentTermsResponseDTO
	 * @throws Exception
	 */

	public PaymentTermsResponseDTO findPaymentTermsById(Long terms) throws Exception {
		logger.info("Going to findPaymentTerms");

		try {
			PaymentTermsResponseDTO paymentTermsResponseDTO = new PaymentTermsResponseDTO();
			Optional<PaymentTerms> paymentTerms = paymentTermsRepository.findById(terms);
			logger.info("findPaymentTermsById");
			if (paymentTerms != null) {
				BeanUtils.copyProperties(paymentTerms.get(), paymentTermsResponseDTO);
				return paymentTermsResponseDTO;
			} else {

				throw new ResourceNotFoundException(ErrorCodes.PAYMENTTERMS_NOT_FOUND.getMessage());
			}

		} catch (Exception e) {
			logger.error(" findPaymentTermsById failed" + e);
			throw e;
		}

	}

	/**
	 * findAllPaymentTerms
	 * 
	 * @return paymentTermsResponseDTO list
	 * @throws Exception
	 */
	public List<PaymentTermsResponseDTO> findAllPaymentTerms() throws Exception {

		logger.info(" RetrieveAllPaymentTerms");
		List<PaymentTermsResponseDTO> termsResponseDTOList = new ArrayList<PaymentTermsResponseDTO>();
		try {
			List<PaymentTerms> paymentTermsList = paymentTermsRepository.findAll();
			if (paymentTermsList != null && paymentTermsList.size() > 0) {
				paymentTermsList.forEach((paymentTerms) -> {
					PaymentTermsResponseDTO paymentTermsResponseDTO = new PaymentTermsResponseDTO();
					BeanUtils.copyProperties(paymentTerms, paymentTermsResponseDTO);
					termsResponseDTOList.add(paymentTermsResponseDTO);

				});
				logger.info("findAllPaymentTerms");
			} else {
				logger.error(" Error findAllPaymentTerms ");

			}

			return termsResponseDTOList;
		} catch (Exception e) {
			logger.error("findAllPaymentTerms" + e);
			throw e;
		}

	}

	/**
	 * This method findBrokersById
	 * 
	 * @param brokerId
	 * @return BrokersResponseDTO
	 * @throws Exception
	 */

	public BrokersResponseDTO findBrokersById(String brokerId) throws Exception {

		logger.info(" Going to findBrokersById");
		BrokersResponseDTO brokersResponseDTO = new BrokersResponseDTO();
		try {
			Optional<Brokers> brokers = brokersRepository.findById(brokerId);
			if (brokers != null) {
				BeanUtils.copyProperties(brokers.get(), brokersResponseDTO);
				logger.info("RetrieveBrokersById");
			} else {
				throw new ResourceNotFoundException(ErrorCodes.BROKER_NOT_FOUND.getMessage());
			}

		} catch (Exception e) {
			logger.error("findBrokersById" + e);
			throw e;
		}
		return brokersResponseDTO;
	}

	/**
	 * This method findAllBrokers
	 * 
	 * @return BrokersResponseDTO list
	 * @throws Exception
	 */
	public List<BrokersResponseDTO> findAllBrokers() throws Exception {

		List<BrokersResponseDTO> brokersResponseDTOsList = new ArrayList<BrokersResponseDTO>();
		logger.info(" Going to retrieveAllBrokers");
		try {
			List<Brokers> brokersList = brokersRepository.findAll();
			if (brokersList != null && brokersList.size() > 0) {
				brokersList.forEach((brokers) -> {
					BrokersResponseDTO brokersResponseDTO = new BrokersResponseDTO();
					BeanUtils.copyProperties(brokers, brokersResponseDTO);
					brokersResponseDTOsList.add(brokersResponseDTO);

				});
				logger.info("findAllBrokers");
			} else {
				logger.error(" Error findAllBrokers ");
			}
			return brokersResponseDTOsList;
		} catch (Exception e) {
			logger.error("findAllBrokers" + e);
			throw e;
		}

	}

	/**
	 * This method saveBrokers
	 * 
	 * @return BrokersResponseDTO
	 * @throws Exception
	 */

	public BrokersResponseDTO saveBrokers(BrokersRequestDTO brokersRequestDTO) throws Exception {
		try {
			logger.info(" Going saveBrokers");
			BrokersResponseDTO brokersResponseDTO = new BrokersResponseDTO();
			Brokers brokers = brokersResponseDTO.toModel(brokersRequestDTO);
			Brokers brokersObj = brokersRepository.save(brokers);
			if (brokersObj != null) {
				logger.info("Broker object persisted");
				BeanUtils.copyProperties(brokersObj, brokersResponseDTO);
			} else {
				logger.error(" Error in persist Broker object ");
				brokersResponseDTO.setResponseMessage("Error in persist Broker object ");
			}
			return brokersResponseDTO;
		} catch (Exception e) {
			logger.error("saveBrokers" + e);
			throw e;
		}
	}

	/**
	 * This method update brokers
	 * 
	 * @return ParcelDetailResponseDTO
	 * @throws Exception
	 */

	public BrokersResponseDTO updateBrokers(String brokerId, BrokersRequestDTO brokersRequestDTO) throws Exception {
		try {

			logger.info(" Going to updateBrokers");
			BrokersResponseDTO brokersResponseDTO = new BrokersResponseDTO();
			Brokers brokers = brokersRequestDTO.toModel(brokersRequestDTO);
			brokers.setBrokerId(brokerId);
			Brokers brokersObjects = brokersRepository.save(brokers);

			if (brokersObjects != null) {
				logger.info("UpdateBrokers");
				BeanUtils.copyProperties(brokersObjects, brokersResponseDTO);
			} else {
				logger.error(" Error in UpdateBrokers ");
				brokersResponseDTO.setResponseMessage("Error in UpdateBrokers");
			}

			return brokersResponseDTO;
		} catch (Exception e) {
			logger.error("updateBrokers" + e);
			throw e;
		}

	}

	/**
	 * This method findParcelDetailsById
	 * 
	 * @return ParcelDetailResponseDTO
	 * @throws Exception
	 */

	public ParcelDetailResponseDTO findParcelDetailsById(String parcelNo) throws Exception {
		ParcelDetailResponseDTO parcelDetailResponseDTO = new ParcelDetailResponseDTO();
		logger.info(" Going findParcelDetails ById");
		try {
			Optional<ParcelDetails> parcel = parcelRepository.findById(parcelNo);
			if (parcel != null) {
				logger.info("Find ParcelDetails ById");
				BeanUtils.copyProperties(parcel.get(), parcelDetailResponseDTO);
				return parcelDetailResponseDTO;
			} else {
				throw new ResourceNotFoundException(ErrorCodes.PARCEL_NOT_FOUND.getMessage());
			}
		} catch (Exception e) {
			logger.error("findParcelDetailsById" + e);
			throw e;
		}

	}

	/**
	 * This method saveParcelDetails
	 * 
	 * @return ParcelDetailResponseDTO
	 * @throws Exception
	 */

	public ParcelDetailResponseDTO saveParcelDetails(ParcelDetailsRequestDTO parcelDetailsRequestDTO) throws Exception {
		ParcelDetailResponseDTO parcelDetailResponseDTO = new ParcelDetailResponseDTO();
		try {
			logger.info(" Going to saveParcelDetails");
			ParcelDetails parcelDetails = parcelDetailsRequestDTO.toModel(parcelDetailsRequestDTO);
			ParcelDetails parcelObj = parcelRepository.save(parcelDetails);
			if (parcelObj != null) {
				logger.info("saveParcelDetails");
				BeanUtils.copyProperties(parcelObj, parcelDetailResponseDTO);
			} else {
				logger.error("saveParcelDetails error");
				parcelDetailResponseDTO.setResponseMessage("saveParcelDetailserror");
			}
			return parcelDetailResponseDTO;
		} catch (Exception e) {
			logger.error("saveParcelDetails" + e);
			throw e;
		}

	}

	/**
	 * This method findAllParcelDetails
	 * 
	 * @return ParcelDetailResponseDTO list
	 * @throws Exception
	 */

	public List<ParcelDetailResponseDTO> findAllParcelDetails() throws Exception {
		List<ParcelDetailResponseDTO> parcelDetailResponseDTOs = new ArrayList<ParcelDetailResponseDTO>();
		logger.info(" Going to retrieveAll parcelDetails");
		try {
			List<ParcelDetails> parcelDetailsList = parcelRepository.findAll();
			if (parcelDetailsList != null && parcelDetailsList.size() > 0) {
				parcelDetailsList.forEach((parcelDetails) -> {
					ParcelDetailResponseDTO parcelDetailResponseDTO = new ParcelDetailResponseDTO();
					BeanUtils.copyProperties(parcelDetails, parcelDetailResponseDTO);
					parcelDetailResponseDTOs.add(parcelDetailResponseDTO);
				});
				logger.info("RetrieveAllParcelDetails");
			} else {
				throw new ResourceNotFoundException(ErrorCodes.PARCEL_NOT_FOUND.getMessage());
			}
			return parcelDetailResponseDTOs;
		} catch (Exception e) {
			logger.error(" Error in findAllParcelDetails" + e);
			throw e;
		}

	}

	/**
	 * This method updates parcel
	 * 
	 * @param parcelId ,parcelDetailsRequestDTO
	 * @return ParcelDetailResponseDTO
	 * @throws Exception
	 */

	public ParcelDetailResponseDTO updateParcelDetails(String parcelId, ParcelDetailsRequestDTO parcelDetailsRequestDTO)
			throws Exception {
		ParcelDetailResponseDTO parcelDetailResponseDTO = new ParcelDetailResponseDTO();
		logger.info("ParcelDetail is going to updated");
		try {
			ParcelDetails parcelDetails = parcelDetailsRequestDTO.toModel(parcelDetailsRequestDTO);
			parcelDetails.setParcelNo(parcelId);
			ParcelDetails parcelObjects = parcelRepository.save(parcelDetails);
			if (parcelObjects != null) {
				BeanUtils.copyProperties(parcelObjects, parcelDetailResponseDTO);
				logger.info("ParcelDetail is updated");
			} else {
				logger.error("updateParcelDetails error");
				parcelDetailResponseDTO.setResponseMessage("update ParcelDetails error");
			}
			return parcelDetailResponseDTO;
		} catch (Exception e) {
			logger.error(" Error in updateParcelDetails" + e);
			throw e;
		}

	}

	/**
	 * This method saveIncidentDetails
	 * 
	 * @param incidentsRequestDTO
	 * @return IncidentsResponseDTO
	 * @throws Exception
	 */

	public IncidentsResponseDTO saveIncidentDetails(IncidentsRequestDTO incidentsRequestDTO) throws Exception {
		logger.info("IncidentDetail is going to save");
		IncidentsResponseDTO incidentsResponseDTO = new IncidentsResponseDTO();
		try {
			Incidents incidents = incidentsRequestDTO.toModel(incidentsRequestDTO);
			if (incidents != null) {
				Incidents incidentObj = incidentsRepository.save(incidents);
				logger.info("IncidentDetails saved");
				BeanUtils.copyProperties(incidentObj, incidentsResponseDTO);
			} else {
				logger.error("saveIncidentDetails error");
				incidentsResponseDTO.setResponseMessage("saveIncidentDetails error");
			}

			return incidentsResponseDTO;
		} catch (Exception e) {
			logger.error(" Error in saveIncidentDetails" + e);
			throw e;
		}

	}

	/**
	 * This method updateIncidentDetails
	 * 
	 * @param incidentId
	 * @return IncidentsResponseDTO
	 * @throws Exception
	 */
	public IncidentsResponseDTO updateIncidentDetails(Long incidentId, IncidentsRequestDTO incidentsRequestDTO)
			throws Exception {
		IncidentsResponseDTO incidentsResponseDTO = new IncidentsResponseDTO();
		try {

			logger.info("Going Update IncidentDetails ");
			Incidents incidents = incidentsRequestDTO.toModel(incidentsRequestDTO);
			incidents.setIncidentId(incidentId);

			Incidents incidentsObj = incidentsRepository.save(incidents);
			if (incidentsObj != null) {
				logger.info("IncidentDetails is updated");
				BeanUtils.copyProperties(incidentsObj, incidentsResponseDTO);
			} else {
				logger.error("IncidentDetails updated error");
				incidentsResponseDTO.setResponseMessage("Update IncidentDetails error");
			}
			return incidentsResponseDTO;
		} catch (Exception e) {
			logger.error(" Error in updateIncidentDetails" + e);
			throw e;
		}

	}

	/**
	 * This method findAllIncidentsDetails
	 * 
	 * @return IncidentsResponseDTO list
	 * @throws Exception
	 */

	public List<IncidentsResponseDTO> findAllIncidentsDetails() throws Exception {
		List<IncidentsResponseDTO> incidentsResponseDTOs = new ArrayList<IncidentsResponseDTO>();
		try {
			logger.info("Going to find all incidents ");
			List<Incidents> incidentsList = incidentsRepository.findAll();
			if (incidentsList != null && incidentsList.size() > 0) {
				incidentsList.forEach((incidents) -> {
					IncidentsResponseDTO incidentsResponseDTO = new IncidentsResponseDTO();
					BeanUtils.copyProperties(incidents, incidentsResponseDTO);
					incidentsResponseDTOs.add(incidentsResponseDTO);

				});
				logger.info("Retrieve All incidents ");

			} else {
				throw new ResourceNotFoundException(ErrorCodes.INCIDENT_NOT_FOUND.getMessage());
			}
			return incidentsResponseDTOs;
		} catch (Exception e) {
			logger.error(" Error in findAllIncidentsDetails" + e);
			throw e;
		}

	}

	/**
	 * This method get incidents object.
	 * 
	 * @param incidentId
	 * @return IncidentsResponseDTO
	 * @throws Exception
	 */
	public IncidentsResponseDTO findIncidentDetailsById(Long id) throws Exception {
		IncidentsResponseDTO incidentsResponseDTO = new IncidentsResponseDTO();
		logger.info("Going to find incidents detailsById");
		try {
			Optional<Incidents> incidents = incidentsRepository.findById(id);
			if (incidents != null) {
				BeanUtils.copyProperties(incidents.get(), incidentsResponseDTO);
				logger.info("Retrieve incidents detailsById");
				return incidentsResponseDTO;
			} else {
				throw new ResourceNotFoundException(ErrorCodes.INCIDENT_NOT_FOUND.getMessage());
			}
		} catch (Exception e) {
			logger.error(" Error in findIncidentDetailsById" + e);
			throw e;
		}

	}

	/**
	 * This method update faq object
	 * 
	 * @return PaymentTermsResponseDTO
	 * @throws Exception
	 */

	public FaqResponseDTO updateFaqDetails(Integer id, FaqDetailsRequestDTO faqDetailsRequestDTO) throws Exception {
		try {
			logger.info("FaqDetails is going to update");
			FaqResponseDTO faqResponseDTO = new FaqResponseDTO();
			FaqDetails faqDetails = faqDetailsRequestDTO.toModel(faqDetailsRequestDTO);
			faqDetails.setId(id);
			FaqDetails faqDetailsObject = faqDetailsRepository.save(faqDetails);
			if (faqDetailsObject != null) {
				logger.info("FaqDetails is updated");
				BeanUtils.copyProperties(faqDetailsObject, faqResponseDTO);
			} else {
				logger.error("FaqDetails updated error");
				faqResponseDTO.setResponseMessage("Update FaqDetails error");
			}
			return faqResponseDTO;
		} catch (Exception e) {
			logger.error(" Error in updateFaqDetails" + e);
			throw e;
		}
	}

	/**
	 * This method save new faq object
	 * 
	 * @return PaymentTermsResponseDTO
	 * @throws Exception
	 */

	public FaqResponseDTO saveFaqDetails(FaqDetailsRequestDTO faqDetailsRequestDTO) throws Exception {
		FaqResponseDTO faqResponseDTO = new FaqResponseDTO();
		try {
			logger.info("FaqDetails is going to save");
			FaqDetails faqDetails = faqDetailsRequestDTO.toModel(faqDetailsRequestDTO);
			FaqDetails faqDetailsObject = faqDetailsRepository.save(faqDetails);
			if (faqDetailsObject != null) {
				logger.info("FaqDetails is saved");
				BeanUtils.copyProperties(faqDetailsObject, faqResponseDTO);
			}

			else {
				logger.error("FaqDetails updated error");
				faqResponseDTO.setResponseMessage("Update FaqDetails error");
			}

			return faqResponseDTO;

		} catch (Exception e) {
			logger.error(" Error in saveFaqDetails" + e);
			throw e;
		}

	}

	/**
	 * This method find faq object.
	 * 
	 * @param id
	 * @return FaqResponseDTO
	 * @throws Exception
	 */

	public FaqResponseDTO findFaqDetailsById(Integer id) throws Exception {
		logger.info(" Going to find FaqDetails ById");
		FaqResponseDTO faqResponseDTO = new FaqResponseDTO();
		try {
			Optional<FaqDetails> faq = faqDetailsRepository.findById(id);
			if (faq != null) {
				logger.info("Retrieve FaqDetails");
				BeanUtils.copyProperties(faq.get(), faqResponseDTO);
				return faqResponseDTO;
			} else {
				throw new ResourceNotFoundException(ErrorCodes.FAQ_NOT_FOUND.getMessage());
			}
		} catch (Exception e) {
			logger.error(" Error findFaqDetailsById" + e);
			throw e;
		}

	}

	/**
	 * This method find all faqs
	 * 
	 * @return FaqResponseDTOList
	 * @throws Exception
	 */
	public List<FaqResponseDTO> findAllFaqDetails() throws Exception {
		logger.info("Going to findAllFaqDetails");
		List<FaqResponseDTO> FaqResponseDTOs = new ArrayList<FaqResponseDTO>();
		try {
			List<FaqDetails> faqList = faqDetailsRepository.findAll();
			faqList.forEach((faqDetails) -> {
				FaqResponseDTO faqResponseDTO = new FaqResponseDTO();
				BeanUtils.copyProperties(faqDetails, faqResponseDTO);
				FaqResponseDTOs.add(faqResponseDTO);
			});
			logger.info("retrieveAllFaqDetails");
			return FaqResponseDTOs;
		} catch (Exception e) {
			logger.error(" Error retrieveAllFaqDetails" + e);
			throw e;
		}

	}

	public BrandResponseDTO getBrandById(Long id) {
		BrandResponseDTO brandRespDTO = new BrandResponseDTO();
		try {
			logger.info("Fetching Brand details....");
			Optional<BrandDetails> brandsOptional = brandRepository.findById(id);
			if (brandsOptional.isPresent()) {
				BrandDetails brands = brandsOptional.get();
				BeanUtils.copyProperties(brands, brandRespDTO);
			} else {
				logger.error("Brand doesn't exist");
				brandRespDTO.setResponseMessage("Brand not found");
			}
		} catch (Exception e) {
			logger.error("Fetch: getBrandById" + e);
			throw e;
		}

		return brandRespDTO;
	}

	/**
	 * This is the main method which is used to save brands
	 * 
	 * @param BrandRequestDTO.
	 * @return BrandResponseDTO.
	 */
	public BrandResponseDTO saveBrands(BrandRequestDTO brandReqDTO) {

		BrandResponseDTO brandsRespDTO = new BrandResponseDTO();
		try {
			BrandDetails brands = brandReqDTO.toModel(brandReqDTO);
			BrandDetails brandsEntity = brandRepository.save(brands);
			if (brandsEntity != null) {
				BeanUtils.copyProperties(brandsEntity, brandsRespDTO);
				logger.info("Brands saved successfully");
			} else {
				logger.error("Failed to save Brands ");
			}
		} catch (Exception e) {
			logger.error("Saving Brands" + e);
			throw e;
		}

		return brandsRespDTO;

	}

	/**
	 * This is the main method which is used to update brands by Id
	 * 
	 * @author amal
	 * @param Long id,BrandRequestDTO.
	 * @return BrandResponseDTO.
	 */
	public BrandResponseDTO updateBrands(Long id, BrandRequestDTO brandReqDTO) {
		BrandResponseDTO savedBrandsRespDTO = new BrandResponseDTO();
		try {
			Optional<BrandDetails> brandsOptional = brandRepository.findById(id);
			if (brandsOptional.isPresent()) {
				BrandDetails newBrands = brandReqDTO.toModel(brandReqDTO);
				newBrands.setBrandId(id);
				BrandDetails brandsEntity = brandRepository.save(newBrands);
				if (brandsEntity != null) {
					BeanUtils.copyProperties(brandsEntity, savedBrandsRespDTO);
					logger.info("Brands up successfully");
				} else {
					logger.info("Brands updation failed");
				}
			} else {
				logger.info("Brands doesn't exist");
				savedBrandsRespDTO.setResponseMessage("Brands doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update :updateBrands" + e);
			throw e;
		}

		return savedBrandsRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all brands
	 */
	public List<BrandDetails> findAllBrands() {
		logger.info("Fetching Brands...");
		return brandRepository.findAll();
	}

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
				arrivalRespDTO.setResponseMessage("Arrivals not found");
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
				logger.info("saved  arrivals successfully");
			} else {
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
					logger.info("Updated  arrivals successfully");
				} else {
					logger.error("Arrivals updation failed");
				}
			} else {
				logger.error("Arrivals doesn't exist");
				savedRespArrivals.setResponseMessage("Arrivals doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update:updateArrivals:" + e);
			throw e;
		}
		return savedRespArrivals;
	}

	/**
	 * @author amal This is the main method which is used to get packing codes by Id
	 */

	public CodesPackingResponseDTO getPackingCodesById(String id) {
		CodesPackingResponseDTO packingRespDTO = new CodesPackingResponseDTO();
		try {
			logger.info("Fetching  arrivals ...");
			Optional<CodesPacking> optionalPacking = codesPackingRepository.findById(id);
			if (optionalPacking.isPresent()) {
				CodesPacking packing = optionalPacking.get();
				BeanUtils.copyProperties(packing, packingRespDTO);
			} else {
				logger.error("Packing codes doesn't exist");
				packingRespDTO.setResponseMessage("Packing codes not found");
			}
		} catch (Exception e) {
			logger.error("Fetch: getPackingCodesById" + e);
			throw e;
		}
		return packingRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all packing codes
	 */
	public List<CodesPacking> findAllPackingCodes() {
		logger.info("Fetching all arrivals ...");
		return codesPackingRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to save packing codes
	 */
	public CodesPackingResponseDTO savePackingCodes(CodesPackingRequestDTO packingCodesReq) {
		CodesPackingResponseDTO packingRespDTO = new CodesPackingResponseDTO();
		try {
			CodesPacking packing = packingCodesReq.toModel(packingCodesReq);
			CodesPacking packingEntity = codesPackingRepository.save(packing);
			if (packingEntity != null) {
				BeanUtils.copyProperties(packingEntity, packingRespDTO);
				logger.info("Saved  packing codes");
			} else {
				logger.error("Failed to save packing codes");
			}
		} catch (Exception e) {
			logger.error("Save:savePackingCodes" + e);
			throw e;
		}
		return packingRespDTO;
	}

	/**
	 * 
	 * @author amal This is the main method which is used to update packing codes
	 */

	public CodesPackingResponseDTO updatePackingCodes(String id, CodesPackingRequestDTO packingCodesReq) {
		CodesPackingResponseDTO savedPackingCodesRespDTO = new CodesPackingResponseDTO();
		try {
			Optional<CodesPacking> packingOptional = codesPackingRepository.findById(id);
			if (packingOptional.isPresent()) {
				CodesPacking newPackCodes = packingCodesReq.toModel(packingCodesReq);
				newPackCodes.setPackingId(id);
				CodesPacking packingEntity = codesPackingRepository.save(newPackCodes);
				if (packingEntity != null) {
					BeanUtils.copyProperties(packingEntity, savedPackingCodesRespDTO);
					logger.info("Updated  packing codes");
				} else {
					logger.error("Packing codes updation failed");
				}
			} else {
				logger.error("Packing codes doesn't exist");
				savedPackingCodesRespDTO.setResponseMessage("Update failed");
			}
		} catch (Exception e) {
			logger.error("Update:updatePackingCodes:" + e);
			throw e;
		}

		return savedPackingCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get shipping codes by
	 *         Id
	 */
	public ShippingCodesResponseDTO getShippingCodesById(String id) {

		ShippingCodesResponseDTO shippingCodesRespDTO = new ShippingCodesResponseDTO();
		try {
			logger.info("Fetching  shipping codes");
			Optional<ShippingCodes> optionalShipping = shippingRepository.findById(id);
			if (optionalShipping.isPresent()) {
				ShippingCodes shippping = optionalShipping.get();
				BeanUtils.copyProperties(shippping, shippingCodesRespDTO);
			} else {
				logger.error("Shipping codes doesn't exist");
				shippingCodesRespDTO.setResponseMessage("Shipping codes not found");
			}
		} catch (Exception e) {
			logger.error("Fetch:getShippingCodesById " + e);
			throw e;
		}
		return shippingCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all shipping codes
	 */

	public List<ShippingCodes> findAllShippingCodes() {
		logger.info("Fetching  shipping codes");
		return shippingRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to get save shipping codes
	 */
	public ShippingCodesResponseDTO saveShippingCodes(ShippingCodesRequestDTO shippingCodesReq) {
		ShippingCodesResponseDTO shippigCodesRespDTO = new ShippingCodesResponseDTO();
		try {
			ShippingCodes shipping = shippingCodesReq.toModel(shippingCodesReq);
			ShippingCodes shippingEntity = shippingRepository.save(shipping);
			if (shippingEntity != null) {
				BeanUtils.copyProperties(shippingEntity, shippigCodesRespDTO);
				logger.info("Saved  shipping codes");
			} else {
				logger.error("Failed to save  shipping codes");
			}
		} catch (Exception e) {
			logger.error("Save:saveShippingCodes " + e);
			throw e;
		}
		return shippigCodesRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get update shipping
	 *         codes
	 * 
	 */

	public ShippingCodesResponseDTO updateShippingCodes(String id, ShippingCodesRequestDTO shippingCodesReq) {
		ShippingCodesResponseDTO updatedRespDTOShippingCodes = new ShippingCodesResponseDTO();
		try {
			Optional<ShippingCodes> packingOptional = shippingRepository.findById(id);
			if (packingOptional.isPresent()) {
				ShippingCodes newShipCodes = shippingCodesReq.toModel(shippingCodesReq);
				newShipCodes.setLocationCode(id);
				ShippingCodes shippingEntity = shippingRepository.save(newShipCodes);
				if (shippingEntity != null) {
					BeanUtils.copyProperties(shippingEntity, updatedRespDTOShippingCodes);
					logger.info("Updated  shipping codes");
				} else {
					logger.error("Shipping codes updation failed");
				}
			} else {
				logger.error(" Shipping codes doesn't exist");
				updatedRespDTOShippingCodes.setResponseMessage("Update failed");
			}
		} catch (Exception e) {
			logger.error("Update:updateShippingCodes " + e);
			throw e;
		}

		return updatedRespDTOShippingCodes;
	}

	/**
	 * @author amal This is the main method which is used to get Rfid By Id
	 */

	public RfidScannerResponseDTO getRfidById(Long id) {
		RfidScannerResponseDTO rfidResponceDTO = new RfidScannerResponseDTO();
		try {
			logger.info("Fetching  Rfids codes...");
			Optional<RfidScanner> optionalRfid = rfidRepository.findById(id);
			if (optionalRfid.isPresent()) {
				RfidScanner rfid = optionalRfid.get();
				BeanUtils.copyProperties(rfid, rfidResponceDTO);
			} else {
				logger.error("Rfid  doesn't exist");
				rfidResponceDTO.setResponseMessage("Rfid not found");
			}
		} catch (Exception e) {
			logger.error("Fetch:getRfidById : " + e);
			throw e;
		}
		return rfidResponceDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all RfidScanner
	 */

	public List<RfidScanner> findAllRfidCodes() {
		logger.info("Fetching all Rfids codes ...");
		return rfidRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to save RfidScanners
	 */

	public RfidScannerResponseDTO saveRfidCodes(RfidRequestDTO rfidCodesReq) {
		RfidScannerResponseDTO rfidResponseDTO = new RfidScannerResponseDTO();
		try {
			RfidScanner rfid = rfidCodesReq.toModel(rfidCodesReq);
			RfidScanner rfidEntity = rfidRepository.save(rfid);
			if (rfidEntity != null) {
				BeanUtils.copyProperties(rfidEntity, rfidResponseDTO);
				logger.info("Saved all Rfids codes");
			} else {
				logger.error("Failed to save Rfids");
			}
		} catch (Exception e) {
			logger.error("Save:saveRfidCodes : " + e);
			throw e;
		}
		return rfidResponseDTO;
	}

	/**
	 * @author amal This is the main method which is used to update RfidScanners
	 */

	public RfidScannerResponseDTO updateRfidCodes(Long id, RfidRequestDTO rfidCodesReq) {
		RfidScannerResponseDTO updatedRfidRespDTO = new RfidScannerResponseDTO();
		try {
			Optional<RfidScanner> packingOptional = rfidRepository.findById(id);
			if (packingOptional.isPresent()) {
				RfidScanner newrfidCodes = rfidCodesReq.toModel(rfidCodesReq);
				newrfidCodes.setUniqueScannerId(id);
				RfidScanner rfidEntity = rfidRepository.save(newrfidCodes);
				if (rfidEntity != null) {
					BeanUtils.copyProperties(rfidEntity, updatedRfidRespDTO);
					logger.info("Updated  Rfids codes");
				} else {
					logger.error("Rfids  update failed");
				}
			} else {
				logger.error("Rfids doesn't exist");
				updatedRfidRespDTO.setResponseMessage("Update failed");
			}
		} catch (Exception e) {
			logger.error("Update:updateRfidCodes " + e);
			throw e;
		}

		return updatedRfidRespDTO;
	}

	/**
	 * @author amal This is the main method which is used to get Company by Id
	 */

	public CompanyResponseDTO getCompanyById(String id) {
		CompanyResponseDTO companyResponceDTO = new CompanyResponseDTO();
		try {
			logger.info("Fetching  Company Data..");
			Optional<CompanyData> optionalcompy = companyRepository.findById(id);
			if (optionalcompy.isPresent()) {
				CompanyData cmpny = optionalcompy.get();
				BeanUtils.copyProperties(cmpny, companyResponceDTO);
			} else {
				logger.error("Company doesn't exist");
				companyResponceDTO.setResponseMessage("Company not found");
			}
		} catch (Exception e) {
			logger.error("Fetch: getCompanyById " + e);
			throw e;
		}
		return companyResponceDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Companies
	 */

	public List<CompanyData> findAllCompanies() {
		logger.info("Fetching all Company Data..");
		return companyRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to save Company data
	 * 
	 */

	public CompanyResponseDTO saveCompanyData(CompanyRequestDTO comapnyReq) {
		CompanyResponseDTO cmpnyResponseDTO = new CompanyResponseDTO();
		try {
			CompanyData cmony = comapnyReq.toModel(comapnyReq);
			CompanyData cmpnyEntity = companyRepository.save(cmony);
			if (cmpnyEntity != null) {
				BeanUtils.copyProperties(cmpnyEntity, cmpnyResponseDTO);
				logger.info("Saved  Company Data successfully");
			} else {
				logger.error("Failed to save  Company Data ");
			}
		} catch (Exception e) {
			logger.error("Save: saveCompanyData " + e);
			throw e;
		}
		return cmpnyResponseDTO;
	}

	/**
	 * @author amal This is the main method which is used to updata Company data by
	 *         id
	 */

	public CompanyResponseDTO updateCompanyData(String companyCode, CompanyRequestDTO cmpnyReqDTO) {
		CompanyResponseDTO updatedCompanyResDTO = new CompanyResponseDTO();
		try {
			Optional<CompanyData> packingOptional = companyRepository.findById(companyCode);
			if (packingOptional.isPresent()) {
				CompanyData newcmpnyCodes = cmpnyReqDTO.toModel(cmpnyReqDTO);
				newcmpnyCodes.setCompanyCode(companyCode);
				CompanyData cmpnyEntity = companyRepository.save(newcmpnyCodes);
				if (cmpnyEntity != null) {
					BeanUtils.copyProperties(cmpnyEntity, updatedCompanyResDTO);
					logger.info("Updated  Company Data successfully");
				} else {
					logger.info("Company Data updation failed");
				}
			} else {
				logger.error("Company Data doesn't exist");
				updatedCompanyResDTO.setResponseMessage("Company Data doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update updateCompanyData " + e);
			throw e;
		}

		return updatedCompanyResDTO;
	}

	/**
	 * @author amal This is the main method which is used to get Credit Card names
	 *         data by id
	 * 
	 */
	public CreditcardResponseDTO getCreditCardById(String id) {
		CreditcardResponseDTO cardResponceDTO = new CreditcardResponseDTO();
		try {
			logger.info("Fetching  Creditcard Names...");
			Optional<CreditcardNames> optionalCreditCard = creditCardRepository.findById(id);
			if (optionalCreditCard.isPresent()) {
				CreditcardNames card = optionalCreditCard.get();
				BeanUtils.copyProperties(card, cardResponceDTO);
			} else {
				logger.error("Creditcard Name doesn't exist");
				cardResponceDTO.setResponseMessage("Credit Card not found");
			}
		} catch (Exception e) {
			logger.error("Fetch: Company " + e);
			throw e;
		}
		return cardResponceDTO;
	}

	/**
	 * @author amal This is the main method which is used to get all Credit Card
	 *         names
	 * 
	 */

	public List<CreditcardNames> findAllCreditCards() {
		logger.info("Fetching all Creditcard Names ...");
		return creditCardRepository.findAll();
	}

	/**
	 * @author amal This is the main method which is used to get save Credit Card
	 *         names
	 * 
	 * @param CreditcardsRequestDTO
	 * @return CreditcardResponseDTO
	 */

	public CreditcardResponseDTO saveCreditCards(CreditcardsRequestDTO creditCardReqDTO) {
		CreditcardResponseDTO cardResponseDTO = new CreditcardResponseDTO();
		try {
			CreditcardNames cardNames = creditCardReqDTO.toModel(creditCardReqDTO);
			CreditcardNames cardEntity = creditCardRepository.save(cardNames);
			if (cardEntity != null) {
				BeanUtils.copyProperties(cardEntity, cardResponseDTO);
				logger.info("Saved  Creditcard Names successfully");
			} else {
				logger.error("Failed to save  Creditcard Names ");
			}
		} catch (Exception e) {
			logger.error("Save: saveCreditCards " + e);
			throw e;
		}
		return cardResponseDTO;
	}

	/**
	 * @author amal This is the main method which is used to get update Credit Card
	 *         names
	 * 
	 * @param CreditcardsRequestDTO,String cardType
	 * @return CreditcardResponseDTO
	 */

	public CreditcardResponseDTO updateCreditCards(String cardType, CreditcardsRequestDTO creditReqDTO) {
		CreditcardResponseDTO updatedCreditCardsrespDTO = new CreditcardResponseDTO();
		try {
			Optional<CreditcardNames> creditCardOptional = creditCardRepository.findById(cardType);
			if (creditCardOptional.isPresent()) {
				CreditcardNames newCreditCards = creditReqDTO.toModel(creditReqDTO);
				newCreditCards.setCardType(cardType);
				CreditcardNames cardEntity = creditCardRepository.save(newCreditCards);
				if (cardEntity != null) {
					BeanUtils.copyProperties(cardEntity, updatedCreditCardsrespDTO);
					logger.info("Updated  Creditcard Names successfully");
				} else {
					logger.error(" Creditcard Names updation failed");
				}
			} else {
				logger.error("Creditcard Names doesn't exist");
				updatedCreditCardsrespDTO.setResponseMessage("Creditcard Names doesn't exist");
			}
		} catch (Exception e) {
			logger.error("Update: updateCreditCards " + e);
			throw e;
		}

		return updatedCreditCardsrespDTO;
	}

	@Override
	public PaymentTermsResponseDTO updatePaymentTerms(Integer terms, PaymentTermsRequestDTO paymentTermsRequestDTO)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentTermsResponseDTO findPaymentTermsById(Integer terms) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
