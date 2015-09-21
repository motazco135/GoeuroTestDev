package com.goeuro.testdev.dto;

import java.io.Serializable;

public class CityDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6708150513552841677L;
	
	private  Long  _id  ; 
	private  String  key  ; 
	private String  name; 
	private String fullName ; 
	private String iata_airport_code ; 
	private String type; 
	private String country ; 
	private Long location_id; 
	private boolean inEurope ; 
	private String countryCode ; 
	private String coreCountry ; 
	private String distance ;
	private CityLocationDTO geo_position  ; 
	
	public void setGeo_position(CityLocationDTO geo_position) {
		this.geo_position = geo_position;
	}
	
	public CityLocationDTO getGeo_position() {
		return geo_position;
	}
	
	
	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getIata_airport_code() {
		return iata_airport_code;
	}
	public void setIata_airport_code(String iata_airport_code) {
		this.iata_airport_code = iata_airport_code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Long location_id) {
		this.location_id = location_id;
	}
	public boolean isInEurope() {
		return inEurope;
	}
	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCoreCountry() {
		return coreCountry;
	}
	public void setCoreCountry(String coreCountry) {
		this.coreCountry = coreCountry;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "CityDTO [_id=" + _id + ", key=" + key + ", name=" + name + ", fullName="
				+ fullName + ", iata_airport_code=" + iata_airport_code
				+ ", type=" + type + ", country=" + country + ", location_id="
				+ location_id + ", inEurope=" + inEurope + ", countryCode="
				+ countryCode + ", coreCountry=" + coreCountry + ", distance="
				+ distance + ", geo_position=" + geo_position + "]";
	}

	
	
}
