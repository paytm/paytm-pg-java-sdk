/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/

package com.paytm.merchant.models;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.paytm.pg.constants.LibraryConstants;
import com.paytm.pg.constants.MerchantProperties;
import com.paytm.pgplus.enums.EChannelId;
import com.paytm.pgplus.models.ExtendInfo;
import com.paytm.pgplus.models.GoodsInfo;
import com.paytm.pgplus.models.Money;
import com.paytm.pgplus.models.PaymentMode;
import com.paytm.pgplus.models.ShippingInfo;
import com.paytm.pgplus.models.UserInfo;
import com.paytm.pgplus.request.InitiateTransactionRequestBody;

/**
 * This class is used to store all the PaymentDetail information Request of
 * initiatePayment api is translated from PaymentDetail object
 */
public class PaymentDetail {

	/**
	 * PaymentDetail parameters
	 */
	/** Required */
	/** Channel through which call initiated [enum (APP, WEB, WAP, SYSTEM)] */
	private EChannelId channelId;
	/** Unique order for each order request */
	private String orderId;
	/** Transaction amount and the currency value */
	private Money txnAmount;
	/** User information contains user details */
	private UserInfo userInfo;

	/** optional */
	/** Paytm Token for a user */
	private String paytmSsoToken;
	/**
	 * list of the payment modes which needs to enable. If the value provided then
	 * only listed payment modes are available for Payment
	 */
	private List<PaymentMode> enablePaymentMode;
	/**
	 * list of the payment modes which need to disable. If the value provided then
	 * all the listed payment modes are unavailable for Payment
	 */
	private List<PaymentMode> disablePaymentMode;
	/** This contain the Goods info for an order. */
	private List<GoodsInfo> goods;
	/** This contain the shipping info for an order. */
	private List<ShippingInfo> shippingInfo;

	/** Promode that user is using for the payment */
	private String promoCode;
	/** This contain the set of parameters for someadditional information */
	private ExtendInfo extendInfo;
	private String emiOption;
	private String cardTokenRequired;

	/** Read TimeOut for Payment Api */
	private Time readTimeout;

	private PaymentDetail(PaymentDetailBuilder paymentDetailBuilder) {
		this(paymentDetailBuilder.channelId, paymentDetailBuilder.orderId, paymentDetailBuilder.txnAmount,
				paymentDetailBuilder.userInfo);
		this.paytmSsoToken = paymentDetailBuilder.paytmSsoToken;
		this.enablePaymentMode = paymentDetailBuilder.enablePaymentMode;
		this.disablePaymentMode = paymentDetailBuilder.disablePaymentMode;
		this.goods = paymentDetailBuilder.goods;
		this.shippingInfo = paymentDetailBuilder.shippingInfo;
		this.extendInfo = paymentDetailBuilder.extendInfo;
		this.promoCode = paymentDetailBuilder.promoCode;
		this.emiOption = paymentDetailBuilder.emiOption;
		this.cardTokenRequired = paymentDetailBuilder.cardTokenRequired;
		this.readTimeout = paymentDetailBuilder.readTimeout;
	}

	private PaymentDetail(EChannelId channelId, String orderId, Money txnAmount, UserInfo userInfo) {
		this.channelId = channelId;
		this.orderId = orderId;
		this.txnAmount = txnAmount;
		this.userInfo = userInfo;
	}

	public EChannelId getChannelId() {
		return channelId;
	}

	public String getPromoCode() {
		return promoCode;
	}

	public ExtendInfo getExtendInfo() {
		return extendInfo;
	}

	public String getEmiOption() {
		return emiOption;
	}

	public String getCardTokenRequired() {
		return cardTokenRequired;
	}

	public String getOrderId() {
		return orderId;
	}

	public Money getTxnAmount() {
		return txnAmount;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public String getPaytmSsoToken() {
		return paytmSsoToken;
	}

	public List<PaymentMode> getEnablePaymentMode() {
		return enablePaymentMode;
	}

	public List<PaymentMode> getDisablePaymentMode() {
		return disablePaymentMode;
	}

	public List<GoodsInfo> getGoods() {
		return goods;
	}

	public List<ShippingInfo> getShippingInfo() {
		return shippingInfo;
	}

	public Time getReadTimeout() {
		return readTimeout;
	}

	/**
	 * PaymentDetailBuilder is used to build the PaymentDetail object
	 */
	public static class PaymentDetailBuilder {
		private EChannelId channelId;
		private String orderId;
		private Money txnAmount;
		private UserInfo userInfo;
		private String paytmSsoToken;
		private List<PaymentMode> enablePaymentMode;
		private List<PaymentMode> disablePaymentMode;
		private List<GoodsInfo> goods;
		private List<ShippingInfo> shippingInfo;

		private String promoCode;
		private ExtendInfo extendInfo;
		private String emiOption;
		private String cardTokenRequired;

		private Time readTimeout = new Time(5, TimeUnit.MINUTES);

		/**
		 * mandatory parameters
		 * 
		 * @param channelId channelId to be set
		 * @param orderId   orderId to be set
		 * @param txnAmount txnAmount to be set
		 * @param userInfo  userInfo to be set
		 */
		public PaymentDetailBuilder(EChannelId channelId, String orderId, Money txnAmount, UserInfo userInfo) {
			this.channelId = channelId;
			this.orderId = orderId;
			this.txnAmount = txnAmount;
			this.userInfo = userInfo;
		}

		/**
		 * builder method
		 * 
		 * @return {@link PaymentDetail}
		 */
		public PaymentDetail build() {
			return new PaymentDetail(this);
		}

		/**
		 * @param orderId orderId to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setOrderId(String orderId) {
			this.orderId = orderId;
			return this;
		}

		/**
		 * @param channelId channelId to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setChannelId(EChannelId channelId) {
			this.channelId = channelId;
			return this;
		}

		/**
		 * @param promoCode promoCode to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setPromoCode(String promoCode) {
			this.promoCode = promoCode;
			return this;
		}

		/**
		 * @param extendInfo extendInfo to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setExtendInfo(ExtendInfo extendInfo) {
			this.extendInfo = extendInfo;
			return this;
		}

		/**
		 * @param emiOption emiOption to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setEmiOption(String emiOption) {
			this.emiOption = emiOption;
			return this;
		}

		/**
		 * @param cardTokenRequired cardTokenRequired to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setCardTokenRequired(String cardTokenRequired) {
			this.cardTokenRequired = cardTokenRequired;
			return this;
		}

		/**
		 * @param txnAmount txnAmount to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setTxnAmount(Money txnAmount) {
			this.txnAmount = txnAmount;
			return this;
		}

		/**
		 * @param userInfo userInfo to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setUserInfo(UserInfo userInfo) {
			this.userInfo = userInfo;
			return this;
		}

		/**
		 * @param paytmSsoToken paytmSsoToken to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setPaytmSsoToken(String paytmSsoToken) {
			this.paytmSsoToken = paytmSsoToken;
			return this;
		}

		/**
		 * @param enablePaymentMode enablePaymentMode to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setEnablePaymentMode(List<PaymentMode> enablePaymentMode) {
			this.enablePaymentMode = enablePaymentMode;
			return this;
		}

		/**
		 * @param disablePaymentMode disablePaymentMode to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setDisablePaymentMode(List<PaymentMode> disablePaymentMode) {
			this.disablePaymentMode = disablePaymentMode;
			return this;
		}

		public PaymentDetailBuilder setGoods(List<GoodsInfo> goods) {
			this.goods = goods;
			return this;
		}

		/**
		 * @param shippingInfo shippingInfo to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setShippingInfo(List<ShippingInfo> shippingInfo) {
			this.shippingInfo = shippingInfo;
			return this;
		}

		/**
		 * @param readTimeout readTimeout to be set
		 * @return PaymentDetailBuilder
		 */
		public PaymentDetailBuilder setReadTimeout(Time readTimeout) {
			this.readTimeout = readTimeout;
			return this;
		}
	}

	public InitiateTransactionRequestBody createInitiateTransactionRequestBody() {
		InitiateTransactionRequestBody body = new InitiateTransactionRequestBody();
		body.setRequestType(LibraryConstants.REQUEST_TYPE_PAYMENT);
		body.setMid(MerchantProperties.getMid());
		body.setOrderId(this.getOrderId());
		body.setWebsiteName(MerchantProperties.getWebsite());
		body.setTxnAmount(this.getTxnAmount());
		body.setUserInfo(this.getUserInfo());
		body.setPaytmSsoToken(this.getPaytmSsoToken());
		body.setEnablePaymentMode(this.getEnablePaymentMode());
		body.setDisablePaymentMode(this.getDisablePaymentMode());
		body.setPromoCode(this.getPromoCode());
		body.setCallbackUrl(MerchantProperties.getCallbackUrl());
		body.setGoods(this.getGoods());
		body.setShippingInfo(this.getShippingInfo());
		body.setExtendInfo(this.getExtendInfo());
		body.setEmiOption(this.getEmiOption());
		body.setCardTokenRequired(this.getCardTokenRequired());
		return body;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(channelId).append(orderId).append(txnAmount).append(userInfo)
				.append(paytmSsoToken).append(enablePaymentMode).append(disablePaymentMode).append(goods)
				.append(shippingInfo).append(promoCode).append(extendInfo).append(emiOption).append(cardTokenRequired)
				.append(readTimeout).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof PaymentDetail)) {
			return false;
		}
		PaymentDetail object = (PaymentDetail) obj;
		return new EqualsBuilder().append(channelId, object.channelId).append(orderId, object.orderId)
				.append(txnAmount, object.txnAmount).append(userInfo, object.userInfo)
				.append(paytmSsoToken, object.paytmSsoToken).append(enablePaymentMode, object.enablePaymentMode)
				.append(disablePaymentMode, object.disablePaymentMode).append(goods, object.goods)
				.append(shippingInfo, object.shippingInfo).append(promoCode, object.promoCode)
				.append(extendInfo, object.extendInfo).append(emiOption, object.emiOption)
				.append(cardTokenRequired, object.cardTokenRequired).append(readTimeout, object.readTimeout).isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
