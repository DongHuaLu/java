package com.dolph.Dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dolph.Dao.UserDao;
import com.dolph.model.Role;
import com.dolph.model.User;
import com.dolph.model.UserRoles;
import com.dolph.vo.PageVo;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public PageVo findPersonUsers(String sSearch) {
		String hql = "select p.id,p.name,pt.name,u.username from Person p left join p.parent pt left join p.user u where p.name like ?";
		return findPaging(hql, "%" + sSearch + "%");
	}

	@Override
	public void update(User user, int[] roleIds) {
		getSession().update(user);
		String hql = "select ur from UserRoles ur left join ur.user u where u.id=?";
		List<UserRoles> userRoles = getSession().createQuery(hql).setParameter(0, user.getId()).list();
		for (UserRoles ur : userRoles) {
			getSession().delete(ur);
		}

		if (roleIds != null) {
			for (int id : roleIds) {
				UserRoles urs = new UserRoles();
				urs.setUser(user);
				urs.setRole(findById(Role.class, id));
				getSession().save(urs);
			}
		}
	}

	@Override
	public List<Role> findRoleIdsOfUser(int userId) {
		String hql = "select r.id from UserRoles ur join ur.user u join ur.role r where u.id =? ";
		return getSession().createQuery(hql).setParameter(0, userId).list();
	}

	@Override
	public List findPersonWithUsers(String sSearch) {
		String hql="select p.id,p.name from Person p join p.user u where p.name like ?";
		return getSession().createQuery(hql).setParameter(0, "%"+sSearch+"%").list();
	}

}
