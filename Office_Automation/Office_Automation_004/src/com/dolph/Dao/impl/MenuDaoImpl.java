package com.dolph.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dolph.Dao.MenuDao;
import com.dolph.model.Menu;

@Repository("menuDao")
public class MenuDaoImpl extends BaseDaoImpl implements MenuDao {

	@Override
	public List<Menu> findRootMenus() {
		return getSession().createQuery("select m from Menu m where m.parent is null").list();
	}

	public void saveMenu(Menu menu) {
		if(menu.getParent()==null){
			getSession().save(menu);
			return ;
		}
		if(menu.getParent().getId()==0){
			menu.setParent(null);
		}
		getSession().save(menu);
	}

	@Override
	public List<Integer> findRootMenuIds() {
		return getSession().createQuery("select m.id from Menu m where m.parent is null").list();
	}
}
