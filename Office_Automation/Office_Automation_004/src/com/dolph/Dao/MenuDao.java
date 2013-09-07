package com.dolph.Dao;

import java.util.List;

import com.dolph.model.Menu;

public interface MenuDao extends BaseDao {

	List<Menu> findRootMenus();

	void saveMenu(Menu menu);

	List<Integer> findRootMenuIds();

}
