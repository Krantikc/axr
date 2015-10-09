package com.axr.dao;

import java.util.List;

import com.axr.model.Component;

public interface ComponentDAO {
	public boolean updateComponent(Component component);
	public int createComponent(Component component);
	public List<Component> getComponents();
}
