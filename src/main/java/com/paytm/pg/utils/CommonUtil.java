/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg.utils;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.jboss.logging.MDC;

import static com.paytm.pg.constants.LibraryConstants.LOGGER;
import static com.paytm.pg.constants.LibraryConstants.UTILITY_CLASS_EXCEPTION;
import com.paytm.merchant.models.SDKResponse;
import com.paytm.pg.SDKException;
import com.paytm.pg.constants.ErrorConstants;
import com.paytm.pg.constants.LibraryConstants;
import com.paytm.pgplus.enums.EChannelId;
import com.paytm.pgplus.request.SecureRequestHeader;
import com.paytm.pgplus.response.ResultInfo;
import com.paytm.pgplus.response.interfaces.Response;

/**
 * This class have the common utility methods.
 */
public class CommonUtil {

	private CommonUtil() {
		throw new IllegalStateException(UTILITY_CLASS_EXCEPTION);
	}

	/** body pattern */
	private static final Pattern bodyStartPatternForJson = Pattern.compile("\"body\"[ \n\r]*:[ \n\r]*\\{");
	/** head pattern */
	private static final Pattern headStartPatternForJson = Pattern.compile("\"head\"[ \n\r]*:[ \n\r]*\\{");

	/**
	 * This methods returns the SDKResponse on the basis of Exception occured and
	 * object received.
	 * 
	 * @param e   Exception occurred
	 * @param obj Generic Response received
	 * @param     <T> Generic object to be received
	 * @return SDKResponse object with Exception result object created with error
	 *         message
	 */
	public static <T> SDKResponse<T> getSDKResponse(Exception e, T obj) {
		LOGGER.log(Level.SEVERE, getLogMessage("getSDKResponse with exception : "), e);
		String message = e.getMessage();
		if (StringUtils.isBlank(message)) {
			message = ErrorConstants.SYSTEM_ERROR;
		}
		ResultInfo result = new ResultInfo(ErrorConstants.FAILURE, ErrorConstants.ErrorCode.DEFAULT, message);
		((Response) obj).getBody().setResultInfo(result);
		if (e instanceof SDKException) {
			LOGGER.log(Level.SEVERE, getLogMessage("Exception instanceof SDKException with rawData : {0} "),
					((SDKException) e).getRawData());
			return new SDKResponse<>(obj, ((SDKException) e).getRawData());
		}
		return new SDKResponse<>(obj, null);
	}

	/**
	 * This method returns SecureRequestHeader with given parameters.
	 * 
	 * @param clientId  client id of merchant
	 * @param workFlow  used in enhanced flow
	 * @param channelId channel id from which call is made WEB or WAP
	 * @return SecureRequestHeader object
	 */
	public static SecureRequestHeader getSecureRequestHeader(String clientId, String workFlow, EChannelId channelId) {
		LOGGER.log(Level.INFO, getLogMessage("In getSecureRequestHeader()"));
		SecureRequestHeader secureRequestHeader = new SecureRequestHeader();
		secureRequestHeader.setVersion(LibraryConstants.VERSION);
		secureRequestHeader.setChannelId(channelId);
		secureRequestHeader.setRequestTimestamp(new SimpleDateFormat(LibraryConstants.DATE_FORMAT).format(new Date()));
		secureRequestHeader.setWorkFlow(workFlow);
		secureRequestHeader.setClientId(clientId);
		return secureRequestHeader;
	}

	/**
	 * This method format the json body required to make API call
	 * 
	 * @param body String to be formatted
	 * @return formatted String
	 */
	public static String formatBodyForJson(String body) {

		StrBuilder str = new StrBuilder(body);
		str.replaceAll("\\\"", "\"");
		str.replaceAll("\"{", "{");
		str.replaceAll("}\"", "}");
		return str.toString();
	}

	/**
	 * This method convert InputStream to String
	 * 
	 * @param inputStream InputStream to be converted
	 * @return converted String
	 * @throws IOException if exception occurs
	 */
	public static String getResponseFromInputJson(final InputStream inputStream) throws IOException {
		return IOUtils.toString(inputStream, "UTF-8").trim();
	}

	/**
	 * This method validate Json and return body
	 * 
	 * @param content json string
	 * @return body String
	 */
	public static String validateJsonAndGetBodyText(String content) {
		LOGGER.log(Level.INFO, getLogMessage("validateJsonAndGetBodyText for content: {0}: "), content);
		Matcher headMatcher = headStartPatternForJson.matcher(content);
		if (!headMatcher.find()) {
			LOGGER.log(Level.SEVERE, getLogMessage(" Pattern validation failed suspect: {0} "),
					headStartPatternForJson);
			throw SDKException.getSDKException("Pattern not found : " + headStartPatternForJson, content);
		}
		Matcher bodyMatcher = bodyStartPatternForJson.matcher(content);
		if (!bodyMatcher.find()) {
			LOGGER.log(Level.SEVERE, getLogMessage(" Pattern validation failed suspect: {0} "),
					bodyStartPatternForJson);
			throw SDKException.getSDKException("Pattern not found : " + bodyStartPatternForJson, content);
		}
		return getBodyString(content, headMatcher, bodyMatcher);
	}

	/**
	 * This method return body string
	 * 
	 * @param content     json string
	 * @param headMatcher Matcher matches "head":{
	 * @param bodyMatcher Matcher matches "body":{
	 * @return body String
	 */
	private static String getBodyString(String content, Matcher headMatcher, Matcher bodyMatcher) {
		int start = bodyMatcher.end() - 1;
		int end = 0;
		if (bodyMatcher.start() < headMatcher.start()) { // body is before head
			for (int i = headMatcher.start() - 1; i >= 0; i--) {
				if (content.charAt(i) == '}') {
					end = i + 1;
					break;
				}
			}
		} else { // body is after head
			int times = 0;
			for (int i = content.length() - 1; i > 0; i--) {
				if (content.charAt(i) == '}') {
					times++;
				}
				if (times == 2) {
					end = i + 1;
					break;
				}
			}
		}
		return content.substring(start, end);
	}

	/**
	 * getRequestId method is used to generate unique Id for each request
	 * 
	 * @return requestId for each request containing sdk name and version
	 */
	public static String getRequestId() {
		return LibraryConstants.JAVA_SDK_TEXT + ":" + LibraryConstants.VERSION + ":" + UUID.randomUUID().toString();
	}

	/**
	 * getLogMessage method is used to get message having request Id in PREFIX
	 * 
	 * @param msg message to be printed in logs without request Id
	 * @return String message to be printed in logs
	 */
	public static String getLogMessage(String msg) {
		Object requestId = MDC.get(LibraryConstants.X_REQUEST_ID);
		if (null != requestId) {
			return "[" + LibraryConstants.X_REQUEST_ID + ":" + (String) requestId + "]" + msg;
		}
		return msg;
	}
}
