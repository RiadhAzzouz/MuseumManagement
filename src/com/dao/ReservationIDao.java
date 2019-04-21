package com.dao;

import com.model.Visiteur;

public interface ReservationIDao extends GenericIDao {
	
	public Visiteur findByLogin(String login);

}
