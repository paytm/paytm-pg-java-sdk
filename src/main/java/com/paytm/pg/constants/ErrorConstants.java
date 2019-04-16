/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg.constants;

/**
 * This class is used to store error constants.
 */
public class ErrorConstants {
	private ErrorConstants() {
		throw new IllegalStateException(LibraryConstants.UTILITY_CLASS_EXCEPTION);
	}

	/**
	 * Result Status In case of Failure
	 */
	/** failure status */
	public static final String FAILURE = "failure";
	/** system error Message status */
	public static final String SYSTEM_ERROR = "System Error";

	/**
	 * Result messages in case of failure
	 */
	public static class ErrorMessage {
		private ErrorMessage() {
			throw new IllegalStateException(LibraryConstants.UTILITY_CLASS_EXCEPTION);
		}

		/** Result message when verify signature returns false */
		public static final String SIGNATURE_VALIDATION_FAILED = "Signature Validation Failed";
		/** Result message when verify signature returns exception */
		public static final String VALIDATE_SIGNATURE_EXCEPTION = "Validate Signature Exception";
		/** Result message when verify signature returns exception */
		public static final String GENERATE_SIGNATURE_EXCEPTION = "Generate Signature Exception";
		/** Result message when any required parameter is missing in api calling */
		public static final String MISSING_MANDATORY_PARAMETERS = "Missing Mandatory Parameters";
		/** Result message when Transaction token is missing if required in api */
		public static final String MISSING_TRANSACTIONTOKEN_TOKEN = "Missing Transaction Token";
		/** Result message when Merchant Property are not initialized */
		public static final String MISSING_MERCHANT_PROPERTY = "Missing Merchant Property";
		/** Result message when String to object conversion failed */
		public static final String JSONSTRING_TO_OBJECT_CONVERSION_FAILED = "JsonString to object conversion failure";
		/** Result message when Object to string conversion failed */
		public static final String OBJECT_TO_JSONSTRING_CONVERSION_FAILED = "Object to JsonString conversion failure";
	}

	/**
	 * Result code in case of failure
	 */
	public static class ErrorCode {
		private ErrorCode() {
			throw new IllegalStateException(LibraryConstants.UTILITY_CLASS_EXCEPTION);
		}

		/** Result code in case of failure */
		public static final String DEFAULT = "501";

	}
}
