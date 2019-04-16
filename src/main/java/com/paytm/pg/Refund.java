/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg;

import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.MDC;

import static com.paytm.pg.constants.LibraryConstants.LOGGER;
import static com.paytm.pg.constants.LibraryConstants.UTILITY_CLASS_EXCEPTION;

import com.paytm.merchant.models.RefundDetail;
import com.paytm.merchant.models.RefundStatusDetail;
import com.paytm.merchant.models.SDKResponse;
import com.paytm.pg.constants.LibraryConstants;
import com.paytm.pg.constants.MerchantProperties;
import com.paytm.pg.utils.CommonUtil;
import com.paytm.pg.utils.SignatureUtil;
import com.paytm.pgplus.request.NativeRefundStatusRequest;
import com.paytm.pgplus.request.NativeRefundStatusRequestBody;
import com.paytm.pgplus.request.RefundInitiateRequest;
import com.paytm.pgplus.request.RefundInitiateRequestBody;
import com.paytm.pgplus.request.SecureRequestHeader;
import com.paytm.pgplus.response.AsyncRefundResponse;
import com.paytm.pgplus.response.AsyncRefundResponseBody;
import com.paytm.pgplus.response.NativeRefundStatusResponse;
import com.paytm.pgplus.response.NativeRefundStatusResponseBody;

/**
 * This class is handle all the Refund calls from Merchant (i.e DemoApp.java)
 * and create request objects and make call to the respective controller.
 * 
 * This class receive the Paytm response objects and translate the to their
 * respective merchant response objects and returns call to Merchant.
 */
public class Refund {

	private Refund() {
		throw new IllegalStateException(UTILITY_CLASS_EXCEPTION);
	}

	/**
	 * This method gets RefundDetail object as parameter and returns the
	 * SDKResponse(AsyncRefundResponse).
	 * 
	 * It creates request object to call ProcessRequest.process. It returns the
	 * SDKResponse(AsyncRefundResponse) which will be used by merchant in future. It
	 * handles the exception if occurred, and returns the respective object with
	 * error message.
	 * 
	 * @param refundDetail object containing data regarding refund
	 * @return {@link SDKResponse} containing response string from api hit and
	 *         response object
	 */
	public static SDKResponse<AsyncRefundResponse> initiateRefund(RefundDetail refundDetail) {

		try {
			MDC.put(LibraryConstants.X_REQUEST_ID, CommonUtil.getRequestId());
			if (!MerchantProperties.isInitialized()) {
				LOGGER.log(Level.INFO, CommonUtil.getLogMessage(" MerchantProperties are not initialized "));
				return CommonUtil.getSDKResponse(SDKException.getMerchantPropertyInitializationException(),
						new AsyncRefundResponse(null, new AsyncRefundResponseBody()));
			}
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("In initiateRefund RefundDetail: {0} "), refundDetail);
			validateRefund(refundDetail);
			RefundInitiateRequest request = createRefundInitiateRequest(refundDetail);
			request.getHead().setSignature(SignatureUtil.getSignature(request.getBody()));
			return Request.process(request, MerchantProperties.getRefundUrl(), LibraryConstants.MEDIA_TYPE_JSON,
					refundDetail.getReadTimeout(), AsyncRefundResponse.class);
		} catch (Exception e) {
			return CommonUtil.getSDKResponse(e, new AsyncRefundResponse(null, new AsyncRefundResponseBody()));
		} finally {
			MDC.remove(LibraryConstants.X_REQUEST_ID);
		}
	}

	/**
	 * This method gets RefundStatusDetail object as parameter and returns the
	 * SDKResponse(NativeRefundStatusResponse).
	 * 
	 * It creates request object to call ProcessRequest.process. It returns the
	 * SDKResponse(NativeRefundStatusResponse) which contains refund status object.
	 * It handles the exception if occurred, and returns the respective object with
	 * error message.
	 * 
	 * @param refundStatusDetail object containing data regarding refund status
	 * @return {@link SDKResponse} containing response string from api hit and
	 *         response object
	 */
	public static SDKResponse<NativeRefundStatusResponse> getRefundStatus(RefundStatusDetail refundStatusDetail) {

		try {
			MDC.put(LibraryConstants.X_REQUEST_ID, CommonUtil.getRequestId());
			if (!MerchantProperties.isInitialized()) {
				LOGGER.log(Level.INFO, CommonUtil.getLogMessage(" MerchantProperties are not initialized "));
				return CommonUtil.getSDKResponse(SDKException.getMerchantPropertyInitializationException(),
						new NativeRefundStatusResponse(null, new NativeRefundStatusResponseBody()));
			}
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("In getRefundStatus refundStatusDetail: {0} "),
					refundStatusDetail);
			validateRefundStatus(refundStatusDetail);
			NativeRefundStatusRequest request = createRefundStatusRequest(refundStatusDetail);
			request.getHead().setSignature(SignatureUtil.getSignature(request.getBody()));
			return Request.process(request, MerchantProperties.getRefundStatusUrl(), LibraryConstants.MEDIA_TYPE_JSON,
					refundStatusDetail.getReadTimeout(), NativeRefundStatusResponse.class);
		} catch (Exception e) {
			return CommonUtil.getSDKResponse(e,
					new NativeRefundStatusResponse(null, new NativeRefundStatusResponseBody()));
		} finally {
			MDC.remove(LibraryConstants.X_REQUEST_ID);
		}
	}

	/**
	 * returns RefundInitiateRequest object
	 */
	private static RefundInitiateRequest createRefundInitiateRequest(RefundDetail refundDetail) {
		SecureRequestHeader head = CommonUtil.getSecureRequestHeader(MerchantProperties.getClientId(), null, null);
		RefundInitiateRequestBody body = refundDetail.createRefundInitiateRequestBody();
		return createRefundInitiateRequest(head, body);
	}

	/**
	 * returns RefundInitiateRequest object
	 */
	private static RefundInitiateRequest createRefundInitiateRequest(SecureRequestHeader head,
			RefundInitiateRequestBody body) {
		RefundInitiateRequest request = new RefundInitiateRequest();
		request.setHead(head);
		request.setBody(body);
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("RefundInitiateRequest object {0} "), request);
		return request;
	}

	/**
	 * returns NativeRefundStatusRequest object
	 */
	private static NativeRefundStatusRequest createRefundStatusRequest(RefundStatusDetail refundStatusDetail) {
		SecureRequestHeader head = CommonUtil.getSecureRequestHeader(MerchantProperties.getClientId(), null, null);
		NativeRefundStatusRequestBody body = refundStatusDetail.createNativeRefundStatusRequestBody();
		return createRefundStatusRequest(head, body);
	}

	/**
	 * returns NativeRefundStatusRequest object
	 */

	private static NativeRefundStatusRequest createRefundStatusRequest(SecureRequestHeader head,
			NativeRefundStatusRequestBody body) {
		NativeRefundStatusRequest request = new NativeRefundStatusRequest(head, body);
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("NativeRefundStatusRequest object {0} "), request);
		return request;
	}

	/**
	 * validateRefund checks if all mandatory parameters are present for Refund api
	 * call. If not, then is will throw the RequestValidationException exception
	 */
	private static void validateRefund(RefundDetail refundDetail) {
		if (StringUtils.isEmpty(refundDetail.getOrderId().trim()) || StringUtils.isEmpty(refundDetail.getRefId().trim())
				|| StringUtils.isEmpty(refundDetail.getTxnId().trim())
				|| StringUtils.isEmpty(refundDetail.getTxnType().trim())
				|| StringUtils.isEmpty(refundDetail.getRefundAmount().trim())) {
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage(" validateRefund failed "));
			throw SDKException.getMissingMandatoryParametersException();
		}
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage(" validateRefund pass "));
	}

	/**
	 * validateRefundStatus checks if all mandatory parameters are present for
	 * Refund status api call. If not, then is will throw the
	 * RequestValidationException exception
	 */
	private static void validateRefundStatus(RefundStatusDetail refundStatusDetail) {
		if (StringUtils.isEmpty(refundStatusDetail.getOrderId().trim())
				|| StringUtils.isEmpty(refundStatusDetail.getRefId().trim())) {
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage(" validateRefundStatus failed "));
			throw SDKException.getMissingMandatoryParametersException();
		}
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage(" validateRefundStatus pass "));

	}
}
