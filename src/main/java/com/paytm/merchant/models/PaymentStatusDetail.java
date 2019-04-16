/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/
 
package com.paytm.merchant.models;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.paytm.pg.constants.MerchantProperties;
import com.paytm.pgplus.request.NativePaymentStatusRequestBody;

public class PaymentStatusDetail {
	/**
	 * Payment Status parameters
	 */
	/** required */
	/** Unique order for each order request */
	private String orderId;

	/** Optional */
	/** Read TimeOut for Refund Api */
	private Time readTimeout;

	public PaymentStatusDetail(PaymentStatusDetailBuilder paymentStatusDetailBuilder) {
		this(paymentStatusDetailBuilder.orderId);
		this.readTimeout = paymentStatusDetailBuilder.readTimeout;
	}

	public PaymentStatusDetail(String orderId) {
		super();
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public Time getReadTimeout() {
		return readTimeout;
	}

	/**
	 * PaymentStatusDetailBuilder is used to build the Refund object
	 */
	public static class PaymentStatusDetailBuilder {

		private String orderId;
		private Time readTimeout = new Time(5, TimeUnit.MINUTES);

		public PaymentStatusDetailBuilder(String orderId) {
			super();
			this.orderId = orderId;
		}

		/**
		 * builder method
		 * 
		 * @return {@link PaymentStatusDetail}
		 */
		public PaymentStatusDetail build() {
			return new PaymentStatusDetail(this);
		}

		/**
		 * @param readTimeout readTimeout to be set
		 * @return PaymentStatusDetailBuilder
		 */
		public PaymentStatusDetailBuilder setReadTimeout(Time readTimeout) {
			this.readTimeout = readTimeout;
			return this;
		}

	}

	public NativePaymentStatusRequestBody createInitiateTransactionRequestBody() {
		NativePaymentStatusRequestBody nativePaymentStatusRequestBody = new NativePaymentStatusRequestBody();
		nativePaymentStatusRequestBody.setMid(MerchantProperties.getMid());
		nativePaymentStatusRequestBody.setOrderId(this.getOrderId());
		return nativePaymentStatusRequestBody;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(orderId).append(readTimeout).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof PaymentStatusDetail)) {
			return false;
		}
		PaymentStatusDetail object = (PaymentStatusDetail) obj;
		return new EqualsBuilder().append(orderId, object.orderId).append(readTimeout, object.readTimeout).isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
