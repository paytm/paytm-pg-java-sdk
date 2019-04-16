/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/
 
package com.paytm.merchant.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paytm.pg.constants.LibraryConstants;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class RefundSuccessPeonBodyInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_TXNID)
	private String txnId = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_ORDERID)
	private String orderId = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_TXNAMOUNT)
	private String txnAmount = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_REFUND_SUCCESS_PEON_BODY_TXN_STATUS)
	private String txnStatus = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_STATUS)
	private String refundStatus = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_RESPCODE)
	private String responseCode = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_RESPMSG)
	private String responseMessage = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_MID)
	private String mid = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_REFUND_SUCCESS_PEON_BODY_REFUND_AMOUNT)
	private String refundAmount = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_TXNDATE)
	private String txnDate = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_REFUND_SUCCESS_PEON_BODY_TOTAL_REFUND_AMOUNT)
	private String totalRefundAmount = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_REFUND_SUCCESS_PEON_BODY_REFUND_DATE)
	private String refundDate = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_REFUND_SUCCESS_PEON_BODY_REF_ID)
	private String refId = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_REFUND_SUCCESS_PEON_BODY_GATEWAY)
	private String gateway = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_PAYMENTMODE)
	private String paymentMode = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_REFUND_SUCCESS_PEON_BODY_REFUND_ID)
	private String refundId = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_REFUND_SUCCESS_PEON_BODY_REFUND_TYPE)
	private String refundType = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_REFUND_SUCCESS_PEON_BODY_RRN)
	private String rrn = StringUtils.EMPTY;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_ENC_PARAMS)
	private String encParams;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_CHECKSUMHASH)
	private String checksum;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_MERCHANT_CLIENT_ID)
	private String clientId;

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = emptyIfNull(txnId);
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = emptyIfNull(orderId);
	}

	public String getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(String txnAmount) {
		this.txnAmount = emptyIfNull(txnAmount);
	}

	public String getTxnStatus() {
		return txnStatus;
	}

	public void setTxnStatus(String txnStatus) {
		this.txnStatus = emptyIfNull(txnStatus);
	}

	public String getRefundStatus() {
		return refundStatus;
	}

	public void setRefundStatus(String refundStatus) {
		this.refundStatus = emptyIfNull(refundStatus);
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = emptyIfNull(responseCode);
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = emptyIfNull(responseMessage);
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = emptyIfNull(mid);
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(String refundAmount) {
		this.refundAmount = emptyIfNull(refundAmount);
	}

	public String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = emptyIfNull(txnDate);
	}

	public String getTotalRefundAmount() {
		return totalRefundAmount;
	}

	public void setTotalRefundAmount(String totalRefundAmount) {
		this.totalRefundAmount = emptyIfNull(totalRefundAmount);
	}

	public String getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(String refundDate) {
		this.refundDate = emptyIfNull(refundDate);
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = emptyIfNull(refId);
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = emptyIfNull(gateway);
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = emptyIfNull(paymentMode);
	}

	public String getRefundId() {
		return refundId;
	}

	public void setRefundId(String refundId) {
		this.refundId = emptyIfNull(refundId);
	}

	public String getRefundType() {
		return refundType;
	}

	public void setRefundType(String refundType) {
		this.refundType = emptyIfNull(refundType);
	}

	public String getEncParams() {
		return encParams;
	}

	public void setEncParams(final String encParams) {
		this.encParams = encParams;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = emptyIfNull(rrn);
	}

	private String emptyIfNull(String value) {
		if (null == value) {
			return StringUtils.EMPTY;
		}
		return value;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder(17, 37).append(txnId).append(orderId).append(txnAmount).append(txnStatus)
				.append(refundStatus).append(responseCode).append(responseMessage).append(mid).append(refundAmount)
				.append(txnDate).append(totalRefundAmount).append(refundDate).append(refId).append(gateway)
				.append(paymentMode).append(refundId).append(refundType).append(rrn).append(encParams).append(checksum)
				.append(clientId).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof RefundSuccessPeonBodyInfo)) {
			return false;
		}
		RefundSuccessPeonBodyInfo object = (RefundSuccessPeonBodyInfo) obj;
		return new EqualsBuilder().append(txnId, object.txnId).append(orderId, object.orderId)
				.append(txnAmount, object.txnAmount).append(txnStatus, object.txnStatus)
				.append(refundStatus, object.refundStatus).append(responseCode, object.responseCode)
				.append(responseMessage, object.responseMessage).append(mid, object.mid)
				.append(refundAmount, object.refundAmount).append(txnDate, object.txnDate)
				.append(totalRefundAmount, object.totalRefundAmount).append(refundDate, object.refundDate)
				.append(refId, object.refId).append(gateway, object.gateway).append(paymentMode, object.paymentMode)
				.append(refundId, object.refundId).append(refundType, object.refundType).append(rrn, object.rrn)
				.append(encParams, object.encParams).append(checksum, object.checksum).append(clientId, object.clientId)
				.isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
