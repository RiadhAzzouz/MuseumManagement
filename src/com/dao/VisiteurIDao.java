package com.dao;

import com.model.Visiteur;

public interface VisiteurIDao extends GenericIDao {
	
	public Visiteur findByEmail(String email);
	public Visiteur findByLogin(String login);
}
