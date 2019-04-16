/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/
 
package com.paytm.merchant.models;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.paytm.pg.constants.LibraryConstants;

public class PeonBodyInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_GATEWAYNAME)
	private String gatewayName = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_PAYMENTMODE)
	private String paymentMode = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_TXNDATE)
	private String txnDate = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_TXNDATETIME)
	private String txnDateTime = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_CUSTID)
	private String custId = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_STATUS)
	private String txnStatus = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_MID)
	private String mid = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_ORDERID)
	private String orderId = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_CURRENCY)
	private String txnCurrency = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_TXNID)
	private String txnId = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_TXNAMOUNT)
	private String txnAmount = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_BANKTXNID)
	private String bankTxnId = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_BANKNAME)
	private String bankName = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_RESPMSG)
	private String responseMessage = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_RESPCODE)
	private String responseCode = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_ENC_PARAMS)
	private String encParams;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_CHILDTXNLIST)
	private String childTxnList;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_SUBSID)
	private String subsId;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_MERCUNQREF)
	private String merchantUniqueReference = "";

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_PROMOCAMPID)
	private String promoCode;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_PROMORESPCODE)
	private String promoRespCode;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_PROMOSTATUS)
	private String promoStatus;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_CARD_INDEX_NO)
	private String cardIndexNo;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_MASKED_CARD_NO)
	private String maskedCardNo;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_CHECKSUMHASH)
	private String checksum;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_TRANSACTION_TYPE)
	private String transactionType;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_REFUND_AMOUNT)
	private String refundAmount;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_MASKED_CUSTOMER_MOBILE_NUMBER)
	private String maskedCustomerMobileNumber;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_POS_ID)
	private String posId;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_UNIQUE_REFERENCE_LABEL)
	private String uniqueReferenceLabel;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_UNIQUE_REFERENCE_VALUE)
	private String uniqueReferenceValue;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_PCC_CODE)
	private String pccCode;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_PRN)
	private String prn;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_UDF1)
	private String udf1;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_UDF2)
	private String udf2;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_UDF3)
	private String udf3;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_COMMENTS)
	private String comments;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_AUTHCODE)
	private String authCode;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_RRN)
	private String rrn;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_LOYALTYPOINT)
	private String loyaltyPoints;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY_VPA)
	private String vpa;

	private String clientId;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_FUND_SOURCE_VERIFICATION)
	private String fundSourceVerification;

	private String getValue(String value) {
		if (value == null)
			return StringUtils.EMPTY;
		else
			return value;
	}

	public String getGatewayName() {
		return getValue(gatewayName);
	}

	public void setGatewayName(final String gatewayName) {
		if (gatewayName != null)
			this.gatewayName = gatewayName;
	}

	public String getPaymentMode() {
		return getValue(paymentMode);
	}

	public void setPaymentMode(final String paymentMode) {
		if (paymentMode != null)
			this.paymentMode = paymentMode;
	}

	public String getTxnDate() {
		return getValue(txnDate);
	}

	public void setTxnDate(final String txnDate) {
		if (txnDate != null)
			this.txnDate = txnDate;
	}

	public String getCustId() {
		return getValue(custId);
	}

	public void setCustId(final String custId) {
		if (custId != null)
			this.custId = custId;
	}

	public String getTxnStatus() {
		return getValue(txnStatus);
	}

	public void setTxnStatus(final String txnStatus) {
		if (txnStatus != null)
			this.txnStatus = txnStatus;
	}

	public String getMid() {
		return getValue(mid);
	}

	public void setMid(final String mid) {
		if (mid != null)
			this.mid = mid;
	}

	public String getOrderId() {
		return getValue(orderId);
	}

	public void setOrderId(final String orderId) {
		if (orderId != null)
			this.orderId = orderId;
	}

	public String getTxnCurrency() {
		return getValue(txnCurrency);
	}

	public void setTxnCurrency(final String txnCurrency) {
		if (txnCurrency != null)
			this.txnCurrency = txnCurrency;
	}

	public String getTxnId() {
		return getValue(txnId);
	}

	public void setTxnId(final String txnId) {
		if (txnId != null)
			this.txnId = txnId;
	}

	public String getTxnAmount() {
		return getValue(txnAmount);
	}

	public void setTxnAmount(final String txnAmount) {
		if (txnAmount != null)
			this.txnAmount = txnAmount;
	}

	public String getBankTxnId() {
		return getValue(bankTxnId);
	}

	public void setBankTxnId(final String bankTxnId) {
		if (bankTxnId != null)
			this.bankTxnId = bankTxnId;
	}

	public String getBankName() {
		return getValue(bankName);
	}

	public void setBankName(final String bankName) {
		if (bankName != null)
			this.bankName = bankName;
	}

	public String getResponseMessage() {
		return getValue(responseMessage);
	}

	public void setResponseMessage(final String responseMessage) {
		if (responseMessage != null)
			this.responseMessage = responseMessage;
	}

	public String getResponseCode() {
		return getValue(responseCode);
	}

	public void setResponseCode(final String responseCode) {
		if (responseCode != null)
			this.responseCode = responseCode;
	}

	public String getEncParams() {
		return encParams;
	}

	public void setEncParams(final String encParams) {
		this.encParams = encParams;
	}

	public String getTxnDateTime() {
		return getValue(txnDateTime);
	}

	public void setTxnDateTime(final String txnDateTime) {
		if (txnDateTime != null)
			this.txnDateTime = txnDateTime;
	}

	public String getChildTxnList() {
		return childTxnList;
	}

	public void setChildTxnList(final String childTxnList) {
		this.childTxnList = childTxnList;
	}

	public String getSubsId() {
		return subsId;
	}

	public void setSubsId(final String subsId) {
		this.subsId = subsId;
	}

	public String getMerchantUniqueReference() {
		return getValue(merchantUniqueReference);
	}

	public void setMerchantUniqueReference(final String merchantUniqueReference) {
		if (merchantUniqueReference != null) {
			this.merchantUniqueReference = merchantUniqueReference;
		}
	}

	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(final String promoCode) {
		this.promoCode = promoCode;
	}

	public String getPromoRespCode() {
		return promoRespCode;
	}

	public void setPromoRespCode(final String promoRespCode) {
		this.promoRespCode = promoRespCode;
	}

	public String getPromoStatus() {
		return promoStatus;
	}

	public void setPromoStatus(final String promoStatus) {
		this.promoStatus = promoStatus;
	}

	public String getCardIndexNo() {
		return cardIndexNo;
	}

	public void setCardIndexNo(final String cardIndexNo) {
		this.cardIndexNo = cardIndexNo;
	}

	public String getMaskedCardNo() {
		return maskedCardNo;
	}

	public void setMaskedCardNo(final String maskedCardNo) {
		this.maskedCardNo = maskedCardNo;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(final String transactionType) {
		this.transactionType = transactionType;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(final String refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getMaskedCustomerMobileNumber() {
		return maskedCustomerMobileNumber;
	}

	public void setMaskedCustomerMobileNumber(final String maskedCustomerMobileNumber) {
		this.maskedCustomerMobileNumber = maskedCustomerMobileNumber;
	}

	public String getPosId() {
		return posId;
	}

	public void setPosId(final String posId) {
		this.posId = posId;
	}

	public String getUniqueReferenceLabel() {
		return uniqueReferenceLabel;
	}

	public void setUniqueReferenceLabel(final String uniqueReferenceLabel) {
		this.uniqueReferenceLabel = uniqueReferenceLabel;
	}

	public String getUniqueReferenceValue() {
		return uniqueReferenceValue;
	}

	public void setUniqueReferenceValue(final String uniqueReferenceValue) {
		this.uniqueReferenceValue = uniqueReferenceValue;
	}

	public String getPccCode() {
		return pccCode;
	}

	public void setPccCode(final String pccCode) {
		this.pccCode = pccCode;
	}

	public String getPrn() {
		return prn;
	}

	public void setPrn(final String prn) {
		this.prn = prn;
	}

	public String getUdf1() {
		return udf1;
	}

	public void setUdf1(final String udf1) {
		this.udf1 = udf1;
	}

	public String getUdf2() {
		return udf2;
	}

	public void setUdf2(final String udf2) {
		this.udf2 = udf2;
	}

	public String getUdf3() {
		return udf3;
	}

	public void setUdf3(final String udf3) {
		this.udf3 = udf3;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(final String comments) {
		this.comments = comments;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(String loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public String getVpa() {
		return vpa;
	}

	public void setVpa(String vpa) {
		this.vpa = vpa;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getFundSourceVerification() {
		return fundSourceVerification;
	}

	public void setFundSourceVerification(String fundSourceVerification) {
		this.fundSourceVerification = fundSourceVerification;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(gatewayName).append(paymentMode).append(txnDate).append(txnDateTime)
				.append(custId).append(txnStatus).append(mid).append(orderId).append(txnCurrency).append(txnId)
				.append(txnAmount).append(bankTxnId).append(bankName).append(responseMessage).append(responseCode)
				.append(encParams).append(childTxnList).append(subsId).append(merchantUniqueReference).append(promoCode)
				.append(promoRespCode).append(promoStatus).append(cardIndexNo).append(maskedCardNo).append(checksum)
				.append(transactionType).append(refundAmount).append(maskedCustomerMobileNumber).append(posId)
				.append(uniqueReferenceLabel).append(uniqueReferenceValue).append(pccCode).append(prn).append(udf1)
				.append(udf2).append(udf3).append(comments).append(authCode).append(rrn).append(loyaltyPoints)
				.append(vpa).append(clientId).append(fundSourceVerification).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof PeonBodyInfo)) {
			return false;
		}
		PeonBodyInfo object = (PeonBodyInfo) obj;
		return new EqualsBuilder().append(gatewayName, object.gatewayName).append(paymentMode, object.paymentMode)
				.append(txnDate, object.txnDate).append(txnDateTime, object.txnDateTime).append(custId, object.custId)
				.append(txnStatus, object.txnStatus).append(mid, object.mid).append(orderId, object.orderId)
				.append(txnCurrency, object.txnCurrency).append(txnId, object.txnId).append(txnAmount, object.txnAmount)
				.append(bankTxnId, object.bankTxnId).append(bankName, object.bankName)
				.append(responseMessage, object.responseMessage).append(responseCode, object.responseCode)
				.append(encParams, object.encParams).append(childTxnList, object.childTxnList)
				.append(subsId, object.subsId).append(merchantUniqueReference, object.merchantUniqueReference)
				.append(promoCode, object.promoCode).append(promoRespCode, object.promoRespCode)
				.append(promoStatus, object.promoStatus).append(cardIndexNo, object.cardIndexNo)
				.append(maskedCardNo, object.maskedCardNo).append(checksum, object.checksum)
				.append(transactionType, object.transactionType).append(refundAmount, object.refundAmount)
				.append(maskedCustomerMobileNumber, object.maskedCustomerMobileNumber).append(posId, object.posId)
				.append(uniqueReferenceLabel, object.uniqueReferenceLabel)
				.append(uniqueReferenceValue, object.uniqueReferenceValue).append(pccCode, object.pccCode)
				.append(prn, object.prn).append(udf1, object.udf1).append(udf2, object.udf2).append(udf3, object.udf3)
				.append(comments, object.comments).append(authCode, object.authCode).append(rrn, object.rrn)
				.append(loyaltyPoints, object.loyaltyPoints).append(vpa, object.vpa).append(clientId, object.clientId)
				.append(fundSourceVerification, object.fundSourceVerification).isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
