package com.dolph.model;

import java.util.ArrayList;
import java.util.List;

public class City extends Place {
	List<Country> countrys=new ArrayList<Country>();

	public List<Country> getCountrys() {
		return countrys;
	}

	public void setCountrys(List<Country> countrys) {
		this.countrys = countrys;
	}

}
