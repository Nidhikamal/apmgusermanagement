package com.bourntec.apmg.usermanagement.v1.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class VendorCountryCodesResponseDTO {
	
	
		/**
		 * property that is used to set the message
		 * in service when a particular action carried out in there
		 * for eg : when a user is not fetched, showing the user is not retrieved
		 * @TODO need to remove when exception module is implemented
		 */
		private String responseMessage;

		/**
		 * @return the responseMessage
		 */
		


		private String countryCode;
		private String countryName;
		private String currencyCode;
		private String displayWeb;
		
		public String getCountryCode() {
			return countryCode;
		}

		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}

		public String getCountryName() {
			return countryName;
		}

		public void setCountryName(String countryName) {
			this.countryName = countryName;
		}

		public String getCurrencyCode() {
			return currencyCode;
		}

		public void setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
		}

		public String getDisplayWeb() {
			return displayWeb;
		}

		public void setDisplayWeb(String displayWeb) {
			this.displayWeb = displayWeb;
		}

		


		public String getResponseMessage() {
			return responseMessage;
		}

		/**
		 * @param responseMessage the responseMessage to set
		 */
		public void setResponseMessage(String responseMessage) {
			this.responseMessage = responseMessage;
		}

}
