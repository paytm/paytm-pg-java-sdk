/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.merchant.models;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.paytm.pg.constants.MerchantProperties;
import com.paytm.pgplus.enums.UserSubWalletType;
import com.paytm.pgplus.request.RefundInitiateRequestBody;

/**
 * This class is used to store all the Refund information Request of
 * initiateRefund api is translated from Refund object
 */
public class RefundDetail {

	/**
	 * Refund parameters
	 */
	/** required */
	/** Unique order for each order request */
	private String orderId;
	/** REF ID returned in Payment call */
	private String refId;
	/** Transaction ID returned in Payment Api */
	private String txnId;
	/** Transaction Type returned in Payment Api */
	private String txnType;
	/**
	 * Refund Amount to be refunded (should not be greater than the Amount paid in
	 * the Transaction)
	 */
	private String refundAmount;

	/** optional */
	/** comments merchant want to add in refund */
	private String comments;

	private Map<UserSubWalletType, BigDecimal> subwalletAmount;

	private Map<String, Object> extraParamsMap;

	/** Read TimeOut for Refund Api */
	private Time readTimeout;

	public RefundDetail(RefundDetailBuilder refundBuilder) {
		this(refundBuilder.orderId, refundBuilder.refId, refundBuilder.txnId, refundBuilder.txnType,
				refundBuilder.refundAmount);
		this.extraParamsMap = refundBuilder.extraParamsMap;
		this.refundAmount = refundBuilder.refundAmount;
		this.comments = refundBuilder.comments;
		this.subwalletAmount = refundBuilder.subwalletAmount;
		this.readTimeout = refundBuilder.readTimeout;
	}

	private RefundDetail(String orderId, String refId, String txnId, String txnType, String refundAmount) {
		super();
		this.orderId = orderId;
		this.refId = refId;
		this.txnId = txnId;
		this.txnType = txnType;
		this.refundAmount = refundAmount;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getRefId() {
		return refId;
	}

	public Map<String, Object> getExtraParamsMap() {
		return extraParamsMap;
	}

	public String getTxnId() {
		return txnId;
	}

	public String getTxnType() {
		return txnType;
	}

	public String getRefundAmount() {
		return refundAmount;
	}

	public String getComments() {
		return comments;
	}

	public Map<UserSubWalletType, BigDecimal> getSubwalletAmount() {
		return subwalletAmount;
	}

	public Time getReadTimeout() {
		return readTimeout;
	}

	/**
	 * RefundBuilder is used to build the Refund object
	 */
	public static class RefundDetailBuilder {
		private String orderId;
		private String refId;
		private Map<String, Object> extraParamsMap;
		private String txnId;
		private String txnType;
		private String refundAmount;
		private String comments;
		private Map<UserSubWalletType, BigDecimal> subwalletAmount;
		private Time readTimeout = new Time(5, TimeUnit.MINUTES);

		/**
		 * mandatory parameters
		 * 
		 * @param orderId      orderId to be set
		 * @param refId        refId to be set
		 * @param txnId        txnId to be set
		 * @param txnType      txnType to be set
		 * @param refundAmount refundAmount to be set
		 */
		public RefundDetailBuilder(String orderId, String refId, String txnId, String txnType, String refundAmount) {
			super();
			this.orderId = orderId;
			this.refId = refId;
			this.txnId = txnId;
			this.txnType = txnType;
			this.refundAmount = refundAmount;
		}

		/**
		 * builder method
		 * 
		 * @return {@link RefundDetail}
		 */
		public RefundDetail build() {
			return new RefundDetail(this);
		}

		/**
		 * @param orderId orderId to be set
		 * @return RefundDetailBuilder
		 */
		public RefundDetailBuilder setOrderId(String orderId) {
			this.orderId = orderId;
			return this;
		}

		/**
		 * @param refId refId to be set
		 * @return RefundDetailBuilder
		 */
		public RefundDetailBuilder setRefId(String refId) {
			this.refId = refId;
			return this;
		}

		/**
		 * @param extraParamsMap extraParamsMap to be set
		 * @return RefundDetailBuilder
		 */

		public RefundDetailBuilder setExtraParamsMap(Map<String, Object> extraParamsMap) {
			this.extraParamsMap = extraParamsMap;
			return this;
		}

		/**
		 * @param txnId txnId to be set
		 * @return RefundDetailBuilder
		 */
		public RefundDetailBuilder setTxnId(String txnId) {
			this.txnId = txnId;
			return this;
		}

		/**
		 * @param txnType txnType to be set
		 * @return RefundDetailBuilder
		 */
		public RefundDetailBuilder setTxnType(String txnType) {
			this.txnType = txnType;
			return this;
		}

		/**
		 * @param refundAmount refundAmount to be set
		 * @return RefundDetailBuilder
		 */
		public RefundDetailBuilder setRefundAmount(String refundAmount) {
			this.refundAmount = refundAmount;
			return this;
		}

		/**
		 * @param comments comments to be set
		 * @return RefundDetailBuilder
		 */
		public RefundDetailBuilder setComments(String comments) {
			this.comments = comments;
			return this;
		}

		/**
		 * @param subwalletAmount subwalletAmount to be set
		 * @return RefundDetailBuilder
		 */
		public RefundDetailBuilder setSubwalletAmount(Map<UserSubWalletType, BigDecimal> subwalletAmount) {
			this.subwalletAmount = subwalletAmount;
			return this;
		}

		/**
		 * @param readTimeout readTimeout to be set
		 * @return RefundDetailBuilder
		 */
		public RefundDetailBuilder setReadTimeout(Time readTimeout) {
			this.readTimeout = readTimeout;
			return this;
		}
	}

	public RefundInitiateRequestBody createRefundInitiateRequestBody() {
		RefundInitiateRequestBody refundInitiateRequestBody = new RefundInitiateRequestBody();
		refundInitiateRequestBody.setMid(MerchantProperties.getMid());
		refundInitiateRequestBody.setOrderId(this.getOrderId());
		refundInitiateRequestBody.setRefId(this.getRefId());
		refundInitiateRequestBody.setExtraParamsMap(this.getExtraParamsMap());
		refundInitiateRequestBody.setTxnId(this.getTxnId());
		refundInitiateRequestBody.setRefundAmount(this.getRefundAmount());
		refundInitiateRequestBody.setComments(this.getComments());
		refundInitiateRequestBody.setTxnType(this.getTxnType());
		refundInitiateRequestBody.setSubwalletAmount(this.getSubwalletAmount());

		return refundInitiateRequestBody;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(orderId).append(refId).append(txnId).append(txnType)
				.append(refundAmount).append(comments).append(subwalletAmount).append(extraParamsMap)
				.append(readTimeout).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof RefundDetail)) {
			return false;
		}
		RefundDetail object = (RefundDetail) obj;
		return new EqualsBuilder().append(orderId, object.orderId).append(refId, object.refId)
				.append(txnId, object.txnId).append(txnType, object.txnType).append(refundAmount, object.refundAmount)
				.append(comments, object.comments).append(subwalletAmount, object.subwalletAmount)
				.append(extraParamsMap, object.extraParamsMap).append(readTimeout, object.readTimeout).isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
