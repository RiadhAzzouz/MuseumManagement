package com.dao.imp;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.DataAccessLayerException;
import com.dao.GenericIDao;
import com.util.HibernateUtil;

public class GenericDaoImp implements GenericIDao {

	protected Session hibernateSession;
	protected Transaction tx;
	
	public GenericDaoImp() {
		hibernateSession = HibernateUtil.currentSession();
	}

	@Override
	public void saveOrUpdate(Object entity) {
		try {
			startOperation();
			hibernateSession.saveOrUpdate(entity);
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}

	}

	@Override
	public void delete(Object entity) {
		try {
			startOperation();
			hibernateSession.delete(entity);
			tx.commit();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}

	}

	@Override
	public List findAll(Class clazz) {
		List objects = null;
		try {
			startOperation();
			Query query = hibernateSession.createQuery("from "
					+ clazz.getName());
			objects = query.list();
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		return objects;
	}

	@Override
	public Object findById(Class clazz, Serializable id) {
		Object obj = null;
		try {
			startOperation();
			obj = hibernateSession.get(clazz, id);
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		return obj;
	}

	protected void startOperation() throws HibernateException {
		hibernateSession = HibernateUtil.currentSession();
		tx = hibernateSession.beginTransaction();
	}

	protected void handleException(HibernateException e)
			throws DataAccessLayerException {

		tx.rollback();
		throw new DataAccessLayerException(e);

	}
	
	
}
