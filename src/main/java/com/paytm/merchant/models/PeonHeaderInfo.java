/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/
 
package com.paytm.merchant.models;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.paytm.pg.constants.LibraryConstants;

public class PeonHeaderInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_HEADER_CONTENT_TYPE)
	public String contentType;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(final String contentType) {
		this.contentType = contentType;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(contentType).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof PeonHeaderInfo)) {
			return false;
		}
		PeonHeaderInfo object = (PeonHeaderInfo) obj;
		return new EqualsBuilder().append(contentType, object.contentType).isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
