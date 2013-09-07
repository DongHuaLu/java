package com.dolph.service;

import com.dolph.model.Company;
import com.dolph.model.Party;
import com.dolph.vo.PageVo;

public interface PartyService {
	public Company findRootCompany();

	public void saveorUpdateCompany(Company company);

	public void addParty(Party p);
	
	public Party findParty(Class entityClass,int id);

	public void update(Party p);

	public void delete(int id);

	public PageVo findPerson(int parentId, String sSreach);
	

}
