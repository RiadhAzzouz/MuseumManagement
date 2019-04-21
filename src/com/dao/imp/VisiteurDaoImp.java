package com.dao.imp;
// Generated Mar 29, 2018 2:13:43 PM by Hibernate Tools 4.0.1.Final

import org.hibernate.HibernateException;

import com.dao.VisiteurIDao;
import com.model.Visiteur;

/**
 * Home object for domain model class Visiteur.
 * @see com.model.Visiteur
 * @author Hibernate Tools
 */
public class VisiteurDaoImp extends GenericDaoImp implements VisiteurIDao {

	public Visiteur findByEmail(String email) {
		Visiteur user = null;
		try {
			startOperation();
			user = (Visiteur)
					hibernateSession.createQuery("select lb from Visiteur lb where lb.email = :email")
				           .setString("email", email)
				           .uniqueResult();
			
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		
		return user;
	}
	
	
	public Visiteur findByLogin(String login) {
		Visiteur user = null;
		try {
			startOperation();
			user = (Visiteur)
					hibernateSession.createQuery("select lb from Visiteur lb where lb.login = :login")
				           .setString("login", login)
				           .uniqueResult();
			
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		
		return user;
	}
	
}
