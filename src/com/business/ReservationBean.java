package com.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dao.ReservationIDao;
import com.dao.VisiteurIDao;
import com.dao.imp.ReservationDaoImp;
import com.dao.imp.VisiteurDaoImp;
import com.model.Reservation;
import com.model.Visiteur;


@ManagedBean(name="reservationB")
@SessionScoped
public class ReservationBean {
	
	private Reservation res = new Reservation();
	private ReservationIDao resDao = new ReservationDaoImp();
	
	private List<Reservation> listReservation = new ArrayList();
	
	
	

	public Reservation getRes() {
		return res;
	}

	public void setRes(Reservation res) {
		this.res = res;
	}

	public ReservationIDao getResDao() {
		return resDao;
	}

	public void setResDao(ReservationIDao resDao) {
		this.resDao = resDao;
	}

	public List<Reservation> getListReservation() {
		listReservation= resDao.findAll(Reservation.class);
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}
	
	public void ajouter() {
		
		Visiteur v = null;
		VisiteurIDao vDao = new VisiteurDaoImp();
		v = vDao.findByLogin(res.getLoginvisiteur());
		if(v != null) {
			resDao.saveOrUpdate(res);
			res = new Reservation();
			FacesMessage msg = new FacesMessage("Succes Reservation");
		    FacesContext.getCurrentInstance().addMessage(null, msg);
		}	
		
		else {
			FacesMessage msg1 = new FacesMessage("Vous devez créer un compte");
	        FacesContext.getCurrentInstance().addMessage(null, msg1);
		}
		
	}

}
