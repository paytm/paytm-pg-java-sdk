/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/
 
package com.paytm.merchant.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.paytm.pg.constants.LibraryConstants;

import java.io.Serializable;
import java.util.Map;

public class RefundSuccessPeonInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_DATA_TYPE)
	private String dataType;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY)
	private RefundSuccessPeonBodyInfo data;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_HEADER)
	private PeonHeaderInfo header;

	private String peonUrl;
	private String mid;
	private int requeCount;

	private Map<String, String> extendInfoMap;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(final String dataType) {
		this.dataType = dataType;
	}

	public RefundSuccessPeonBodyInfo getData() {
		return data;
	}

	public void setData(final RefundSuccessPeonBodyInfo data) {
		this.data = data;
	}

	public PeonHeaderInfo getHeader() {
		return header;
	}

	public void setHeader(final PeonHeaderInfo header) {
		this.header = header;
	}

	public String getPeonUrl() {
		return peonUrl;
	}

	public void setPeonUrl(final String peonUrl) {
		this.peonUrl = peonUrl;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(final String mid) {
		this.mid = mid;
	}

	public int getRequeCount() {
		return requeCount;
	}

	public void setRequeCount(final int requeCount) {
		this.requeCount = requeCount;
	}

	public Map<String, String> getExtendInfoMap() {
		return extendInfoMap;
	}

	public void setExtendInfoMap(final Map<String, String> extendInfoMap) {
		this.extendInfoMap = extendInfoMap;
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder(17, 37).append(dataType).append(data).append(header).append(peonUrl).append(mid)
				.append(requeCount).append(extendInfoMap).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof RefundSuccessPeonInfo)) {
			return false;
		}
		RefundSuccessPeonInfo object = (RefundSuccessPeonInfo) obj;
		return new EqualsBuilder().append(dataType, object.dataType).append(data, object.data)
				.append(header, object.header).append(peonUrl, object.peonUrl).append(mid, object.mid)
				.append(requeCount, object.requeCount).append(extendInfoMap, object.extendInfoMap).isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
