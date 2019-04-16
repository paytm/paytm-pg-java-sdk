/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg;

import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;

import com.paytm.merchant.models.SDKResponse;
import com.paytm.merchant.models.Time;
import com.paytm.pg.constants.ErrorConstants;
import com.paytm.pg.constants.LibraryConstants;
import static com.paytm.pg.constants.LibraryConstants.LOGGER;
import static com.paytm.pg.constants.LibraryConstants.UTILITY_CLASS_EXCEPTION;

import com.paytm.pg.utils.CommonUtil;
import com.paytm.pg.utils.JacksonUtil;
import com.paytm.pg.utils.SignatureUtil;
import com.paytm.pg.utils.UrlConnectionUtil;
import com.paytm.pgplus.response.interfaces.Response;
import com.paytm.pgplus.response.interfaces.SecureResponse;

/**
 * This class is handle request coming from controller.
 * 
 * This class also does post verification of request.
 */
public class Request {

	private Request() {
		throw new IllegalStateException(UTILITY_CLASS_EXCEPTION);
	}

	/**
	 * process get the request from controller and makes the
	 * UrlConnectionUtil.execute to get response from API.
	 * 
	 * It also validate signature of response if required and return the required
	 * object to the controller
	 * 
	 * @param request     object to send as post data
	 * @param url         url for the api
	 * @param queryParams parameters to be sent as query parameters
	 * @param mediaType   mediaType of the request
	 * @param readTimeout read timeout of the api hit
	 * @param             <T> Generic class
	 * @param class1      Class for which response should be received
	 * @return {@link SDKResponse} containing response string from api hit and
	 *         response object
	 * @throws Exception as validateSignature can throw error
	 */
	public static <T> SDKResponse<T> process(Object request, String url, Map<String, String> queryParams,
			String mediaType, Time readTimeout, Class<T> class1) throws Exception {
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("process for request: {0} "), request);
		InputStream inputStream = UrlConnectionUtil.execute(request, url, queryParams, mediaType, readTimeout);
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("InputStream response received"));
		String response = CommonUtil.getResponseFromInputJson(inputStream);
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("String response for request: {0} "), response);

		T responseData = JacksonUtil.mapJsonToObject(response, class1);
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("T responseData {0} "), responseData);
		if (responseData instanceof Response && ((Response) responseData).getBody() == null) {
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("responseData.getBody is null "));
			throw SDKException.getSDKException(ErrorConstants.ErrorMessage.JSONSTRING_TO_OBJECT_CONVERSION_FAILED,
					response);
		}
		if (responseData instanceof SecureResponse && (LibraryConstants.SUCCESS_STATUS
				.equals(((SecureResponse) responseData).getBody().getResultInfo().getResultStatus())
				|| LibraryConstants.TXN_SUCCESS_STATUS
						.equals(((SecureResponse) responseData).getBody().getResultInfo().getResultStatus())
				|| LibraryConstants.PENDING_STATUS
						.equals(((SecureResponse) responseData).getBody().getResultInfo().getResultStatus()))) {
			boolean isValidated = false;
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("validating signature"));
			String body = CommonUtil.validateJsonAndGetBodyText(response);
			isValidated = SignatureUtil.validateSignature(response, body,
					((SecureResponse) responseData).getHead().getSignature());
			if (!isValidated) {
				LOGGER.log(Level.INFO, CommonUtil.getLogMessage("signature validation failed "));
				throw SDKException.getSignatureValidationFailedException(response);
			}
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("signature validation passed "));
		}
		return new SDKResponse<>(responseData, response);
	}

	/**
	 * used to call process when queryParams is null for any request
	 * 
	 * @param request     object to send as post data
	 * @param url         url for the api
	 * @param mediaType   mediaType of the request
	 * @param readTimeout read timeout of the api hit
	 * @param             <T> Generic class
	 * @param class1      Class for which response should be received
	 * @return {@link SDKResponse} containing response string from api hit and
	 *         response object
	 * @throws Exception as validateSignature can throw error
	 */
	public static <T> SDKResponse<T> process(Object request, String url, String mediaType, Time readTimeout,
			Class<T> class1) throws Exception {
		return process(request, url, null, mediaType, readTimeout, class1);
	}
}
