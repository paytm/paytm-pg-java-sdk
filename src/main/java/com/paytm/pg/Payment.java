/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.pg;

import java.util.logging.Level;
import static com.paytm.pg.constants.LibraryConstants.LOGGER;
import static com.paytm.pg.constants.LibraryConstants.UTILITY_CLASS_EXCEPTION;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.MDC;

import com.paytm.merchant.models.PaymentDetail;
import com.paytm.merchant.models.PaymentStatusDetail;
import com.paytm.merchant.models.SDKResponse;
import com.paytm.pg.constants.LibraryConstants;
import com.paytm.pg.constants.MerchantProperties;
import com.paytm.pg.utils.CommonUtil;
import com.paytm.pg.utils.SignatureUtil;
import com.paytm.pg.utils.UrlConnectionUtil;
import com.paytm.pgplus.request.InitiateTransactionRequest;
import com.paytm.pgplus.request.InitiateTransactionRequestBody;
import com.paytm.pgplus.request.NativePaymentStatusRequest;
import com.paytm.pgplus.request.NativePaymentStatusRequestBody;
import com.paytm.pgplus.request.SecureRequestHeader;
import com.paytm.pgplus.response.InitiateTransactionResponse;
import com.paytm.pgplus.response.InitiateTransactionResponseBody;
import com.paytm.pgplus.response.NativePaymentStatusResponse;
import com.paytm.pgplus.response.NativePaymentStatusResponseBody;

/**
 * This class is handle all the Payment calls from Merchant (i.e DemoApp.java)
 * and create request objects and make call to the respective controller.
 * 
 * This class receive the Paytm response objects and translate the to their
 * respective merchant response objects and returns call to Merchant.
 */
public class Payment {

	private Payment() {
		throw new IllegalStateException(UTILITY_CLASS_EXCEPTION);
	}

	/**
	 * This method gets PaymentDetail object as parameter and returns the
	 * SDKResponse(InitiateTransactionResponse).
	 * 
	 * It creates request object to call ProcessRequest.process. It returns the
	 * SDKResponse(InitiateTransactionResponse) which holds the createTxnToken
	 * result parameters which will be used by merchant in future. It handles the
	 * exception if occurred, and returns the respective object with error message.
	 * 
	 * @param paymentDetails object containing data regarding payment
	 * @return {@link SDKResponse} containing response string from api hit and
	 *         response object
	 */
	public static SDKResponse<InitiateTransactionResponse> createTxnToken(PaymentDetail paymentDetails) {
		try {
			MDC.put(LibraryConstants.X_REQUEST_ID, CommonUtil.getRequestId());
			if (!MerchantProperties.isInitialized()) {
				LOGGER.log(Level.INFO, CommonUtil.getLogMessage("MerchantProperties are not initialized"));
				return CommonUtil.getSDKResponse(SDKException.getMerchantPropertyInitializationException(),
						new InitiateTransactionResponse(null, new InitiateTransactionResponseBody()));
			}
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("In createTxnToken PaymentDetail: {0} "), paymentDetails);
			validateCreateTxnToken(paymentDetails);
			InitiateTransactionRequest request = createInitiateTransactionRequest(paymentDetails);
			request.getHead().setSignature(SignatureUtil.getSignature(request.getBody()));

			return Request.process(request, MerchantProperties.getInitiateTxnUrl(),
					UrlConnectionUtil.generateQueryParameters(request.getBody().getMid(),
							request.getBody().getOrderId()),
					LibraryConstants.MEDIA_TYPE_JSON, paymentDetails.getReadTimeout(),
					InitiateTransactionResponse.class);
		} catch (Exception e) {
			return CommonUtil.getSDKResponse(e,
					new InitiateTransactionResponse(null, new InitiateTransactionResponseBody()));
		} finally {
			MDC.remove(LibraryConstants.X_REQUEST_ID);
		}

	}

	/**
	 * This method gets PaymentStatusDetail object as parameter and returns the
	 * SDKRespons(NativePaymentStatusResponse).
	 * 
	 * It creates request object to call ProcessRequest.process. It returns the
	 * SDKResponse(NativePaymentStatusResponse) which holds the getPaymentStatus
	 * result parameters which will be used by merchant in future. It handles the
	 * exception if occurred, and returns the respective object with error message.
	 * 
	 * @param paymentStatusDetail object containing data regarding payment status
	 * @return {@link SDKResponse} containing response string from api hit and
	 *         response object
	 */
	public static SDKResponse<NativePaymentStatusResponse> getPaymentStatus(PaymentStatusDetail paymentStatusDetail) {
		try {
			MDC.put(LibraryConstants.X_REQUEST_ID, CommonUtil.getRequestId());
			if (!MerchantProperties.isInitialized()) {
				LOGGER.log(Level.INFO, CommonUtil.getLogMessage(" MerchantProperties are not initialized "));
				return CommonUtil.getSDKResponse(SDKException.getMerchantPropertyInitializationException(),
						new NativePaymentStatusResponse(null, new NativePaymentStatusResponseBody()));
			}
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage("In getPaymentStatus PaymentStatusDetail: {0} "),
					paymentStatusDetail);
			validateGetPaymentStatus(paymentStatusDetail);
			NativePaymentStatusRequest request = createNativePaymentStatusRequest(paymentStatusDetail);
			request.getHead().setSignature(SignatureUtil.getSignature(request.getBody()));

			return Request.process(request, MerchantProperties.getPaymentStatusUrl(), LibraryConstants.MEDIA_TYPE_JSON,
					paymentStatusDetail.getReadTimeout(), NativePaymentStatusResponse.class);
		} catch (Exception e) {
			return CommonUtil.getSDKResponse(e,
					new NativePaymentStatusResponse(null, new NativePaymentStatusResponseBody()));
		} finally {
			MDC.remove(LibraryConstants.X_REQUEST_ID);
		}
	}

	/**
	 * returns InitiateTransactionRequest object
	 */
	private static InitiateTransactionRequest createInitiateTransactionRequest(PaymentDetail paymentDetails) {
		SecureRequestHeader head = CommonUtil.getSecureRequestHeader(MerchantProperties.getClientId(), null,
				paymentDetails.getChannelId());
		InitiateTransactionRequestBody body = paymentDetails.createInitiateTransactionRequestBody();
		return createInitiateTransactionRequest(head, body);
	}

	/**
	 * returns InitiateTransactionRequest object
	 */
	private static InitiateTransactionRequest createInitiateTransactionRequest(SecureRequestHeader head,
			InitiateTransactionRequestBody body) {
		InitiateTransactionRequest request = new InitiateTransactionRequest();
		request.setHead(head);
		request.setBody(body);
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("InitiateTransactionRequest object {0} "), request);
		return request;
	}

	/**
	 * returns NativePaymentStatusRequest object
	 */
	private static NativePaymentStatusRequest createNativePaymentStatusRequest(
			PaymentStatusDetail paymentStatusDetail) {
		SecureRequestHeader head = CommonUtil.getSecureRequestHeader(MerchantProperties.getClientId(), null, null);
		NativePaymentStatusRequestBody body = paymentStatusDetail.createInitiateTransactionRequestBody();
		return createNativePaymentStatusRequest(head, body);
	}

	/**
	 * returns NativePaymentStatusRequest object
	 */
	private static NativePaymentStatusRequest createNativePaymentStatusRequest(SecureRequestHeader head,
			NativePaymentStatusRequestBody body) {
		NativePaymentStatusRequest request = new NativePaymentStatusRequest();
		request.setHead(head);
		request.setBody(body);
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage("NativePaymentStatusRequest object {0} "), request);
		return request;
	}

	/**
	 * validateCreateTxnToken checks if all mandatory parameters are present for
	 * CreateTxnToken api call. If not, then is will throw the
	 * RequestValidationException exception
	 */
	private static void validateCreateTxnToken(PaymentDetail paymentDetail) {
		if (StringUtils.isEmpty(paymentDetail.getOrderId().trim()) || null == paymentDetail.getTxnAmount()
				|| StringUtils.isEmpty(paymentDetail.getTxnAmount().getValue().trim())
				|| null == paymentDetail.getUserInfo()
				|| StringUtils.isEmpty(paymentDetail.getUserInfo().getCustId().trim())) {
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage(" validateCreateTxnToken failed "));
			throw SDKException.getMissingMandatoryParametersException();
		}
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage(" validateCreateTxnToken pass "));

	}

	/**
	 * validateGetPaymentStatus checks if all mandatory parameters are present for
	 * Payment Status api call. If not, then is will throw the
	 * RequestValidationException exception
	 */
	private static void validateGetPaymentStatus(PaymentStatusDetail paymentStatusDetail) {
		if (StringUtils.isEmpty(paymentStatusDetail.getOrderId().trim())) {
			LOGGER.log(Level.INFO, CommonUtil.getLogMessage(" validateGetPaymentStatus failed "));
			throw SDKException.getMissingMandatoryParametersException();
		}
		LOGGER.log(Level.INFO, CommonUtil.getLogMessage(" validateGetPaymentStatus pass "));

	}
}
