package com.dolph.service;

import java.util.List;

import com.dolph.model.Group;

public interface GroupService {
	public List<Group> findAllGroup();
	public void add(Group g);

}
