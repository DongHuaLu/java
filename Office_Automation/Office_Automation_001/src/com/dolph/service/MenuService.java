package com.dolph.service;

import java.util.List;

import com.dolph.model.Menu;

public interface MenuService {

	Menu findMenuById(int id);

	void update(Menu menu);

	void addMenu(Menu menu);

	void delete(int menuId);

	List<Menu> findRootMenus();

}
