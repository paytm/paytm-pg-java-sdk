package com.paytm.merchant.models;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.paytm.pg.constants.MerchantProperties;
import com.paytm.pgplus.request.NativeRefundStatusRequestBody;

public class RefundStatusDetail {
	/**
	 * Payment Status parameters
	 */
	/** required */
	/** Unique order for each order request */
	private String orderId;
	/** Unique ref id for each refund request */
	private String refId;

	/** Optional */
	/** Read TimeOut for Refund Api */
	private Time readTimeout;

	public RefundStatusDetail(RefundStatusDetailBuilder refundStatusDetailBuilder) {
		this(refundStatusDetailBuilder.orderId, refundStatusDetailBuilder.refId);
		this.readTimeout = refundStatusDetailBuilder.readTimeout;
	}

	public RefundStatusDetail(String orderId, String refId) {
		super();
		this.orderId = orderId;
		this.refId = refId;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getRefId() {
		return refId;
	}

	public Time getReadTimeout() {
		return readTimeout;
	}

	/**
	 * PaymentStatusDetailBuilder is used to build the Refund object
	 */
	public static class RefundStatusDetailBuilder {

		private String orderId;
		private String refId;
		private Time readTimeout = new Time(5, TimeUnit.MINUTES);

		public RefundStatusDetailBuilder(String orderId, String refId) {
			super();
			this.orderId = orderId;
			this.refId = refId;
		}

		/**
		 * builder method
		 * 
		 * @return {@link PaymentStatusDetail}
		 */
		public RefundStatusDetail build() {
			return new RefundStatusDetail(this);
		}

		/**
		 * @param readTimeout readTimeout to be set
		 * @return PaymentStatusDetailBuilder
		 */
		public RefundStatusDetailBuilder setReadTimeout(Time readTimeout) {
			this.readTimeout = readTimeout;
			return this;
		}

	}

	public NativeRefundStatusRequestBody createNativeRefundStatusRequestBody() {
		return new NativeRefundStatusRequestBody(MerchantProperties.getMid(), this.getOrderId(), this.getRefId());
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(orderId).append(refId).append(readTimeout).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof RefundStatusDetail)) {
			return false;
		}
		RefundStatusDetail object = (RefundStatusDetail) obj;
		return new EqualsBuilder().append(orderId, object.orderId).append(refId, object.refId)
				.append(readTimeout, object.readTimeout).isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
