package com.dolph.service.impl;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dolph.Dao.PartyDao;
import com.dolph.model.Company;
import com.dolph.model.Party;
import com.dolph.service.PartyService;
import com.dolph.vo.PageVo;

@Service("partyService")
public class PartyServiceImpl implements PartyService{
	private PartyDao partyDao;
	
	
	@Resource
	public void setPartyDao(PartyDao partyDao) {
		this.partyDao = partyDao;
	}


	@Override
	public Company findRootCompany() {
		return partyDao.findRootCompany();
	}


	@Override
	public void saveorUpdateCompany(Company company) {
		partyDao.saveorUpdate(company);
	}


	@Override
	public void addParty(Party p) {
		partyDao.save(p);
		
	}


	@Override
	public Party findParty(Class entityClass,int id) {
		return partyDao.findById(entityClass, id);
	}


	@Override
	public void update(Party p) {
		partyDao.update(p);
	}


	@Override
	public void delete(int id) {
		Party p=partyDao.findById(Party.class, id);
		if(p.getChilds().size()>0){
			throw new RuntimeException("请先删除子节点");
		}
		else{
			partyDao.dalete(p);
		}
	}


	@Override
	public PageVo findPerson(int parentId, String sSearch) {
		try {
			sSearch = new String(sSearch.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		return partyDao.findPerson(parentId,sSearch);
	}
}
