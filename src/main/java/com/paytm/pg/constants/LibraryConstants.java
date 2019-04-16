/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg.constants;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.paytm.pg.utils.PropertiesUtil;

/**
 * Below constants are used in API calling. Please do not change below constants
 */
public class LibraryConstants {
	/** Constant logger for Paytm SDK */
	public static final Logger LOGGER = Logger.getLogger("Paytm");

	private LibraryConstants() {
		throw new IllegalStateException(UTILITY_CLASS_EXCEPTION);
	}

	static {
		String version = null;
		try {
			version = PropertiesUtil.getInstance().getProperty("version");
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		VERSION = version;
	}
	/** Exception message shown while creating LibraryConstants class */
	public static final String UTILITY_CLASS_EXCEPTION = "Utility class cannot be instantiated";
	/** holds the version of SDK */
	public static final String VERSION;
	/** holds the version of SDK */
	public static final String JAVA_SDK_TEXT = "JAVA-SDK";
	/** holds the format of date */
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss z";

	/** Environment constants */
	/** holds constant for staging environment */
	public static final String STAGING_ENVIRONMENT = "STAGE";
	/** holds constant for production environment */
	public static final String PRODUCTION_ENVIRONMENT = "PROD";

	/** Status message can be returned in case of Api success */
	/** holds constant for success 'S' status */
	public static final String SUCCESS_STATUS = "S";
	/** holds constant for pending status */
	public static final String PENDING_STATUS = "PENDING";
	/** holds constant for success 'TXN_SUCCESS' status */
	public static final String TXN_SUCCESS_STATUS = "TXN_SUCCESS";

	/** Text Strings used in Api Callings */
	/** holds constant value for true text */
	public static final String TRUE_TEXT = "true";
	/** holds constant value for false text */
	public static final String FALSE_TEXT = "false";
	/** holds constant value for mid text */
	public static final String MID_TEXT = "mid";
	/** holds constant value for orderId text */
	public static final String ORDERID_TEXT = "orderId";
	/** holds constant value for Content-Type text */
	public static final String CONTENT_TYPE_TEXT = "Content-Type";
	/** holds constant value for application/json text */
	public static final String APPLICATION_JSON_TEXT = "application/json";
	/** holds constant value for UTF-8 text */
	public static final String UTF_8_TEXT = "UTF-8";
	/** holds constant value for SUCCESS text */
	public static final String SUCCESS_TEXT = "SUCCESS";
	/** holds constant value for head text */
	public static final String HEAD_TEXT = "head";
	/** holds constant value for body text */
	public static final String BODY_TEXT = "body";
	/** holds constant value for signature text */
	public static final String SIGNATURE_TEXT = "signature";

	/** holds constant value for Request Id text */
	public static final String X_REQUEST_ID = "X-Request-ID";

	/**
	 * Do not change the below text as these are used input name for redirection
	 * flow in process transaction api calling
	 */
	/** holds constant value for MID text */
	public static final String MID_TEXT_DEFAULT = "MID";
	/** holds constant value for WEBSITE text */
	public static final String WEBSITE_TEXT_DEFAULT = "WEBSITE";
	/** holds constant value for CALLBACK_URL text */
	public static final String CALLBACK_URL_TEXT_DEFAULT = "CALLBACK_URL";
	/** holds constant value for CHECKSUMHASH text */
	public static final String CHECKSUMHASH_TEXT_DEFAULT = "CHECKSUMHASH";

	/** This Jsp is used in redirection flow */
	public static final String DEFAULT_REDIRECT_JSP = "pgRedirect.jsp";

	/** holds Payment request type constants */
	public static final String REQUEST_TYPE_PAYMENT = "Payment";
	/** holds media type json constants */
	public static final String MEDIA_TYPE_JSON = "application/json; charset=utf-8";

	/**
	 * This class holds constants related to request
	 */
	public static class Request {
		private Request() {
			throw new IllegalStateException(UTILITY_CLASS_EXCEPTION);
		}

		/** holds constant value for food wallet */
		public static final String FOOD_WALLET = "FOOD";
		/** holds constant value for gift wallet */
		public static final String GIFT_WALLET = "GIFT";
	}

	/**
	 * This class holds constants related to Peon
	 */
	public static class Peon {
		private Peon() {
			throw new IllegalStateException(UTILITY_CLASS_EXCEPTION);
		}

		/** holds constant value for GATEWAYNAME */
		public static final String JSON_KEY_PEON_BODY_GATEWAYNAME = "GATEWAYNAME";
		/** holds constant value for PAYMENTMODE */
		public static final String JSON_KEY_PEON_BODY_PAYMENTMODE = "PAYMENTMODE";
		/** holds constant value for TXNDATE */
		public static final String JSON_KEY_PEON_BODY_TXNDATE = "TXNDATE";
		/** holds constant value for TXNDATETIME */
		public static final String JSON_KEY_PEON_BODY_TXNDATETIME = "TXNDATETIME";
		/** holds constant value for CUSTID */
		public static final String JSON_KEY_PEON_BODY_CUSTID = "CUSTID";
		/** holds constant value for STATUS */
		public static final String JSON_KEY_PEON_BODY_STATUS = "STATUS";
		/** holds constant value for MID */
		public static final String JSON_KEY_PEON_BODY_MID = "MID";
		/** holds constant value for ORDERID */
		public static final String JSON_KEY_PEON_BODY_ORDERID = "ORDERID";
		/** holds constant value for CURRENCY */
		public static final String JSON_KEY_PEON_BODY_CURRENCY = "CURRENCY";
		/** holds constant value for TXNID */
		public static final String JSON_KEY_PEON_BODY_TXNID = "TXNID";
		/** holds constant value for TXNAMOUNT */
		public static final String JSON_KEY_PEON_BODY_TXNAMOUNT = "TXNAMOUNT";
		/** holds constant value for BANKTXNID */
		public static final String JSON_KEY_PEON_BODY_BANKTXNID = "BANKTXNID";
		/** holds constant value for BANKNAME */
		public static final String JSON_KEY_PEON_BODY_BANKNAME = "BANKNAME";
		/** holds constant value for RESPMSG */
		public static final String JSON_KEY_PEON_BODY_RESPMSG = "RESPMSG";
		/** holds constant value for RESPCODE */
		public static final String JSON_KEY_PEON_BODY_RESPCODE = "RESPCODE";
		/** holds constant value for ENC_DATA */
		public static final String JSON_KEY_ENC_PARAMS = "ENC_DATA";
		/** holds constant value for CHILDTXNLIST */
		public static final String JSON_KEY_PEON_BODY_CHILDTXNLIST = "CHILDTXNLIST";
		/** holds constant value for SUBS_ID */
		public static final String JSON_KEY_PEON_BODY_SUBSID = "SUBS_ID";
		/** holds constant value for MERC_UNQ_REF */
		public static final String JSON_KEY_PEON_BODY_MERCUNQREF = "MERC_UNQ_REF";
		/** holds constant value for PROMO_CAMP_ID */
		public static final String JSON_KEY_PEON_BODY_PROMOCAMPID = "PROMO_CAMP_ID";
		/** holds constant value for PROMO_RESPCODE */
		public static final String JSON_KEY_PEON_BODY_PROMORESPCODE = "PROMO_RESPCODE";
		/** holds constant value for PROMO_STATUS */
		public static final String JSON_KEY_PEON_BODY_PROMOSTATUS = "PROMO_STATUS";
		/** holds constant value for cardIndexNo */
		public static final String JSON_KEY_PEON_BODY_CARD_INDEX_NO = "cardIndexNo";
		/** holds constant value for maskedCardNo */
		public static final String JSON_KEY_PEON_BODY_MASKED_CARD_NO = "maskedCardNo";
		/** holds constant value for CHECKSUMHASH */
		public static final String JSON_KEY_PEON_BODY_CHECKSUMHASH = "CHECKSUMHASH";
		/** holds constant value for TXNTYPE */
		public static final String JSON_KEY_PEON_BODY_TRANSACTION_TYPE = "TXNTYPE";
		/** holds constant value for REFUNDAMT */
		public static final String JSON_KEY_PEON_BODY_REFUND_AMOUNT = "REFUNDAMT";
		/** holds constant value for Masked_customer_mobile_number */
		public static final String JSON_KEY_PEON_BODY_MASKED_CUSTOMER_MOBILE_NUMBER = "Masked_customer_mobile_number";
		/** holds constant value for POS_ID */
		public static final String JSON_KEY_PEON_BODY_POS_ID = "POS_ID";
		/** holds constant value for uniqueReferenceLabel */
		public static final String JSON_KEY_PEON_BODY_UNIQUE_REFERENCE_LABEL = "uniqueReferenceLabel";
		/** holds constant value for uniqueReferenceValue */
		public static final String JSON_KEY_PEON_BODY_UNIQUE_REFERENCE_VALUE = "uniqueReferenceValue";
		/** holds constant value for pccCode */
		public static final String JSON_KEY_PEON_BODY_PCC_CODE = "pccCode";
		/** holds constant value for PRN */
		public static final String JSON_KEY_PEON_BODY_PRN = "PRN";
		/** holds constant value for udf_1 */
		public static final String JSON_KEY_PEON_BODY_UDF1 = "udf_1";
		/** holds constant value for udf_2 */
		public static final String JSON_KEY_PEON_BODY_UDF2 = "udf_2";
		/** holds constant value for udf_3 */
		public static final String JSON_KEY_PEON_BODY_UDF3 = "udf_3";
		/** holds constant value for comments */
		public static final String JSON_KEY_PEON_BODY_COMMENTS = "comments";
		/** holds constant value for LOYALTYPOINTS */
		public static final String JSON_KEY_PEON_BODY_LOYALTYPOINT = "LOYALTYPOINTS";
		/** holds constant value for AUTHCODE */
		public static final String JSON_KEY_PEON_BODY_AUTHCODE = "AUTHCODE";
		/** holds constant value for RRN */
		public static final String JSON_KEY_PEON_BODY_RRN = "RRN";
		/** holds constant value for VPA */
		public static final String JSON_KEY_PEON_BODY_VPA = "VPA";
		/** holds constant value for FUNDSOURCEVERIFICATION */
		public static final String JSON_KEY_FUND_SOURCE_VERIFICATION = "FUNDSOURCEVERIFICATION";
		/** holds constant value for Content-Type */
		public static final String JSON_KEY_PEON_HEADER_CONTENT_TYPE = "Content-Type";

		/** holds constant value for peonUrl */
		public static final String JSON_KEY_PEON_URL_ELEMENT = "peonUrl";
		/** holds constant value for dataType */
		public static final String JSON_KEY_PEON_DATA_TYPE = "dataType";
		/** holds constant value for PaytmTxnId */
		public static final String JSON_KEY_PEON_PAYTM_TXN_ID = "PaytmTxnId";
		/** holds constant value for data */
		public static final String JSON_KEY_PEON_BODY = "data";
		/** holds constant value for headers */
		public static final String JSON_KEY_PEON_HEADER = "headers";
		/** holds constant value for TXNSTATUS */
		public static final String JSON_KEY_REFUND_SUCCESS_PEON_BODY_TXN_STATUS = "TXNSTATUS";
		/** holds constant value for REFUNDAMOUNT */
		public static final String JSON_KEY_REFUND_SUCCESS_PEON_BODY_REFUND_AMOUNT = "REFUNDAMOUNT";
		/** holds constant value for TOTALREFUNDAMT */
		public static final String JSON_KEY_REFUND_SUCCESS_PEON_BODY_TOTAL_REFUND_AMOUNT = "TOTALREFUNDAMT";
		/** holds constant value for REFUNDDATE */
		public static final String JSON_KEY_REFUND_SUCCESS_PEON_BODY_REFUND_DATE = "REFUNDDATE";
		/** holds constant value for REFID */
		public static final String JSON_KEY_REFUND_SUCCESS_PEON_BODY_REF_ID = "REFID";
		/** holds constant value for GATEWAY */
		public static final String JSON_KEY_REFUND_SUCCESS_PEON_BODY_GATEWAY = "GATEWAY";
		/** holds constant value for REFUNDID */
		public static final String JSON_KEY_REFUND_SUCCESS_PEON_BODY_REFUND_ID = "REFUNDID";
		/** holds constant value for REFUNDTYPE */
		public static final String JSON_KEY_REFUND_SUCCESS_PEON_BODY_REFUND_TYPE = "REFUNDTYPE";
		/** holds constant value for RRN */
		public static final String JSON_KEY_REFUND_SUCCESS_PEON_BODY_RRN = "RRN";
		/** holds constant value for CLIENTID */
		public static final String JSON_KEY_MERCHANT_CLIENT_ID = "CLIENTID";

	}

}
