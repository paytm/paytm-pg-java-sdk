/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;

import org.jboss.logging.MDC;

import static com.paytm.pg.constants.LibraryConstants.LOGGER;
import static com.paytm.pg.constants.LibraryConstants.UTILITY_CLASS_EXCEPTION;

import com.paytm.merchant.models.Time;
import com.paytm.pg.constants.LibraryConstants;
import com.paytm.pg.constants.MerchantProperties;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Make post request to the URL having body with query parameters and return the
 * respective response
 */
public class UrlConnectionUtil {

	private UrlConnectionUtil() {
		throw new IllegalStateException(UTILITY_CLASS_EXCEPTION);
	}

	/** default OkHttpClient */
	public static final OkHttpClient defaultClient = new OkHttpClient.Builder()
			.connectTimeout(MerchantProperties.getConnectionTimeout().getValue(),
					MerchantProperties.getConnectionTimeout().getUnit())
			.build();

	/**
	 * This method make the Api call and return the response
	 * 
	 * @param req             object to send as post data
	 * @param baseUrl         url for the api
	 * @param queryParameters parameters to be sent as query parameters
	 * @param mediaType       mediaType of the request
	 * @param readTimeout     read timeout of the api hit
	 * @return String response returned from api hit
	 * @throws Exception OkHttpClient can throw exception
	 */
	public static InputStream execute(Object req, String baseUrl, Map<String, String> queryParameters, String mediaType,
			Time readTimeout) throws Exception {
		LOGGER.log(Level.INFO,
				CommonUtil
						.getLogMessage("execute for Object: {0} & url: {1} & queryParameters: {2} & readTimeout: {3} "),
				new Object[] { req, baseUrl, queryParameters, readTimeout });
		String url = baseUrl;
		if (queryParameters != null && !queryParameters.isEmpty()) {
			url = urlBuilder(baseUrl, queryParameters);
		}
		String json = JacksonUtil.mapObjectToJson(req);
		RequestBody body = RequestBody.create(MediaType.parse(mediaType), json);
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("RequestBody {0} "), body);
		Request request = new Request.Builder().url(url).removeHeader(LibraryConstants.CONTENT_TYPE_TEXT)
				.addHeader(LibraryConstants.CONTENT_TYPE_TEXT, LibraryConstants.APPLICATION_JSON_TEXT)
				.addHeader(LibraryConstants.X_REQUEST_ID, (String) MDC.get(LibraryConstants.X_REQUEST_ID)).post(body)
				.build();
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("Request {0} "), request);
		OkHttpClient client = defaultClient.newBuilder().readTimeout(readTimeout.getValue(), readTimeout.getUnit())
				.build();
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("OkHttpClient created"));
		Response response = client.newCall(request).execute();
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("Response initiated {0} "), response);
		return response.body().byteStream();
	}

	/**
	 * This method returns the url string with adding queryParameters
	 * 
	 * @param url             base url
	 * @param queryParameters query parameters for the url
	 * @return String complete url with query parameters
	 */
	public static String urlBuilder(String url, Map<String, String> queryParameters) {
		HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();

		Iterator<Map.Entry<String, String>> itr = queryParameters.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
		}
		return urlBuilder.build().toString();
	}

	/**
	 * This method returns Map for query Parameters required in Api call
	 * 
	 * @param mid     mid of the merchant
	 * @param orderId order id of thr order
	 * @return Map containing mid and order id
	 */
	public static Map<String, String> generateQueryParameters(String mid, String orderId) {
		Map<String, String> params = new HashMap<>();
		params.put(LibraryConstants.MID_TEXT, mid);
		params.put(LibraryConstants.ORDERID_TEXT, orderId);

		return params;
	}

}
