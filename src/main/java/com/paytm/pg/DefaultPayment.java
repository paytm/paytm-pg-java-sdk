/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg;

import static com.paytm.pg.constants.LibraryConstants.UTILITY_CLASS_EXCEPTION;

import java.util.Enumeration;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import com.paytm.pg.constants.LibraryConstants;
import com.paytm.pg.constants.MerchantProperties;
import com.paytm.pg.utils.CommonUtil;
import com.paytm.pg.utils.SignatureUtil;

/**
 * This class defines the method which can be used by merchant in Redirection
 * Payment Flow.
 */
public class DefaultPayment {

	private DefaultPayment() {
		throw new IllegalStateException(UTILITY_CLASS_EXCEPTION);
	}

	/**
	 * getTreeMap takes request and generate the treeMap having checksum value and
	 * other parameter comes with request. Checksum will be generated with all the
	 * parameters coming in request.
	 * 
	 * @param request request received on pgRedirect.jsp
	 * @return SortedMap Map having checksum value plus values received in request
	 * @throws Exception if exception occurred while generating checksum 
	 */
	public static SortedMap<String, String> getTreeMap(HttpServletRequest request) throws Exception {
		LibraryConstants.LOGGER.log(Level.INFO, CommonUtil.getLogMessage("getTreeMap for default flow for HttpServletRequest: {0} "), request);

		Enumeration<?> paramNames = request.getParameterNames();
		Map<?, ?> mapData = request.getParameterMap();
		TreeMap<String, String> parameters = new TreeMap<>();
		while (paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			parameters.put(paramName, ((String[]) mapData.get(paramName))[0]);
		}
		parameters.put(LibraryConstants.MID_TEXT_DEFAULT, MerchantProperties.getMid());
		parameters.put(LibraryConstants.WEBSITE_TEXT_DEFAULT, MerchantProperties.getWebsite());
		parameters.put(LibraryConstants.CALLBACK_URL_TEXT_DEFAULT, MerchantProperties.getCallbackUrl());
		parameters.put(LibraryConstants.CHECKSUMHASH_TEXT_DEFAULT, SignatureUtil.getSignature(parameters));

		return parameters;
	}

}
