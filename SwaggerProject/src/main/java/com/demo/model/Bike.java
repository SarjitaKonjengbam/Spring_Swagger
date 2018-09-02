package com.demo.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table
public class Bike implements Serializable
{
	private static final long serialVersionUID = 67738496268547086L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String model;
	private long imei;
	private String license_plate;
	
	public Bike() 
	{ }

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getImei() {
		return imei;
	}

	public void setImei(long imei) {
		this.imei = imei;
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	@Override
	public String toString() {
		return "Bike [id=" + id + ", model=" + model + ", imei=" + imei + ", license_plate=" + license_plate + "]";
	}
	
	

}
