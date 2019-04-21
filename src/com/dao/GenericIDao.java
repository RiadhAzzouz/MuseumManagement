package com.dao;

import java.io.Serializable;
import java.util.List;



public interface GenericIDao {

	public void saveOrUpdate(Object entity);

	public void delete(Object entity);

	public List findAll(Class clazz);

	public Object findById(Class clazz, Serializable id);
}
