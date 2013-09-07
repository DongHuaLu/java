package com.dolph.Dao.impl;

import org.springframework.stereotype.Repository;

import com.dolph.Dao.PartyDao;
import com.dolph.model.Company;
import com.dolph.vo.PageVo;
@Repository("partyDao")
public class PartyDaoImpl extends BaseDaoImpl implements PartyDao{

	@Override
	public PageVo findAllPartyPaging(String partyName) {
		String hql="select p from Party p where p.name=?";
		return findPaging(hql,"%"+partyName+"%");
	
	}

	@Override
	public Company findRootCompany() {
		getSession().enableFilter("no_contain_person");
		return (Company) getSession().createQuery("select c from Company c where c.parent is null").uniqueResult();
		 
	}

	@Override
	public PageVo findPerson(int parentId, String sSearch) {
		String hql="select  p.id,p.name,p.sex,p.tel,p.qq,p.snubmer,p.address,p.email,p.phone from Person p where p.parent.id="+parentId;
		if(parentId==0){
			hql="select p.id,p.name,p.sex,p.tel,p.qq,p.snubmer,p.address,p.email,p.phone from Person p where 1=1";
		}
		System.out.println(sSearch);
		if(sSearch!=null && !"".equals(sSearch)){
			hql +="and (p.name like '%"+sSearch+"%' or p.sex like '%"+sSearch+"%' or p.tel like '%"+sSearch+"%')";
		}
		return findPaging(hql);
	}



}
