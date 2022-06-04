package com.appstracta.response;

import java.io.Serializable;
import java.util.Date;

public class CityResponse implements Serializable {

	private static final long serialVersionUID = 436543394457725988L;
	private short cityId;
	private String city;
	private Date lastUpdate;
	private short countryId;
	private String country;

	public CityResponse() {
	}

	public CityResponse(short cityId, String city, Date lastUpdate, short countryId, String country) {
		this.cityId = cityId;
		this.city = city;
		this.lastUpdate = lastUpdate;
		this.countryId = countryId;
		this.country = country;
	}

	public short getCityId() {
		return cityId;
	}

	public void setCityId(short cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public short getCountryId() {
		return countryId;
	}

	public void setCountryId(short countryId) {
		this.countryId = countryId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
