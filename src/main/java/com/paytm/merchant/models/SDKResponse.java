/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/
package com.paytm.merchant.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SDKResponse<T> {

	private T responseObject;
	private String jsonResponse;

	public SDKResponse(T responseObject, String jsonResponse) {
		super();
		this.responseObject = responseObject;
		this.jsonResponse = jsonResponse;
	}

	public T getResponseObject() {
		return responseObject;
	}

	public String getJsonResponse() {
		return jsonResponse;
	}

	public void setResponseObject(T responseObject) {
		this.responseObject = responseObject;
	}

	public void setJsonResponse(String jsonResponse) {
		this.jsonResponse = jsonResponse;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(responseObject).append(jsonResponse).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof SDKResponse)) {
			return false;
		}
		SDKResponse<?> object = (SDKResponse<?>) obj;
		return new EqualsBuilder().append(responseObject, object.responseObject)
				.append(jsonResponse, object.jsonResponse).isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
