package com.business;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.dao.VisiteurIDao;
import com.dao.imp.VisiteurDaoImp;
import com.model.Visiteur;


@ManagedBean(name="loginB")
@SessionScoped
public class LoginBean {
	
	private String login;
	private String passWord;

	public String connecter() {
		System.out.println(login+" "+passWord);
		VisiteurIDao vDao = new VisiteurDaoImp();
		Visiteur v = vDao.findByLogin(login);
		if(v!=null  && v.getMotdepasse().equals(passWord)) {
			return "success";
		}
		else if(login.equals("admin") && passWord.equals("admin")) {
			return "admin";
		}
		else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "fail";
		}
	}
	
	public String inscrire() {
		System.out.println("hello");
		return "inscription";
	}
	
	public String actualite() {
		return "actualite";
	}
	
	public String listDonnees() {
		return "donnees";
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void annuler() {
		login = "";
		passWord = "";
	}



	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}

}
