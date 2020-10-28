package com.bourntec.apmg.usermanagement.v1.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Component;

@Component
public class DateUtils {

	/**
	 * Method that produce epoch time from UTC time format
	 * @param timeInUTC
	 * @return
	 * @throws Exception
	 */
	public Long convertUTCToEpoch(String timeInUTC) throws Exception {

		Long epochTime = null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",Locale.getDefault());// yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
			Date date = format.parse(timeInUTC);
			epochTime = date.getTime();
		} catch (Exception e) {
			throw e;
		}
		return epochTime;

	}
	
	/**
	 * Method that converts epochtime to UTC time 
	 * @param epochSecond
	 * @return
	 * @throws Exception
	 */
	public String convertEpochToUTCTime(Long epochSecond) throws Exception{
		try {
			Date date = new Date(epochSecond);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",Locale.getDefault());//yyyy-MM-dd'T'HH:mm:ss.SSS'Z'
			String UTCTime = format.format(date);
			return UTCTime;
		}
		catch(Exception e) {
			throw e;
		}
	}
}
