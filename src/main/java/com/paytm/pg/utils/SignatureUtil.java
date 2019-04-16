/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg.utils;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;
import static com.paytm.pg.constants.LibraryConstants.LOGGER;
import static com.paytm.pg.constants.LibraryConstants.UTILITY_CLASS_EXCEPTION;

import com.paytm.pg.SDKException;
import com.paytm.pg.constants.ErrorConstants;
import com.paytm.pg.constants.MerchantProperties;
import com.paytm.pgplus.signature.SignatureServiceHelper;

/**
 * This class is used to create and validate signature/checksum by making call
 * to checksum processor jar
 */
public class SignatureUtil {

	private SignatureUtil() {
		throw new IllegalStateException(UTILITY_CLASS_EXCEPTION);
	}

	/**
	 * This method accepts body(Object), converts in json string and calls
	 * getSignature(String)
	 * 
	 * @param requestBody object for which signature will be generated
	 * @return String signature for the object
	 */
	public static String getSignature(Object requestBody) {
		String body = JacksonUtil.mapObjectToJson(requestBody);
		return getSignature(body);
	}

	/**
	 * This method return the signature from Signature-Utility on the basis of
	 * TreeMap Parameters
	 * 
	 * @param paramap map for which signature will be generated
	 * @return String signature
	 * @throws Exception SignatureServiceHelper can throw exception
	 */
	public static String getSignature(SortedMap<String, String> paramap) throws Exception {
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("getSignature for TreeMap: {0} "), paramap);
		return SignatureServiceHelper.getInstance().generateSignature(MerchantProperties.getMerchantKey(),
				new TreeMap<>(paramap));
	}

	/**
	 * This method return the signature from Signature-Utility on the basis of
	 * String body
	 * 
	 * @param body String for which signature will be generated
	 * @return String signature
	 */
	public static String getSignature(String body) {
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("getSignature for String: {0} "), body);
		try {
			return SignatureServiceHelper.getInstance().generateSignature(MerchantProperties.getMerchantKey(), body);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("getSignature Exception {0} "), e);
			throw SDKException
					.getSDKException(ErrorConstants.ErrorMessage.GENERATE_SIGNATURE_EXCEPTION + e.getMessage());
		}
	}

	/**
	 * This method return the boolean from Signature-Utility on the basis of TreeMap
	 * parameters
	 * 
	 * @param paramap   map for which signature will be validated
	 * @param signature signature string to be validated
	 * @return boolean true if validated else false
	 * @throws Exception SignatureServiceHelper can throw exception
	 */
	public static boolean validateSignature(SortedMap<String, String> paramap, String signature) throws Exception {
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("validateSignature for TreeMap: {0} with signature: {1} "),
				new Object[] { paramap, signature });
		return SignatureServiceHelper.getInstance().verifySignature(MerchantProperties.getMerchantKey(),
				new TreeMap<>(paramap), signature);
	}

	/**
	 * This method return the boolean from Signature-Utility on the basis of String
	 * body parameters
	 * 
	 * @param response  response String having body for which signature should be
	 *                  validated
	 * @param body      body that will used to generate signature
	 * @param signature signature that will be validated
	 * @return boolean true if validated else false
	 */
	public static boolean validateSignature(String response, String body, String signature) {
		LOGGER.log(Level.INFO,
				CommonUtil.getLogMessage("validateSignature for response: {0} and body: {1} with signature: {2} "),
				new Object[] { response, body, signature });
		try {
			return SignatureServiceHelper.getInstance().verifySignature(MerchantProperties.getMerchantKey(), body,
					signature);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("validateSignature Exception {0} "), e);
			throw SDKException.getSDKException(
					ErrorConstants.ErrorMessage.VALIDATE_SIGNATURE_EXCEPTION + e.getMessage(), response);
		}
	}

}
