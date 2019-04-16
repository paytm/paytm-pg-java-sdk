/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/
 
package com.paytm.merchant.models;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Time Class used to define time
 */
public class Time {
	/** value of time */
	long value;
	/** unit of time */
	TimeUnit unit;

	public Time(long value, TimeUnit unit) {
		super();
		this.value = value;
		this.unit = unit;
	}

	public long getValue() {
		return value;
	}

	public TimeUnit getUnit() {
		return unit;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public void setUnit(TimeUnit unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(value).append(unit).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Time)) {
			return false;
		}
		Time object = (Time) obj;
		return new EqualsBuilder().append(value, object.value).append(unit, object.unit).isEquals();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
