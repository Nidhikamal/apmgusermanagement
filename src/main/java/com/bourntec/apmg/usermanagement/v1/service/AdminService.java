package com.bourntec.apmg.usermanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.BankAccounts;
import com.bourntec.apmg.entity.BrandDetails;
import com.bourntec.apmg.entity.CodesLocation;
import com.bourntec.apmg.entity.CodesPacking;
import com.bourntec.apmg.entity.CompanyData;
import com.bourntec.apmg.entity.CountryCodes;
import com.bourntec.apmg.entity.CreditcardNames;
import com.bourntec.apmg.entity.CurrencyCode;
import com.bourntec.apmg.entity.LabourCharge;
import com.bourntec.apmg.entity.NewArrivals;
import com.bourntec.apmg.entity.PotentialGroup;
import com.bourntec.apmg.entity.RfidScanner;
import com.bourntec.apmg.entity.ShippingCodes;
import com.bourntec.apmg.entity.VendorCountryCodes;
import com.bourntec.apmg.usermanagement.v1.dto.request.ArrivalsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.BankAccountRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrandRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.BrokersRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CodesLocationRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CodesPackingRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CompanyRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CountryCodesRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CreditcardsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.CurrencyCodeRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.FaqDetailsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.IncidentsRequestDTO;
import com.bourntec.apmg.usermanagement.v1.dto.request.LabourChargeRequestDTO;
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
import com.bourntec.apmg.usermanagement.v1.dto.response.CodesLocationResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CodesPackingResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CompanyResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CountryCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CreditcardResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.CurrencyCodeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.FaqResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.IncidentsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.LabourChargeResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.MerchandiseCategoryResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ParcelDetailResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PaymentTermsResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.PotentialCustomerGroupResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.RfidScannerResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.ShippingCodesResponseDTO;
import com.bourntec.apmg.usermanagement.v1.dto.response.VendorCountryCodesResponseDTO;


public interface AdminService {
	

	CountryCodesResponseDTO saveCustomerCountry(CountryCodesRequestDTO countryRequestDTO);



	CountryCodesResponseDTO updateCountry(String countryCode, CountryCodesRequestDTO countryRequestDTO);



	VendorCountryCodesResponseDTO saveVendorCountry(VendorCountryCodesRequestDTO countryRequestDTO);



	VendorCountryCodesResponseDTO updateVendorCountry(String countryCode, VendorCountryCodesRequestDTO countryRequestDTO);



	CodesLocationResponseDTO saveLocationCode(CodesLocationRequestDTO locationCodeRequestDTO);



	CodesLocationResponseDTO updateLocationCode(String locationCode, CodesLocationRequestDTO locationCodeRequestDTO);



	LabourChargeResponseDTO savelabour(LabourChargeRequestDTO labourChargeRequestDTO);



	LabourChargeResponseDTO updatelabour(Long id, LabourChargeRequestDTO labourChargeRequestDTO);



	PotentialCustomerGroupResponseDTO potentialcustomersave(
			PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO);



	PotentialCustomerGroupResponseDTO updatePotentialcustomer(Long id,
			PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO);



	BankAccountResponsetDTO saveBankAccount(BankAccountRequestDTO bankAccountRequestDTO);



	BankAccountResponsetDTO updateBankAccount(String bankNo, BankAccountRequestDTO bankAccountRequestDTO);



	CurrencyCodeResponseDTO currencyCodesave(CurrencyCodeRequestDTO currencyCodeRequestDTO);



	CurrencyCodeResponseDTO currencyCodeupdate(String currencyCode, CurrencyCodeRequestDTO currencyCodeRequestDTO);






	CountryCodesResponseDTO findBycountryCode(String countryCode);


	VendorCountryCodesResponseDTO findByVendorcountryCode(String countryCode);



	CodesLocationResponseDTO findBylocationCode(String locationCode);



	LabourChargeResponseDTO findBylabourid(Long id);



	PotentialCustomerGroupResponseDTO findBypotentialcustomerid(Long id);



	BankAccountResponsetDTO findBybankNo(String bankNo);



	CurrencyCodeResponseDTO findBycurrencyCode(String currencyCode);



	List<CountryCodes> fetchAllCountryCode();



	List<VendorCountryCodes> findAllVendorCountry();



	List<CodesLocation> findAllLocationcode();



	List<LabourCharge> findAllLabours();



	List<PotentialGroup> findAllPotentialCustomer();



	List<BankAccounts> findAllBankAccounts();



	List<CurrencyCode> findAllCurrencyCode();


	 /* @author vidya.p
		 * save MerchandiseCategory
		 * @param categorycode
		 * @param categorycode
		 * @return merchandiseCategoryResponseDTO
		 * @throws Exception
		 */

		MerchandiseCategoryResponseDTO addMerchandiseCategory(
				MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO)throws Exception;
		/**
		 * update MerchandiseCategory
		 * @param categorycode
		 * @param MerchandiseCategoryRequestDTO
		 * @return merchandiseCategoryResponseDTO
		 * @throws Exception
		 */
		

		MerchandiseCategoryResponseDTO updateMerchandiseCategory(String categoryCode,
				MerchandiseCategoryRequestDTO userRequestDTO)throws Exception;
		/**
		 * findMerchandiseCategoryByID
		 * @param categorycode
		 * @return merchandiseCategoryResponseDTO
		 * @throws Exception
		 */
		MerchandiseCategoryResponseDTO findMerchandiseCategoryByID(String id) throws Exception;
	
		/**
		 * retrieveAllMerchandiseCategory 
		 * @param categorycode
		 * @param MerchandiseCategoryRequestDTO
		 * @return merchandiseCategoryResponseDTO list
		 * @throws Exception
		 */
		List<MerchandiseCategoryResponseDTO> retrieveAllMerchandiseCategory()throws Exception;
		/**
		 * updatePaymentTerms
		 * @param termsId,paymentTermsRequestDTO
		 * @return paymentTermsResponseDTO
		 * @throws Exception
		 */
		PaymentTermsResponseDTO updatePaymentTerms(Integer terms, PaymentTermsRequestDTO paymentTermsRequestDTO)throws Exception;
		/**
		 * savePaymentTerms
		 * @param termsId,paymentTermsRequestDTO
		 * @return paymentTermsResponseDTO
		 * @throws Exception
		 */
		PaymentTermsResponseDTO savePaymentTerms(PaymentTermsRequestDTO paymentTermsRequestDTO)throws Exception;
		/**
		 * findPaymentTermsById
		 * @param terms
		 * @return paymentTermsResponseDTO
		 * @throws Exception
		 */
		
		PaymentTermsResponseDTO findPaymentTermsById(Integer terms)throws Exception;
		/**
		 * findAllPaymentTerms
		 * @return paymentTermsResponseDTO  list
		 * @throws Exception
		 */
		List<PaymentTermsResponseDTO> findAllPaymentTerms()throws Exception;
		/**
		 * This method findBrokersById
		 * @param brokerId
		 * @return BrokersResponseDTO
		 * @throws Exception 
		 */
		BrokersResponseDTO findBrokersById(String brokerId)throws Exception;
		/**
		 * This method findAllBrokers
		 * @return BrokersResponseDTO list
		 * @throws Exception 
		 */
		List<BrokersResponseDTO> findAllBrokers()throws Exception;
		/**
		 * This method saveBrokers
		 * @return BrokersResponseDTO
		 * @throws Exception 
		 */
		BrokersResponseDTO saveBrokers(BrokersRequestDTO brokersRequestDTO)throws Exception;
		/**
		 * This method update brokers
		 * @return ParcelDetailResponseDTO
		 * @throws Exception 
		 */
		BrokersResponseDTO updateBrokers(String brokerId, BrokersRequestDTO brokersRequestDTO)throws Exception;
		/**
		 * This method findParcelDetailsById
		 * @return ParcelDetailResponseDTO
		 * @throws Exception 
		 */
		
		ParcelDetailResponseDTO findParcelDetailsById(String parcelNo)throws Exception;
		/**
		 * This method saveParcelDetails
		 * @return ParcelDetailResponseDTO
		 * @throws Exception 
		 */

		ParcelDetailResponseDTO saveParcelDetails(ParcelDetailsRequestDTO parcelDetailsRequestDTO)throws Exception;
		/**
		 * This method findAllParcelDetails
		 * @return ParcelDetailResponseDTO list
		 * @throws Exception 
		 */

		
		List<ParcelDetailResponseDTO> findAllParcelDetails()throws Exception;
		
		/**
		 * This method updates parcel
		 * @param parcelId ,parcelDetailsRequestDTO
		 * @return ParcelDetailResponseDTO
		 * @throws Exception 
		 */
		ParcelDetailResponseDTO updateParcelDetails(String parcelId, ParcelDetailsRequestDTO parcelDetailsRequestDTO)throws Exception;
		
		/**
		 * This method saveIncidentDetails
		 * @param incidentsRequestDTO
		 * @return IncidentsResponseDTO
		 * @throws Exception 
		 */

		IncidentsResponseDTO saveIncidentDetails(IncidentsRequestDTO incidentsRequestDTO)throws Exception;
		
		/**
		 * This method get all incidents object.
		
		 * @return IncidentsResponseDTO
		 * @throws Exception 
		 */
		List<IncidentsResponseDTO> findAllIncidentsDetails()throws Exception;
		/**
		 * This method updateIncidentDetails
		 * @param incidentId
		 * @return IncidentsResponseDTO
		 * @throws Exception 
		 */
		IncidentsResponseDTO findIncidentDetailsById(Long incidentId)throws Exception;
		/**
		 * This method updateIncidentDetails
		 * @param incidentId
		 * @return IncidentsResponseDTO
		 * @throws Exception 
		 */
		IncidentsResponseDTO updateIncidentDetails(Long incidentId, IncidentsRequestDTO incidentsRequestDTO)throws Exception;
		/**
		 * This method updates faq object.
		 * @param id
		 * @return FaqResponseDTO
		 * @throws Exception 
		 */
		
		FaqResponseDTO updateFaqDetails(Integer id, FaqDetailsRequestDTO faqDetailsRequestDTO)throws Exception;
		/**
		 * This method save new faq object
		 * @return PaymentTermsResponseDTO
		 * @throws Exception 
		 */
		
		FaqResponseDTO saveFaqDetails(FaqDetailsRequestDTO faqDetailsRequestDTO)throws Exception;
		/**
		 * This method get faq object.
		 * @param id
		 * @return FaqResponseDTO
		 * @throws Exception 
		 */
		
		FaqResponseDTO findFaqDetailsById(Integer id)throws Exception;
		/**
		 * This API find all faqs
		 * @return FaqResponseDTO
		 * @throws Exception 
		 */
		List<FaqResponseDTO> findAllFaqDetails()throws Exception;


	/**
	 * @author Amal
	 *
	 */

	BrandResponseDTO getBrandById(Long id);

	List<BrandDetails> findAllBrands();

	BrandResponseDTO saveBrands(BrandRequestDTO brandReq);

	BrandResponseDTO updateBrands(Long id, BrandRequestDTO brandReq);
	
	ArrivalsResponseDTO getArrivalsById(Long id);
	
	List<NewArrivals> findAllNewArrivals();
	
	ArrivalsResponseDTO saveArrivals(ArrivalsRequestDTO arrivalReqDTO);
	
	ArrivalsResponseDTO updateArrivals(Long id,ArrivalsRequestDTO arrivalReqDTO);
	
	CodesPackingResponseDTO getPackingCodesById(String id);

	List<CodesPacking> findAllPackingCodes();

	CodesPackingResponseDTO savePackingCodes(CodesPackingRequestDTO packingCodesReq);

	CodesPackingResponseDTO updatePackingCodes(String id, CodesPackingRequestDTO packingCodesReq);
	
	ShippingCodesResponseDTO getShippingCodesById(String id);

	List<ShippingCodes> findAllShippingCodes();

	ShippingCodesResponseDTO saveShippingCodes(ShippingCodesRequestDTO shippingCodesReq);

	ShippingCodesResponseDTO updateShippingCodes(String id, ShippingCodesRequestDTO shippingCodesReq);
	
	RfidScannerResponseDTO getRfidById(Long id);

	List<RfidScanner> findAllRfidCodes();

	RfidScannerResponseDTO saveRfidCodes(RfidRequestDTO rfidCodesReq);

	RfidScannerResponseDTO updateRfidCodes(Long id, RfidRequestDTO rfidCodesReq);
	
	CompanyResponseDTO getCompanyById(String id);

	List<CompanyData> findAllCompanies();

	CompanyResponseDTO saveCompanyData(CompanyRequestDTO companyReq);

	CompanyResponseDTO updateCompanyData(String id, CompanyRequestDTO cmpnyReqDTO);
	
	CreditcardResponseDTO getCreditCardById(String id);

	List<CreditcardNames> findAllCreditCards();

	CreditcardResponseDTO saveCreditCards(CreditcardsRequestDTO creditreqDTO);

	CreditcardResponseDTO updateCreditCards(String id, CreditcardsRequestDTO creditreqDTO);






	
	
	

}
