/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg.constants;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import com.paytm.merchant.models.Time;
import com.paytm.pg.utils.CommonUtil;

import static com.paytm.pg.constants.LibraryConstants.LOGGER;

/**
 * This class is used to store all the merchant related constants that are
 * common to all payments and orders.
 */
public class MerchantProperties {

	private MerchantProperties() {
		throw new IllegalStateException(LibraryConstants.UTILITY_CLASS_EXCEPTION);
	}

	/**
	 * This method will initialize the information according to merchants
	 * requirement.
	 * 
	 * Merchant will use this method to change information as per his requirements.
	 * 
	 * @param environment can be STAGE for testing and PROD for production
	 * @param mid         merchant id
	 * @param merchantKey merchant key
	 * @param clientId    merchant client id
	 * @param website     merchant website
	 */
	public static void initialize(String environment, String mid, String merchantKey, String clientId, String website) {
		if (!isInitialized) {
			isInitialized = true;
			setEnvironment(environment);
			setMid(mid);
			setMerchantKey(merchantKey);
			setClientId(clientId);
			setWebsite(website);
			LibraryConstants.LOGGER.log(Level.INFO, CommonUtil.getLogMessage("MerchantProperties : Initialized"));
		}
	}

	private static boolean isInitialized = false;

	/**
	 * STAGE for Staging and PROD for Production. ENVIRONMENT is used to set
	 * URLs(TESTING or PRODUCTION)
	 */
	private static String environment = LibraryConstants.STAGING_ENVIRONMENT;

	/** timeout constants */
	private static Time connectionTimeout = new Time(5, TimeUnit.MINUTES);

	/** provide your mid and key */
	private static String mid;
	private static String merchantKey;

	/**
	 * WEBSITE should be WEBSTAGING for testing purpose. For production it value is
	 * defined in documents
	 */
	private static String website = "WEBSTAGING";

	/** provide your clientId */
	private static String clientId;

	/** callback url on which paytm will respond for api calls */
	private static String callbackUrl = "https://pg-staging.paytm.in/MerchantSite/bankResponse";

	/** URLs */
	private static String baseUrl = "https://securegw-stage.paytm.in";
	private static String initiateTxnUrl = baseUrl + "/theia/api/v1/initiateTransaction";
	private static String processTransactionDefaultUrl = baseUrl + "/theia/processTransaction";
	private static String refundUrl = baseUrl + "/refund/api/v1/async/refund";
	private static String refundStatusUrl = baseUrl + "/refund/api/v1/refundStatus";
	private static String paymentStatusUrl = baseUrl + "/merchant-status/api/v1/getPaymentStatus";

	/**
	 * 
	 * @return environment set by merchant
	 */
	public static String getEnvironment() {
		return environment;
	}

	/**
	 * 
	 * @return merchant mid
	 */
	public static String getMid() {
		return mid;
	}

	/**
	 * 
	 * @return merchant key
	 */
	public static String getMerchantKey() {
		return merchantKey;
	}

	/**
	 * 
	 * @return merchant website
	 */
	public static String getWebsite() {
		return website;
	}

	/**
	 * 
	 * @return merchant client id
	 */
	public static String getClientId() {
		return clientId;
	}

	/**
	 * 
	 * @return merchant callback url
	 */
	public static String getCallbackUrl() {
		return callbackUrl;
	}

	/**
	 * 
	 * @return base url of API
	 */
	public static String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * 
	 * @return initiate transaction API url
	 */
	public static String getInitiateTxnUrl() {
		return initiateTxnUrl;
	}

	/**
	 * 
	 * @return process transaction API url for default flow
	 */
	public static String getProcessTransactionDefaultUrl() {
		return processTransactionDefaultUrl;
	}

	/**
	 * 
	 * @return refund API url
	 */
	public static String getRefundUrl() {
		return refundUrl;
	}

	/**
	 * 
	 * @return refund status API url
	 */
	public static String getRefundStatusUrl() {
		return refundStatusUrl;
	}

	/**
	 * 
	 * @return payment status API url
	 */
	public static String getPaymentStatusUrl() {
		return paymentStatusUrl;
	}

	/**
	 * 
	 * @return connection time out
	 */
	public static Time getConnectionTimeout() {
		return connectionTimeout;
	}

	/**
	 * 
	 * @return true if merchant properties are initialized
	 */
	public static boolean isInitialized() {
		return isInitialized;
	}

	/**
	 * 
	 * @param connectionTimeout set the connection time out
	 */
	public static void setConnectionTimeout(Time connectionTimeout) {
		MerchantProperties.connectionTimeout = connectionTimeout;
	}

	private static void setMid(String mid) {
		MerchantProperties.mid = mid;
	}

	private static void setMerchantKey(String merchantKey) {
		MerchantProperties.merchantKey = merchantKey;
	}

	private static void setWebsite(String website) {
		MerchantProperties.website = website;
	}

	private static void setClientId(String clientId) {
		MerchantProperties.clientId = clientId;
	}

	public static void setCallbackUrl(String callbackUrl) {
		MerchantProperties.callbackUrl = callbackUrl;
	}

	private static void setEnvironment(String environment) {
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("Setting Environment for {0} "), environment);
		MerchantProperties.environment = environment;
		if (environment.equals(LibraryConstants.PRODUCTION_ENVIRONMENT)) {
			baseUrl = "https://securegw.paytm.in";
			initiateTxnUrl = baseUrl + "/theia/api/v1/initiateTransaction";
			processTransactionDefaultUrl = baseUrl + "/theia/processTransaction";
			refundUrl = baseUrl + "/refund/api/v1/async/refund";
			paymentStatusUrl = baseUrl + "/merchant-status/api/v1/getPaymentStatus";
		}
	}
}
