package com.lgj.entity;

import javax.persistence.*;

@Table(name = "country")
public class Country {
	
    private String countryname;

    private String countrycode;

	public Country(String countryname, String countrycode) {
		super();
		this.countryname = countryname;
		this.countrycode = countrycode;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
    

}