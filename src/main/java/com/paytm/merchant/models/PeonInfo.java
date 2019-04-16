/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/
 
package com.paytm.merchant.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Map;
import com.paytm.pg.constants.LibraryConstants;

public class PeonInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_DATA_TYPE)
	private String dataType;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_PAYTM_TXN_ID)
	private String paytmTxnId;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_URL_ELEMENT)
	private String peonUrl;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_BODY)
	private PeonBodyInfo data;

	@JsonProperty(LibraryConstants.Peon.JSON_KEY_PEON_HEADER)
	private PeonHeaderInfo header;

	private int requeCount;

	private String peonRequestType;

	private String peonServiceName;

	private Map<String, String> extendInfoMap;

	private Map<String, String> facebookPeonMap;

	private boolean isCustomize;

	private String customBody;

	private boolean isWalletCallback;

	public boolean isCustomize() {
		return isCustomize;
	}

	public void setCustomize(boolean customize) {
		isCustomize = customize;
	}

	public String getCustomBody() {
		return customBody;
	}

	public void setCustomBody(String customBody) {
		this.customBody = customBody;
	}

	public boolean isWalletCallback() {
		return isWalletCallback;
	}

	public void setWalletCallback(boolean walletCallback) {
		isWalletCallback = walletCallback;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(final String dataType) {
		this.dataType = dataType;
	}

	public String getPaytmTxnId() {
		return paytmTxnId;
	}

	public void setPaytmTxnId(final String paytmTxnId) {
		this.paytmTxnId = paytmTxnId;
	}

	public PeonBodyInfo getData() {
		return data;
	}

	public void setData(final PeonBodyInfo data) {
		this.data = data;
	}

	public String getPeonUrl() {
		return peonUrl;
	}

	public void setPeonUrl(final String peonUrl) {
		this.peonUrl = peonUrl;
	}

	public PeonHeaderInfo getHeader() {
		return header;
	}

	public void setHeader(final PeonHeaderInfo header) {
		this.header = header;
	}

	public int getRequeCount() {
		return requeCount;
	}

	public void setRequeCount(final int requeCount) {
		this.requeCount = requeCount;
	}

	public String getPeonRequestType() {
		return peonRequestType;
	}

	public void setPeonRequestType(final String peonRequestType) {
		this.peonRequestType = peonRequestType;
	}

	public String getPeonServiceName() {
		return peonServiceName;
	}

	public void setPeonServiceName(final String peonServiceName) {
		this.peonServiceName = peonServiceName;
	}

	public Map<String, String> getExtendInfoMap() {
		return extendInfoMap;
	}

	public void setExtendInfoMap(final Map<String, String> extendInfoMap) {
		this.extendInfoMap = extendInfoMap;
	}

	public Map<String, String> getFacebookPeonMap() {
		return facebookPeonMap;
	}

	public void setFacebookPeonMap(Map<String, String> facebookPeonMap) {
		this.facebookPeonMap = facebookPeonMap;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(dataType).append(paytmTxnId).append(peonUrl).append(data)
				.append(header).append(requeCount).append(peonRequestType).append(peonServiceName).append(extendInfoMap)
				.append(facebookPeonMap).append(isCustomize).append(customBody).append(isWalletCallback).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof PeonInfo)) {
			return false;
		}
		PeonInfo object = (PeonInfo) obj;
		return new EqualsBuilder().append(dataType, object.dataType).append(paytmTxnId, object.paytmTxnId)
				.append(peonUrl, object.peonUrl).append(data, object.data).append(header, object.header)
				.append(requeCount, object.requeCount).append(peonRequestType, object.peonRequestType)
				.append(peonServiceName, object.peonServiceName).append(extendInfoMap, object.extendInfoMap)
				.append(facebookPeonMap, object.facebookPeonMap).append(isCustomize, object.isCustomize)
				.append(customBody, object.customBody).append(isWalletCallback, object.isWalletCallback).isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
