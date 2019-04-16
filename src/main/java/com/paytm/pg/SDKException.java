/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg;

import java.util.logging.Level;

import com.paytm.pg.constants.ErrorConstants;
import com.paytm.pg.utils.CommonUtil;

import static com.paytm.pg.constants.LibraryConstants.LOGGER;

/**
 * This class handle SDK exception
 */
public class SDKException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/** hold the API response if exception occurs after API hit */
	private final String rawData;

	/**
	 * 
	 * @return String API response if exception occurs after API hit
	 */
	public String getRawData() {
		return rawData;
	}

	/**
	 * returns SDKException object
	 * 
	 * @param msg message for exception
	 */
	public SDKException(String msg) {
		super(msg);
		this.rawData = null;
		LOGGER.log(Level.SEVERE, CommonUtil.getLogMessage("SDKException"));
	}

	/**
	 * returns SDKException object
	 * 
	 * @param msg     message for exception
	 * @param rawData response received from paytm API
	 */
	public SDKException(String msg, String rawData) {
		super(msg);
		this.rawData = rawData;
		LOGGER.log(Level.SEVERE, CommonUtil.getLogMessage("SDKException"));
	}

	/**
	 * @return SDKException when any mandatory parameter is missing
	 */
	public static SDKException getMerchantPropertyInitializationException() {
		LOGGER.log(Level.SEVERE, CommonUtil.getLogMessage(ErrorConstants.ErrorMessage.MISSING_MERCHANT_PROPERTY));
		return new SDKException(ErrorConstants.ErrorMessage.MISSING_MERCHANT_PROPERTY);
	}

	/**
	 * @return SDKException when any mandatory parameter is missing
	 */
	public static SDKException getMissingMandatoryParametersException() {
		LOGGER.log(Level.SEVERE, CommonUtil.getLogMessage(ErrorConstants.ErrorMessage.MISSING_MANDATORY_PARAMETERS));
		return new SDKException(ErrorConstants.ErrorMessage.MISSING_MANDATORY_PARAMETERS);
	}

	/**
	 * @return SDKException when transaction token is missing
	 */
	public static SDKException getTransactionTokenException() {
		LOGGER.log(Level.SEVERE, CommonUtil.getLogMessage(ErrorConstants.ErrorMessage.MISSING_TRANSACTIONTOKEN_TOKEN));
		return new SDKException(ErrorConstants.ErrorMessage.MISSING_TRANSACTIONTOKEN_TOKEN);
	}

	/**
	 * @param str response received in API hit
	 * @return SDKException when Signature validation failed at merchant side
	 */
	public static SDKException getSignatureValidationFailedException(String str) {
		LOGGER.log(Level.SEVERE, CommonUtil.getLogMessage(ErrorConstants.ErrorMessage.SIGNATURE_VALIDATION_FAILED));
		return new SDKException(ErrorConstants.ErrorMessage.SIGNATURE_VALIDATION_FAILED, str);
	}

	/**
	 * @param exceptionMessage exception message
	 * @param jsonObject       jsonObject received in api hit
	 * @return SDKException when exception occur after api hit
	 */
	public static SDKException getSDKException(String exceptionMessage, String jsonObject) {
		LOGGER.log(Level.SEVERE, CommonUtil.getLogMessage(exceptionMessage));
		return new SDKException(exceptionMessage, jsonObject);
	}

	/**
	 * @param exceptionMessage exception message
	 * @return SDKException when exception occur before api hit
	 */
	public static SDKException getSDKException(String exceptionMessage) {
		LOGGER.log(Level.SEVERE, CommonUtil.getLogMessage("getSDKException {0}"), exceptionMessage);
		return new SDKException(exceptionMessage);
	}
}
