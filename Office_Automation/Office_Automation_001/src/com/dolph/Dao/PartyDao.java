package com.dolph.Dao;

import com.dolph.model.Company;
import com.dolph.vo.PageVo;

public interface PartyDao extends BaseDao{

	public PageVo findAllPartyPaging(String partyName);
	public Company findRootCompany();
	public PageVo findPerson(int parentId, String sSearch);
}
