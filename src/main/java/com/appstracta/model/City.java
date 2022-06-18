package com.appstracta.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * The persistent class for the city database table.
 *
 */
@Entity
@Table(name="city")
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="city_id", unique=true, nullable=false)
	private Short cityId;

	@Column(nullable=false, length=50)
	private String city;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	//bi-directional many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id", nullable=false)
	private Country country;

	public City() {
	}

	public City(String city) {
		this.city = city;
	}

	public City(short cityId, String city, Date lastUpdate, short countryId, String country) {
		this.cityId = cityId;
		this.city = city;
		this.lastUpdate = new Timestamp(lastUpdate.getTime());
		this.country = new Country(countryId, country);
	}

	public Short getCityId() {
		return this.cityId;
	}

	public void setCityId(Short cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}