package com.bourntec.apmg.usermanagement.v1.dto.request;

import com.bourntec.apmg.entity.Brokers;


/**
 * 
 * Class is used as a data transfer object for Table MerchandiseCategory
 * 
 * @author vidya.p 
 *
 */


public class BrokersRequestDTO {
	private String brokerId;
	private String brokerName;
	private String description;
	private String status;
	private String locationCode;
	private Long phone; //Bugzilla Id : 5459
	private String birthStar; //Bugzilla Id : 5459
	private String email;
	private String smallImage;
	private String largeImage;

	
	// Property accessors

	public String getBrokerId() {
		return this.brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerName() {
		return this.brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocationCode() {
		return this.locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	//bugzilla#3503 end

	/**
	 * @return the phone
	 */
	public Long getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Long phone) {
		this.phone = phone;
	}

	/**
	 * @return the birthStar
	 */
	public String getBirthStar() {
		return birthStar;
	}

	/**
	 * @param birthStar the birthStar to set
	 */
	public void setBirthStar(String birthStar) {
		this.birthStar = birthStar;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the smallImage
	 */
	public String getSmallImage() {
		return smallImage;
	}

	/**
	 * @param smallImage the smallImage to set
	 */
	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	/**
	 * @return the largeImage
	 */
	public String getLargeImage() {
		return largeImage;
	}

	/**
	 * @param largeImage the largeImage to set
	 */
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}
	public Brokers toModel(BrokersRequestDTO brokersRequestDTO) {

		Brokers brokers = new Brokers();
	
		try {
			brokers.setBrokerId(brokersRequestDTO.getBrokerId());
			brokers.setBrokerName(brokersRequestDTO.getBrokerName());
			brokers.setBirthStar(brokersRequestDTO.getBirthStar());
			brokers.setDescription(brokersRequestDTO.getDescription());
			brokers.setEmail(brokersRequestDTO.getEmail());
			brokers.setLargeImage(brokersRequestDTO.getLargeImage());
			brokers.setLocationCode(brokersRequestDTO.getLocationCode());
			brokers.setPhone(brokersRequestDTO.getPhone());
			brokers.setSmallImage(brokersRequestDTO.getSmallImage());
			brokers.setStatus(brokersRequestDTO.getStatus());

		} catch (Exception e) {

		}
		return brokers;

	}



}
