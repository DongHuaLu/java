package com.dolph.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dolph.Dao.MenuDao;
import com.dolph.model.Menu;
import com.dolph.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService{

	private MenuDao menuDao;
	
	@Override
	public Menu findMenuById(int id) {
		return menuDao.findById(Menu.class, id);
	}

	@Override
	public void update(Menu menu) {
		menuDao.update(menu);
	}

	@Override
	public void addMenu(Menu menu) {
		menuDao.saveMenu(menu);
	}

	@Override
	public void delete(int menuId) {
		menuDao.dalete(findMenuById(menuId));
	}

	@Override
	public List<Menu> findRootMenus() {
		return menuDao.findRootMenus();
	}

	@Resource
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

}
