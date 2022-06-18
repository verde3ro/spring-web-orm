package com.appstracta.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CityRequest implements Serializable {

	private static final long serialVersionUID = -1389389479750667802L;
	@NotNull
	@NotEmpty
	private String city;
	@NotNull
	private Short countryId;

	public CityRequest() {
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Short getCountryId() {
		return countryId;
	}

	public void setCountryId(Short countryId) {
		this.countryId = countryId;
	}

}
