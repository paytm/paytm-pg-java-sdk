/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg.utils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.logging.Level;

import static com.paytm.pg.constants.LibraryConstants.LOGGER;
import static com.paytm.pg.constants.LibraryConstants.UTILITY_CLASS_EXCEPTION;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytm.pg.SDKException;
import com.paytm.pg.constants.ErrorConstants;

/**
 * Utility class having methods used in json to object and object to json
 * conversion
 */
public class JacksonUtil {

	private JacksonUtil() {
		throw new IllegalStateException(UTILITY_CLASS_EXCEPTION);
	}

	private static ObjectMapper objectMapper;
	/**
	 * creates one time ObjectMapper object
	 */
	static {
		objectMapper = new ObjectMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		TimeZone timeZone = TimeZone.getTimeZone("IST");
		sdf.setTimeZone(timeZone);
		objectMapper.setDateFormat(sdf);
		objectMapper.setTimeZone(TimeZone.getTimeZone("IST"));
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		objectMapper.setVisibility(PropertyAccessor.GETTER, Visibility.NONE);
	}

	/**
	 * @return ObjectMapper object
	 */
	public static ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	/**
	 * convert object to json String
	 * 
	 * @param object object that will be converted to json string
	 * @return String (Json) obtained from object
	 */
	public static String mapObjectToJson(final Object object) {
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("mapObjectToJson for Object: {0} "), object);
		if (object != null) {
			try {
				String resultString = objectMapper.writeValueAsString(object);
				LOGGER.log(Level.INFO, CommonUtil.getLogMessage("mapObjectToJson resultString {0} "), resultString);
				return CommonUtil.formatBodyForJson(resultString);
			} catch (Exception e) {
				LOGGER.log(Level.INFO, CommonUtil.getLogMessage("mapObjectToJson Exception : {0} "), e);
				throw SDKException.getSDKException(
						ErrorConstants.ErrorMessage.OBJECT_TO_JSONSTRING_CONVERSION_FAILED + e.getMessage());
			}
		}
		return null;
	}

	/**
	 * convert json byte array to clazz object
	 * 
	 * @param jsonObject byte array that will be converted to object
	 * @param clazz      Class in which jsonObject will be converted
	 * @param            <T> Generic class
	 * @return T Generic object in which jsonObject will be converted
	 */
	public static <T> T mapJsonToObject(final byte[] jsonObject, final Class<T> clazz) {
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("mapJsonToObject for Object: {0} with Class: {1} "),
				new Object[] { jsonObject, clazz });
		try {
			return objectMapper.readValue(jsonObject, clazz);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("mapJsonToObject Exception : {0} "), e);
			throw SDKException.getSDKException(
					ErrorConstants.ErrorMessage.JSONSTRING_TO_OBJECT_CONVERSION_FAILED + e.getMessage(),
					new String(jsonObject));
		}
	}

	/**
	 * convert json String to clazz object
	 * 
	 * @param jsonObject byte array that will be converted to object
	 * @param clazz      Class in which jsonObject will be converted
	 * @param            <T> Generic class
	 * @return T Generic object in which jsonObject will be converted
	 */
	public static <T> T mapJsonToObject(final String jsonObject, final Class<T> clazz) {
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("mapJsonToObject for Object: {0} with Class: {1} "),
				new Object[] { jsonObject, clazz });
		try {
			T obj = objectMapper.readValue(jsonObject, clazz);
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("mapJsonToObject obj : {0} "), obj);
			return obj;
		} catch (Exception e) {
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("mapJsonToObject Exception : {0} "), e);
			throw SDKException.getSDKException(
					ErrorConstants.ErrorMessage.JSONSTRING_TO_OBJECT_CONVERSION_FAILED + e.getMessage(), jsonObject);
		}
	}
}
