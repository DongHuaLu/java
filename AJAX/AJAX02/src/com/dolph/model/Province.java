package com.dolph.model;

import java.util.ArrayList;
import java.util.List;

public class Province extends Place {
	List<City> citys=new ArrayList<City>();

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	


}
