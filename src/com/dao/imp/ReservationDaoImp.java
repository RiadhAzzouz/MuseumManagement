package com.dao.imp;
// Generated Mar 29, 2018 2:13:43 PM by Hibernate Tools 4.0.1.Final

import org.hibernate.HibernateException;

import com.dao.ReservationIDao;
import com.model.Visiteur;

/**
 * Home object for domain model class Reservation.
 * @see com.model.Reservation
 * @author Hibernate Tools
 */
public class ReservationDaoImp extends GenericDaoImp implements ReservationIDao {
	
	public Visiteur findByLogin(String login) {
		Visiteur visiteur = null;
		try {
			startOperation();
			visiteur = (Visiteur)
					hibernateSession.createQuery("select lb from visiteur lb where lb.login = :login")
				           .setString("login", login)
				           .uniqueResult();
			
		} catch (HibernateException e) {
			handleException(e);
		} finally {
			hibernateSession.close();
		}
		
		return visiteur;
	}
	
	
}
