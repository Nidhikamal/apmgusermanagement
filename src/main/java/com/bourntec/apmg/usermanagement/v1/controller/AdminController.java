/**
 * 
 */
package com.bourntec.apmg.usermanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.bourntec.apmg.usermanagement.v1.service.AdminService;

/**
 * @author naveen Radhakrishnan
 *
 */

@RestController(value = "AdminController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usermanagement/v3/")
public class AdminController {

	@Autowired
	AdminService adminService;

	/**
	 * This API creates new customer country object
	 * 
	 * @param CountryCodesRequestDTO
	 * @return ResponseEntity<CountrycodeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("customercountry")
	public ResponseEntity<CountryCodesResponseDTO> saveCustomerCountry(@RequestBody CountryCodesRequestDTO countryRequestDTO)
			throws Exception {
		CountryCodesResponseDTO countrycodeResponseDTO = adminService.saveCustomerCountry(countryRequestDTO);
		return ResponseEntity.ok(countrycodeResponseDTO);
	}

	/**
	 * This API updates an customercountry object.
	 * 
	 * @param countryCode
	 * @param CountryCodesRequestDTO
	 * @return ResponseEntity<CountrycodeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("customercountry/{countryCode}")
	public ResponseEntity<CountryCodesResponseDTO> updateCountry(@PathVariable String countryCode,
			@RequestBody CountryCodesRequestDTO countryRequestDTO) throws Exception {
		CountryCodesResponseDTO countrycodeResponseDTO = adminService.updateCountry(countryCode, countryRequestDTO);
		return ResponseEntity.ok(countrycodeResponseDTO);
	}

	/**
	 * This API fetch an customercountry object.
	 * 
	 * @param userId
	 * @return ResponseEntity<CountrycodeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("customercountry/{countryCode}")
	public ResponseEntity<CountryCodesResponseDTO> findBycountryCode(@PathVariable String countryCode) throws Exception {
		CountryCodesResponseDTO countrycodeResponseDTO = adminService.findBycountryCode(countryCode);
		return ResponseEntity.ok(countrycodeResponseDTO);
	}

	/**
	 * This API fetch all fetchAllCountryCode.
	 * 
	 * @return List<CountryCodes>
	 * @throws Exception
	 */

	@GetMapping("customercountry")
	public List<CountryCodes> fetchAllCountryCode() throws Exception {
		List<CountryCodes> countrycodeResponseList = adminService.fetchAllCountryCode();
		return countrycodeResponseList;
	}

	/**
	 * This API creates new VendorCountry object
	 * 
	 * @param VendorCountryCodesRequestDTO
	 * @return ResponseEntity<VendorCountrycodeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("vendorcountry")
	public ResponseEntity<VendorCountryCodesResponseDTO> saveVendorCountry(
			@RequestBody VendorCountryCodesRequestDTO countryRequestDTO) throws Exception {
		VendorCountryCodesResponseDTO vendorCountrycodeResponseDTO = adminService.saveVendorCountry(countryRequestDTO);
		return ResponseEntity.ok(vendorCountrycodeResponseDTO);
	}

	/**
	 * This API updates new VendorCountry object
	 * 
	 * @param VendorCountryCodesRequestDTO
	 * @param countryCode
	 * @return ResponseEntity<VendorCountrycodeResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("vendorcountry/{countryCode}")
	public ResponseEntity<VendorCountryCodesResponseDTO> updateVendorCountry(@PathVariable String countryCode,
			@RequestBody VendorCountryCodesRequestDTO countryRequestDTO) throws Exception {
		VendorCountryCodesResponseDTO countrycodeResponseDTO = adminService.updateVendorCountry(countryCode,
				countryRequestDTO);
		return ResponseEntity.ok(countrycodeResponseDTO);
	}

	/**
	 * This API fetches an VendorCountry object.
	 * 
	 * @param countryCode
	 * @param VendorCountrycodeRequestDTO
	 * @return ResponseEntity<VendorCountrycodeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("vendorcountry/{countryCode}")
	public ResponseEntity<VendorCountryCodesResponseDTO> findByVendorcountryCode(@PathVariable String countryCode)
			throws Exception {
		VendorCountryCodesResponseDTO vendorCountrycodeResponseDTO = adminService.findByVendorcountryCode(countryCode);
		return ResponseEntity.ok(vendorCountrycodeResponseDTO);
	}

	/**
	 * This API fetches an AllCountry object.
	 * 
	 * @return ResponseEntity<VendorCountryCodes>
	 * @throws Exception
	 */

	@GetMapping("vendorcountry")
	public List<VendorCountryCodes> findAllVendorCountry() throws Exception {
		List<VendorCountryCodes> vendorCountryCodesList = adminService.findAllVendorCountry();
		return vendorCountryCodesList;
	}

	/**
	 * This API creates new LocatioCode object
	 * 
	 * @param CodesLocationRequestDTO
	 * @return ResponseEntity<LocationCodeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("locationcode")
	public ResponseEntity<CodesLocationResponseDTO> saveLocationCode(
			@RequestBody CodesLocationRequestDTO locationCodeRequestDTO) throws Exception {
		CodesLocationResponseDTO locationCodeResponseDTO = adminService.saveLocationCode(locationCodeRequestDTO);
		return ResponseEntity.ok(locationCodeResponseDTO);
	}

	/**
	 * This API updates new LocationCode object
	 * 
	 * @param locationCode
	 * @param CodesLocationRequestDTO
	 * @return ResponseEntity<LocationCodeResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("locationcode/{locationCode}")
	public ResponseEntity<CodesLocationResponseDTO> updateLocationcode(@PathVariable String locationCode,
			@RequestBody CodesLocationRequestDTO locationCodeRequestDTO) throws Exception {
		CodesLocationResponseDTO locationCodeResponseDTO = adminService.updateLocationCode(locationCode,
				locationCodeRequestDTO);
		return ResponseEntity.ok(locationCodeResponseDTO);
	}

	/**
	 * This API fetch LocationCode
	 * 
	 * @param locationCode
	 * @return ResponseEntity<LocationCodeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("locationcode/{locationCode}")
	public ResponseEntity<CodesLocationResponseDTO> findBylocationCode(@PathVariable String locationCode)
			throws Exception {
		CodesLocationResponseDTO locationCodeResponseDTO = adminService.findBylocationCode(locationCode);
		return ResponseEntity.ok(locationCodeResponseDTO);
	}

	/**
	 * This API fetchAll new LocationCode Details
	 * 
	 * @param
	 * @return List<LocationCode>
	 * @throws Exception
	 */

	@GetMapping("locationcode")
	public List<CodesLocation> findAllLocationcode() throws Exception {
		List<CodesLocation> locationCodeLists = adminService.findAllLocationcode();
		return locationCodeLists;
	}

	/**
	 * This API creates new LabourCharge object
	 * 
	 * @param LabourChargeRequestDTO
	 * @return ResponseEntity<LabourChargeResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("labourcharge")
	public ResponseEntity<LabourChargeResponseDTO> savelabour(
			@RequestBody LabourChargeRequestDTO labourChargeRequestDTO) throws Exception {
		LabourChargeResponseDTO labourChargeResponseDTO = adminService.savelabour(labourChargeRequestDTO);
		return ResponseEntity.ok(labourChargeResponseDTO);
	}

	/**
	 * This API saves an LabourCharge object.
	 * 
	 * @param id
	 * @param LabourChargeRequestDTO
	 * @return ResponseEntity<LabourChargeResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("labourcharge/{id}")
	public ResponseEntity<LabourChargeResponseDTO> updatelabour(@PathVariable Long id,
			@RequestBody LabourChargeRequestDTO labourChargeRequestDTO) throws Exception {
		LabourChargeResponseDTO labourChargeResponseDTO = adminService.updatelabour(id, labourChargeRequestDTO);
		return ResponseEntity.ok(labourChargeResponseDTO);
	}

	/**
	 * This API LabourCharge fetches LabourCharge details.
	 * 
	 * @param id
	 * @param LabourChargeRequestDTO
	 * @return ResponseEntity<LabourChargeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("labourcharge/{id}")
	public ResponseEntity<LabourChargeResponseDTO> findBylabourid(@PathVariable Long id) throws Exception {
		LabourChargeResponseDTO labourChargeResponseDTO = adminService.findBylabourid(id);
		return ResponseEntity.ok(labourChargeResponseDTO);
	}

	/**
	 * This API LabourCharge findsAll LabourCharge details.
	 * 
	 * @param
	 * @return List<LabourCharge>
	 * @throws Exception
	 */

	@GetMapping("labourcharge")
	public List<LabourCharge> findAllLabours() throws Exception {
		List<LabourCharge> labourChargeLists = adminService.findAllLabours();
		return labourChargeLists;
	}

	/**
	 * This API creates new PotentialCustomer object
	 * 
	 * @param PotentialCustomerGroupRequestDTO
	 * @return ResponseEntity<PotentialCustomerGroupResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("potentialcustomer")
	public ResponseEntity<PotentialCustomerGroupResponseDTO> potentialcustomersave(
			@RequestBody PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO) throws Exception {
		PotentialCustomerGroupResponseDTO potentialCustomerGroupResponseDTO = adminService
				.potentialcustomersave(potentialCustomerGroupRequestDTO);
		return ResponseEntity.ok(potentialCustomerGroupResponseDTO);
	}

	/**
	 * This API updates PotentialCustomer details
	 * 
	 * @param id
	 * @param PotentialCustomerGroupRequestDTO
	 * @return ResponseEntity<PotentialCustomerGroupResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("potentialcustomer/{id}")
	public ResponseEntity<PotentialCustomerGroupResponseDTO> potentialcustomersave(@PathVariable Long id,
			@RequestBody PotentialCustomerGroupRequestDTO potentialCustomerGroupRequestDTO) throws Exception {
		PotentialCustomerGroupResponseDTO potentialCustomerGroupResponseDTO = adminService.updatePotentialcustomer(id,
				potentialCustomerGroupRequestDTO);
		return ResponseEntity.ok(potentialCustomerGroupResponseDTO);
	}

	/**
	 * This API fetches PotentialCustomer details
	 * 
	 * @param id
	 * @return ResponseEntity<PotentialCustomerGroupResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("potentialcustomer/{id}")
	public ResponseEntity<PotentialCustomerGroupResponseDTO> findBypotentialcustomerid(@PathVariable Long id)
			throws Exception {
		PotentialCustomerGroupResponseDTO potentialCustomerGroupResponseDTO = adminService
				.findBypotentialcustomerid(id);
		return ResponseEntity.ok(potentialCustomerGroupResponseDTO);
	}

	/**
	 * This API fetches all PotentialCustomer details.
	 * 
	 * @return List<PotentialCustomerGroup>
	 * @throws Exception
	 */

	@GetMapping("potentialcustomer")
	public List<PotentialGroup> findAllPotentialCustomer() throws Exception {
		List<PotentialGroup> potentialCustomerGroupList = adminService.findAllPotentialCustomer();
		return potentialCustomerGroupList;
	}

	/**
	 * This API saves BankAccount details
	 * 
	 * @param bankNo
	 * @param BankAccountRequestDTO
	 * @return ResponseEntity<BankAccountResponsetDTO>
	 * @throws Exception
	 */

	@PostMapping("bankaccount")
	public ResponseEntity<BankAccountResponsetDTO> bankAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO)
			throws Exception {
		BankAccountResponsetDTO bankAccountResponsetDTO = adminService.saveBankAccount(bankAccountRequestDTO);
		return ResponseEntity.ok(bankAccountResponsetDTO);
	}

	/**
	 * This API updates BankAccount details
	 * 
	 * @param bankNo
	 * @param BankAccountRequestDTO
	 * @return ResponseEntity<BankAccountResponsetDTO>
	 * @throws Exception
	 */
	@PutMapping("bankaccount/{bankNo}")
	public ResponseEntity<BankAccountResponsetDTO> bankAccount(@PathVariable String bankNo,
			@RequestBody BankAccountRequestDTO bankAccountRequestDTO) throws Exception {
		BankAccountResponsetDTO bankAccountResponsetDTO = adminService.updateBankAccount(bankNo, bankAccountRequestDTO);
		return ResponseEntity.ok(bankAccountResponsetDTO);
	}

	/**
	 * This API fetches BankAccount details
	 * 
	 * @param bankNo
	 * @return ResponseEntity<BankAccountResponsetDTO>
	 * @throws Exception
	 */

	@GetMapping("bankaccount/{bankNo}")
	public ResponseEntity<BankAccountResponsetDTO> bankAccount(@PathVariable String bankNo) throws Exception {
		BankAccountResponsetDTO bankAccountResponsetDTO = adminService.findBybankNo(bankNo);
		return ResponseEntity.ok(bankAccountResponsetDTO);
	}

	/**
	 * This API fetches all BankAccount details.
	 * 
	 * @return List<CurrencyCode>
	 * @throws Exception
	 */
	@GetMapping("bankaccount")
	public List<BankAccounts> findAllBankAccounts() throws Exception {
		List<BankAccounts> bankAccountsList = adminService.findAllBankAccounts();
		return bankAccountsList;
	}

	/**
	 * This API saves Currency details
	 * 
	 * @param CurrencyCodeRequestDTO
	 * @return ResponseEntity<CurrencyCodeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("currency")
	public ResponseEntity<CurrencyCodeResponseDTO> bankAccount(
			@RequestBody CurrencyCodeRequestDTO currencyCodeRequestDTO) throws Exception {
		CurrencyCodeResponseDTO currencyCodeResponseDTO = adminService.currencyCodesave(currencyCodeRequestDTO);
		return ResponseEntity.ok(currencyCodeResponseDTO);
	}

	/**
	 * This API updates Currency details
	 * 
	 * @param CurrencyCodeRequestDTO
	 * @return ResponseEntity<CurrencyCodeResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("currency/{currencyCode}")
	public ResponseEntity<CurrencyCodeResponseDTO> bankAccount(@PathVariable String currencyCode,
			@RequestBody CurrencyCodeRequestDTO currencyCodeRequestDTO) throws Exception {
		CurrencyCodeResponseDTO currencyCodeResponseDTO = adminService.currencyCodeupdate(currencyCode,
				currencyCodeRequestDTO);
		return ResponseEntity.ok(currencyCodeResponseDTO);
	}

	/**
	 * This API fetches Currency details
	 * 
	 * @param currencyCode
	 * @return ResponseEntity<CurrencyCodeResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("currency/{currencyCode}")
	public ResponseEntity<CurrencyCodeResponseDTO> findBycurrencyCode(@PathVariable String currencyCode)
			throws Exception {
		CurrencyCodeResponseDTO currencyCodeResponseDTO = adminService.findBycurrencyCode(currencyCode);
		return ResponseEntity.ok(currencyCodeResponseDTO);
	}

	/**
	 * This API fetches all Currency details.
	 * 
	 * @return List<CurrencyCode>
	 * @throws Exception
	 */
	@GetMapping("currency")
	public List<CurrencyCode> findAllCurrencyCode() throws Exception {
		List<CurrencyCode> currencyCodesList = adminService.findAllCurrencyCode();
		return currencyCodesList;
	}

	/**
	 * Controller
	 * 
	 * @param categorycode
	 * @param categorycode
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */

	@GetMapping("merchandisecategory/{categorycode}")
	public ResponseEntity<MerchandiseCategoryResponseDTO> fetchMerchandiseCategoryById(
			@PathVariable String categorycode) throws Exception {
		MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = adminService
				.findMerchandiseCategoryByID(categorycode);
		return ResponseEntity.ok(merchandiseCategoryResponseDTO);
	}

	/**
	 * Controller
	 * 
	 * @return merchandiseCategoryResponseDTO
	 * @throws Exception
	 */

	@GetMapping("merchandisecategory")
	public ResponseEntity<List<MerchandiseCategoryResponseDTO>> fetchAllMerchandiseCategory() throws Exception {
		List<MerchandiseCategoryResponseDTO> merchResponseList = adminService.retrieveAllMerchandiseCategory();
		return ResponseEntity.ok(merchResponseList);
	}

	/**
	 * This API save new merchandise category
	 * 
	 * @param merchandiseCategoryRequestDTO
	 * @return ResponseEntity<merchandiseCategoryResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("merchandisecategory")
	public ResponseEntity<MerchandiseCategoryResponseDTO> saveMarchandiseCategory(
			@RequestBody MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO) throws Exception {
		MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = adminService
				.addMerchandiseCategory(merchandiseCategoryRequestDTO);
		return ResponseEntity.ok(merchandiseCategoryResponseDTO);
	}

	/**
	 * This API updates an merchandiseCategory object.
	 * 
	 * @param categoryCode
	 * @param merchandiseCategoryRequestDTO
	 * @return ResponseEntity<MerchandiseCategoryResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("merchandisecategory/{categoryCode}")
	public ResponseEntity<MerchandiseCategoryResponseDTO> merchandiseCategory(@PathVariable String categoryCode,
			@RequestBody MerchandiseCategoryRequestDTO merchandiseCategoryRequestDTO) throws Exception {
		MerchandiseCategoryResponseDTO merchandiseCategoryResponseDTO = adminService
				.updateMerchandiseCategory(categoryCode, merchandiseCategoryRequestDTO);
		return ResponseEntity.ok(merchandiseCategoryResponseDTO);
	}

	/**
	 * This API save new paymentTerms
	 * 
	 * @param PaymentTermsRequestDTO
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("paymentterms")
	public ResponseEntity<PaymentTermsResponseDTO> savePaymentTerms(
			@RequestBody PaymentTermsRequestDTO paymentTermsRequestDTO) throws Exception {
		PaymentTermsResponseDTO paymentTermsResponseDTO = adminService.savePaymentTerms(paymentTermsRequestDTO);
		return ResponseEntity.ok(paymentTermsResponseDTO);
	}

	/**
	 * This API updates PaymentTerms .
	 * 
	 * @param terms
	 * @param String terms PaymentTermsRequestDTO
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("paymenterms/{terms}")
	public ResponseEntity<PaymentTermsResponseDTO> updatePaymentTerms(@PathVariable Integer terms,
			@RequestBody PaymentTermsRequestDTO paymentTermsRequestDTO) throws Exception {
		PaymentTermsResponseDTO paymentTermsResponseDTO = adminService.updatePaymentTerms(terms,
				paymentTermsRequestDTO);
		return ResponseEntity.ok(paymentTermsResponseDTO);
	}

	/**
	 * This API get PaymentTerms .
	 * 
	 * @param String termsId
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("paymentterms/{terms}")
	public ResponseEntity<PaymentTermsResponseDTO> findPaymentTermsById(@PathVariable Integer terms) throws Exception {
		PaymentTermsResponseDTO paymentTermsResponseDTO = adminService.findPaymentTermsById(terms);
		return ResponseEntity.ok(paymentTermsResponseDTO);
	}

	/**
	 * This API get PaymentTerms .
	 * 
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("paymentterms")
	public ResponseEntity<List<PaymentTermsResponseDTO>> findAllPaymentTerms() throws Exception {
		List<PaymentTermsResponseDTO> paymentTermsResponseDTOList = adminService.findAllPaymentTerms();
		return ResponseEntity.ok(paymentTermsResponseDTOList);
	}

	/**
	 * This API save new broker object
	 * 
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("broker")
	public ResponseEntity<BrokersResponseDTO> saveBrokers(@RequestBody BrokersRequestDTO brokersRequestDTO)
			throws Exception {
		BrokersResponseDTO brokersResponseDTO = adminService.saveBrokers(brokersRequestDTO);
		return ResponseEntity.ok(brokersResponseDTO);
	}

	/**
	 * This API get brokerby id
	 * 
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("broker/{brokerId}")
	public ResponseEntity<BrokersResponseDTO> findBrokerById(@PathVariable String brokerId) throws Exception {
		BrokersResponseDTO brokersResponseDTO = adminService.findBrokersById(brokerId);
		return ResponseEntity.ok(brokersResponseDTO);
	}

	/**
	 * This API get all brokers
	 * 
	 * @return ResponseEntity<BrokersResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("broker")
	public ResponseEntity<List<BrokersResponseDTO>> findAllBrokers() throws Exception {
		List<BrokersResponseDTO> brokersResponseDTOList = adminService.findAllBrokers();
		return ResponseEntity.ok(brokersResponseDTOList);
	}

	/**
	 * This API updates broker object.
	 * 
	 * @param brokerId
	 * @param String   brokerId
	 * @return ResponseEntity<BrokersResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("broker/{brokerId}")
	public ResponseEntity<BrokersResponseDTO> updateBrokers(@PathVariable String brokerId,
			@RequestBody BrokersRequestDTO brokersRequestDTO) throws Exception {
		BrokersResponseDTO brokersResponseDTO = adminService.updateBrokers(brokerId, brokersRequestDTO);
		return ResponseEntity.ok(brokersResponseDTO);
	}

	/**
	 * This API creates parcel
	 * 
	 * @param parcelDetailsRequestDTO
	 * @return ResponseEntity<ParcelDetailResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("parcel")
	public ResponseEntity<ParcelDetailResponseDTO> saveParcelDetails(
			@RequestBody ParcelDetailsRequestDTO parcelDetailsRequestDTO) throws Exception {

		ParcelDetailResponseDTO parcelDetailResponseDTO = adminService.saveParcelDetails(parcelDetailsRequestDTO);
		return ResponseEntity.ok(parcelDetailResponseDTO);
	}

	/**
	 * This API updates parcel
	 * 
	 * @param parcelId
	 * @return ResponseEntity<ParcelDetailResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("parcel/{parcelId}")
	public ResponseEntity<ParcelDetailResponseDTO> updateParcelDetails(@PathVariable String parcelId,
			@RequestBody ParcelDetailsRequestDTO parcelDetailsRequestDTO) throws Exception {
		ParcelDetailResponseDTO parcelDetailResponseDTO = adminService.updateParcelDetails(parcelId,
				parcelDetailsRequestDTO);
		return ResponseEntity.ok(parcelDetailResponseDTO);
	}

	/**
	 * This API get parcel
	 * 
	 * @param parcelId
	 * @return ResponseEntity<ParcelDetailResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("parcel/{parcelId}")
	public ResponseEntity<ParcelDetailResponseDTO> findParcelDetailsById(@PathVariable String parcelId)
			throws Exception {
		ParcelDetailResponseDTO parcelDetailResponseDTO = adminService.findParcelDetailsById(parcelId);
		return ResponseEntity.ok(parcelDetailResponseDTO);
	}

	/**
	 * This API get all parcel objects
	 * 
	 * @return ResponseEntity<ParcelDetailResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("parcel")
	public ResponseEntity<List<ParcelDetailResponseDTO>> findAllParcelDetails() throws Exception {
		List<ParcelDetailResponseDTO> brokersResponseDTOList = adminService.findAllParcelDetails();
		return ResponseEntity.ok(brokersResponseDTOList);
	}

	/**
	 * This API save incidents
	 * 
	 * @param incidentsRequestDTO
	 * @return ResponseEntity<IncidentsResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("incidents")
	public ResponseEntity<IncidentsResponseDTO> saveIncidentDetails(
			@RequestBody IncidentsRequestDTO incidentsRequestDTO) throws Exception {

		IncidentsResponseDTO incidentsResponseDTO = adminService.saveIncidentDetails(incidentsRequestDTO);
		return ResponseEntity.ok(incidentsResponseDTO);
	}

	/**
	 * This API updates Pobject.
	 * 
	 * @param incidentId
	 * @return ResponseEntity<IncidentsResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("incidents/{incidentId}")
	public ResponseEntity<IncidentsResponseDTO> updateIncidentDetails(@PathVariable Long incidentId,
			@RequestBody IncidentsRequestDTO incidentsRequestDTO) throws Exception {
		IncidentsResponseDTO incidentsResponseDTO = adminService.updateIncidentDetails(incidentId, incidentsRequestDTO);
		return ResponseEntity.ok(incidentsResponseDTO);
	}

	/**
	 * This API get incidents object.
	 * 
	 * @param incidentId
	 * @return ResponseEntity<IncidentsResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("incidents/{incidentId}")
	public ResponseEntity<IncidentsResponseDTO> findIncidentDetailsById(@PathVariable Long incidentId)
			throws Exception {
		IncidentsResponseDTO incidentsResponseDTO = adminService.findIncidentDetailsById(incidentId);
		return ResponseEntity.ok(incidentsResponseDTO);
	}

	/**
	 * This API get all incidents object.
	 * 
	 * @return ResponseEntity<IncidentsResponseDTO>
	 * @throws Exception
	 */
	/**
	 * This API get incidents object.
	 * 
	 * @param find all
	 * @return ResponseEntity<IncidentsResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("incidents")
	public ResponseEntity<List<IncidentsResponseDTO>> findAllIncidents() throws Exception {
		List<IncidentsResponseDTO> incidentsResponseDTOs = adminService.findAllIncidentsDetails();
		return ResponseEntity.ok(incidentsResponseDTOs);
	}

	/**
	 * This API save new faq object
	 * 
	 * @return ResponseEntity<PaymentTermsResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("faq")
	public ResponseEntity<FaqResponseDTO> saveFaq(@RequestBody FaqDetailsRequestDTO faqDetailsRequestDTO)
			throws Exception {

		FaqResponseDTO faqResponseDTO = adminService.saveFaqDetails(faqDetailsRequestDTO);
		return ResponseEntity.ok(faqResponseDTO);
	}

	/**
	 * This API updates faq object.
	 * 
	 * @param id
	 * @return ResponseEntity<FaqResponseDTO>
	 * @throws Exception
	 */
	@PutMapping("faq/{id}")
	public ResponseEntity<FaqResponseDTO> updateFaqDetails(@PathVariable Integer id,
			@RequestBody FaqDetailsRequestDTO faqDetailsRequestDTO) throws Exception {
		FaqResponseDTO faqResponseDTO = adminService.updateFaqDetails(id, faqDetailsRequestDTO);
		return ResponseEntity.ok(faqResponseDTO);
	}

	/**
	 * This API get faq object.
	 * 
	 * @param id
	 * @return ResponseEntity<FaqResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("faq/{id}")
	public ResponseEntity<FaqResponseDTO> findFaqDetailsById(@PathVariable Integer id) throws Exception {
		FaqResponseDTO faqResponseDTO = adminService.findFaqDetailsById(id);
		return ResponseEntity.ok(faqResponseDTO);
	}

	/**
	 * This API find all faqs
	 * 
	 * @return ResponseEntity<FaqResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("faq")
	public ResponseEntity<List<FaqResponseDTO>> findAllFaq() throws Exception {
		List<FaqResponseDTO> faqResponseDTOs = adminService.findAllFaqDetails();
		return ResponseEntity.ok(faqResponseDTOs);
	}

	/**
	 * This REST endpoint exposes the search interface for returning all brand
	 * details
	 * 
	 * @param
	 * @return ResponseEntity<BrandDetails>
	 */
	@GetMapping("brands")
	public ResponseEntity<List<BrandDetails>> fetchAllBrands() throws Exception {

		List<BrandDetails> allBrands = adminService.findAllBrands();
		return ResponseEntity.ok(allBrands);
	}

	/**
	 * This REST endpoint exposes the search interface for returning brand by id
	 * 
	 * @param
	 * @return ResponseEntity<BrandResponseDTO>
	 */

	@GetMapping("brands/{brandId}")
	public ResponseEntity<BrandResponseDTO> fetchByBrandId(@PathVariable Long brandId) throws Exception {

		BrandResponseDTO selectedBrands = adminService.getBrandById(brandId);

		return ResponseEntity.ok(selectedBrands);
	}

	/**
	 * This REST endpoint exposes the search interface for saving brand
	 * 
	 * @param
	 * @return ResponseEntity<BrandResponseDTO>
	 */

	@PostMapping("brands")
	public ResponseEntity<BrandResponseDTO> saveBrandDetails(@RequestBody BrandRequestDTO brandsreqDTO)
			throws Exception {

		BrandResponseDTO savedrespBrands = adminService.saveBrands(brandsreqDTO);

		return ResponseEntity.ok(savedrespBrands);

	}

	/**
	 * This REST endpoint exposes the search interface for updating brand by Id
	 * 
	 * @param
	 * @return ResponseEntity<BrandDetails>
	 */

	@PutMapping("brands/{brandId}")
	public ResponseEntity<Object> updateBrands(@RequestBody BrandRequestDTO brandsreqDTO, @PathVariable Long brandId)
			throws Exception {

		BrandResponseDTO updatedrespBrands = adminService.updateBrands(brandId, brandsreqDTO);
		return ResponseEntity.ok(updatedrespBrands);
	}

	/**
	 * This REST endpoint exposes the search interface for returning all new
	 * Arrivals
	 * 
	 * @param
	 * @return ResponseEntity<NewArrivals>
	 */

	@GetMapping("newarrivals")
	public ResponseEntity<List<NewArrivals>> fetchAllnewArrivals() throws Exception {

		List<NewArrivals> allArrivals = adminService.findAllNewArrivals();
		return ResponseEntity.ok(allArrivals);
	}

	/**
	 * This REST endpoint exposes the search interface for returning arrivals by id
	 * 
	 * @param Long id
	 * @return ResponseEntity<ArrivalsResponseDTO>
	 */

	@GetMapping("newarrivals/{id}")
	public ResponseEntity<ArrivalsResponseDTO> fetchById(@PathVariable Long id) throws Exception {

		ArrivalsResponseDTO selectedArrivals = adminService.getArrivalsById(id);

		return ResponseEntity.ok(selectedArrivals);
	}

	/**
	 * This REST endpoint exposes the search interface for saving arrivals
	 * 
	 * @param
	 * @return ResponseEntity<ArrivalsResponseDTO>
	 */

	@PostMapping("newarrivals")
	public ResponseEntity<ArrivalsResponseDTO> saveNewArrivals(@RequestBody ArrivalsRequestDTO arrivalsreqDTO)
			throws Exception {

		ArrivalsResponseDTO savedrespArrivals = adminService.saveArrivals(arrivalsreqDTO);

		return ResponseEntity.ok(savedrespArrivals);

	}

	/**
	 * This REST endpoint exposes the search interface for updating arrivals by Id
	 * 
	 * @param ArrivalsRequestDTO,Long id
	 * @return ResponseEntity<BrandDetails>
	 */
	@PutMapping("newarrivals/{id}")
	public ResponseEntity<Object> updateArrivals(@RequestBody ArrivalsRequestDTO arrivalsreqDTO, @PathVariable Long id)
			throws Exception {

		ArrivalsResponseDTO updatedrespArrivals = adminService.updateArrivals(id, arrivalsreqDTO);
		return ResponseEntity.ok(updatedrespArrivals);
	}

	/**
	 * This REST endpoint exposes the search interface for returning packing codes
	 * by id
	 * 
	 * @param String id
	 * @return ResponseEntity<CodesPackingResponseDTO>
	 */

	@GetMapping("codespacking/{id}")
	public ResponseEntity<CodesPackingResponseDTO> fetchById(@PathVariable String id) throws Exception {

		CodesPackingResponseDTO selectedpackingcodes = adminService.getPackingCodesById(id);

		return ResponseEntity.ok(selectedpackingcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for saving packing codes
	 * 
	 * @param CodesPackingRequestDTO
	 * @return ResponseEntity<CodesPackingResponseDTO>
	 */

	@PostMapping("codespacking")
	public ResponseEntity<CodesPackingResponseDTO> savePackingCodes(@RequestBody CodesPackingRequestDTO packingcodesreq)
			throws Exception {

		CodesPackingResponseDTO savedresppacking = adminService.savePackingCodes(packingcodesreq);

		return ResponseEntity.ok(savedresppacking);

	}

	/**
	 * This REST endpoint exposes the search interface for updating packing codes by
	 * Id
	 * 
	 * @param CodesPackingRequestDTO,String id
	 * @return ResponseEntity<CodesPackingResponseDTO>
	 */
	@PutMapping("codespacking/{id}")
	public ResponseEntity<Object> updateCodespacking(@RequestBody CodesPackingRequestDTO packingcodesreq,
			@PathVariable String id) throws Exception {

		CodesPackingResponseDTO updatedrespcodespack = adminService.updatePackingCodes(id, packingcodesreq);
		return ResponseEntity.ok(updatedrespcodespack);
	}

	@GetMapping("codespacking")
	public ResponseEntity<List<CodesPacking>> fetchAllpackingCodes() throws Exception {

		List<CodesPacking> allpackingCodes = adminService.findAllPackingCodes();
		return ResponseEntity.ok(allpackingCodes);
	}

	/**
	 * This REST endpoint exposes the search interface for saving shipping codes
	 * 
	 * @param
	 * @return ResponseEntity<ShippingCodesResponseDTO>
	 */

	@PostMapping("shippingcodes")
	public ResponseEntity<ShippingCodesResponseDTO> saveShippingCodes(
			@RequestBody ShippingCodesRequestDTO shippingcodesreq) throws Exception {

		ShippingCodesResponseDTO savedresppacking = adminService.saveShippingCodes(shippingcodesreq);

		return ResponseEntity.ok(savedresppacking);

	}

	/**
	 * This REST endpoint exposes the search interface for returning shipping codes
	 * by id
	 * 
	 * @param String id
	 * @return ResponseEntity<ShippingCodesResponseDTO>
	 */

	@GetMapping("shippingcodes/{id}")
	public ResponseEntity<ShippingCodesResponseDTO> fetchShippingCodesById(@PathVariable String id) throws Exception {

		ShippingCodesResponseDTO selectedpackingcodes = adminService.getShippingCodesById(id);

		return ResponseEntity.ok(selectedpackingcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for update shipping codes by
	 * id
	 * 
	 * @param ShippingCodesRequestDTO,String id
	 * @return ResponseEntity<ShippingCodesResponseDTO>
	 */

	@PutMapping("shippingcodes/{id}")
	public ResponseEntity<ShippingCodesResponseDTO> updateShippingCodes(@RequestBody ShippingCodesRequestDTO shippingcodesreq,
			@PathVariable String id) throws Exception {

		ShippingCodesResponseDTO updatedshippingcodes = adminService.updateShippingCodes(id, shippingcodesreq);
		return ResponseEntity.ok(updatedshippingcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for returning all shipping
	 * codes
	 * 
	 * @param
	 * @return ResponseEntity<ShippingCodesResponseDTO>
	 */

	@GetMapping("shippingcodes")
	public ResponseEntity<List<ShippingCodes>> fetchAllshippingCodes() throws Exception {

		List<ShippingCodes> allshippingcodes = adminService.findAllShippingCodes();
		return ResponseEntity.ok(allshippingcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for saving rfid scanner
	 * 
	 * @param RfidRequestDTO
	 * @return ResponseEntity<RfidScannerResponseDTO>
	 */

	@PostMapping("rfidscanner")
	public ResponseEntity<RfidScannerResponseDTO> saveRfid(@RequestBody RfidRequestDTO rfidcodesreq) throws Exception {

		RfidScannerResponseDTO savedresppacking = adminService.saveRfidCodes(rfidcodesreq);

		return ResponseEntity.ok(savedresppacking);

	}

	/**
	 * This REST endpoint exposes the search interface for returning rfid by id
	 * 
	 * @param Long id
	 * @return ResponseEntity<RfidScannerResponseDTO>
	 */

	@GetMapping("rfidscanner/{id}")
	public ResponseEntity<RfidScannerResponseDTO> fetchRfidById(@PathVariable Long id) throws Exception {

		RfidScannerResponseDTO selectedrfidcodes = adminService.getRfidById(id);

		return ResponseEntity.ok(selectedrfidcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for updating rfid scanner by
	 * id
	 * 
	 * @param RfidRequestDTO,Long id
	 * @return ResponseEntity<RfidScannerResponseDTO>
	 */

	@PutMapping("rfidscanner/{id}")
	public ResponseEntity<Object> updateupdateRfid(@RequestBody RfidRequestDTO rfidcodesreq, @PathVariable Long id)
			throws Exception {

		RfidScannerResponseDTO updatedrfidcodes = adminService.updateRfidCodes(id, rfidcodesreq);
		return ResponseEntity.ok(updatedrfidcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for fetching all rfid scanner
	 * codes
	 * 
	 * @param
	 * @return ResponseEntity<RfidScanner>
	 */
	@GetMapping("rfidscanner")
	public ResponseEntity<List<RfidScanner>> fetchAllsRfidCodes() throws Exception {

		List<RfidScanner> allrfidcodes = adminService.findAllRfidCodes();
		return ResponseEntity.ok(allrfidcodes);
	}

	/**
	 * This REST endpoint exposes the search interface for saving company data
	 * 
	 * @param CompanyRequestDTO
	 * @return ResponseEntity<CompanyResponseDTO>
	 */

	@PostMapping("companydata")
	public ResponseEntity<CompanyResponseDTO> saveCompanyData(@RequestBody CompanyRequestDTO cmpnyreqDTO)
			throws Exception {

		CompanyResponseDTO savedrespcompany = adminService.saveCompanyData(cmpnyreqDTO);

		return ResponseEntity.ok(savedrespcompany);

	}

	/**
	 * This REST endpoint exposes the search interface for returning Company Data by
	 * id
	 * 
	 * @param String id
	 * @return ResponseEntity<CompanyResponseDTO>
	 */

	@GetMapping("companydata/{id}")
	public ResponseEntity<CompanyResponseDTO> fetchCompanydataById(@PathVariable String id) throws Exception {

		CompanyResponseDTO selectedcompanydata = adminService.getCompanyById(id);

		return ResponseEntity.ok(selectedcompanydata);
	}

	/**
	 * This REST endpoint exposes the search interface for updating company by Id
	 * 
	 * @param CompanyRequestDTO,String id
	 * @return ResponseEntity<CompanyResponseDTO>
	 */
	@PutMapping("companydata/{id}")
	public ResponseEntity<CompanyResponseDTO> updateCompanydataById(@RequestBody CompanyRequestDTO cmpnyreqDTO,
			@PathVariable String id) throws Exception {

		CompanyResponseDTO updatedCompanyData = adminService.updateCompanyData(id, cmpnyreqDTO);
		return ResponseEntity.ok(updatedCompanyData);
	}

	/**
	 * This REST endpoint exposes the search interface for getting all company data
	 * 
	 * @param
	 * @return ResponseEntity<CompanyData>
	 */

	@GetMapping("companydata")
	public ResponseEntity<List<CompanyData>> fetchAllsCompanies() throws Exception {

		List<CompanyData> allcmpnycodes = adminService.findAllCompanies();
		return ResponseEntity.ok(allcmpnycodes);
	}

	/**
	 * This REST endpoint exposes the search interface for saving credit card names
	 * 
	 * @param CreditcardsRequestDTO
	 * @return ResponseEntity<CreditcardResponseDTO>
	 */

	@PostMapping("creditcardsnames")
	public ResponseEntity<CreditcardResponseDTO> saveCreditCards(@RequestBody CreditcardsRequestDTO creditreqDTO)
			throws Exception {

		CreditcardResponseDTO savedrespcards = adminService.saveCreditCards(creditreqDTO);

		return ResponseEntity.ok(savedrespcards);

	}

	/**
	 * This REST endpoint exposes the search interface for returning credit cards by
	 * id
	 * 
	 * @param String id
	 * @return ResponseEntity<CreditcardResponseDTO>
	 */

	@GetMapping("creditcardsnames/{id}")
	public ResponseEntity<CreditcardResponseDTO> fetchCreditCardByType(@PathVariable String id) throws Exception {

		CreditcardResponseDTO selectedcards = adminService.getCreditCardById(id);

		return ResponseEntity.ok(selectedcards);
	}

	/**
	 * This REST endpoint exposes the search interface for updating Credit Cards by
	 * Id
	 * 
	 * @param CreditcardsRequestDTO,String id
	 * @return ResponseEntity<CreditcardResponseDTO>
	 */

	@PutMapping("creditcardsnames/{id}")
	public ResponseEntity<CreditcardResponseDTO> updateCreditCardByType(@RequestBody CreditcardsRequestDTO creditreqDTO,
			@PathVariable String id) throws Exception {

		CreditcardResponseDTO updatedCompanyData = adminService.updateCreditCards(id, creditreqDTO);
		return ResponseEntity.ok(updatedCompanyData);
	}

	/**
	 * This REST endpoint exposes the search interface for getting all Credit Cards
	 * 
	 * @param
	 * @return ResponseEntity<CreditcardResponseDTO>
	 */
	@GetMapping("creditcardsnames")
	public ResponseEntity<List<CreditcardNames>> fetchAllsCreditCards() throws Exception {

		List<CreditcardNames> allcmpnycodes = adminService.findAllCreditCards();
		return ResponseEntity.ok(allcmpnycodes);
	}
}
