package com.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dao.VisiteurIDao;
import com.dao.imp.VisiteurDaoImp;
import com.model.Visiteur;

@ManagedBean(name="visiteurB")
@SessionScoped
public class VisiteurBean {
	
	private Visiteur vs = new Visiteur();
	private String confirm;
	
	private VisiteurIDao visDao = new VisiteurDaoImp();
	
	private List<Visiteur> listVisiteur = new ArrayList();
	
	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
		
	public VisiteurIDao getVisDao() {
		return visDao;
	}

	public void setVisDao(VisiteurIDao visDao) {
		this.visDao = visDao;
	}

	public List<Visiteur> getListVisiteur() {
		listVisiteur= visDao.findAll(Visiteur.class);
		return listVisiteur;
	}

	public void setListVisiteur(List<Visiteur> listVisiteur) {
		this.listVisiteur = listVisiteur;
	}

	public Visiteur getVs() {
		return vs;
	}

	public void setVs(Visiteur vs) {
		this.vs = vs;
	} 
	
	public void ajouter() {
		if(!vs.getMotdepasse().equals(confirm) ) {
			FacesMessage msg = new FacesMessage("Vérifier le mot de passe");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		else if(visDao.findByEmail(vs.getEmail()) != null) {
			System.out.println("hello2");
			FacesMessage msg1 = new FacesMessage("L'email est dejà utilisé");
	        FacesContext.getCurrentInstance().addMessage(null, msg1);
		}
		else if(visDao.findByLogin(vs.getLogin()) != null) {
			System.out.println("hello2");
			FacesMessage msg2 = new FacesMessage("Le login est dejà utilisé");
	        FacesContext.getCurrentInstance().addMessage(null, msg2);
		}
		else {
			visDao.saveOrUpdate(vs);
			vs = new Visiteur();
			FacesMessage msg3 = new FacesMessage("Succes de l'inscription");
	        FacesContext.getCurrentInstance().addMessage(null, msg3);
		}
	}
	
}
