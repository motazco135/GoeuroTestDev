package com.goeuro.testdev.dto;

import java.io.Serializable;

public class CityLocationDTO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5567518222560368273L;
	
	private float latitude ; 
	private float longitude ;
	
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "CityLocationDTO [latitude=" + latitude + ", longitude="
				+ longitude + "]";
	} 
	
	
	

}
