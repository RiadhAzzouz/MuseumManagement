package com.business;

import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import com.dao.PersonnelIDao;
import com.dao.imp.PersonnelDaoImp;
import com.model.Personnel;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;


@ManagedBean(name="personnelB")
@SessionScoped
public class PersonnelBean {

	private Personnel pers = new Personnel();
	private PersonnelIDao persDao = new PersonnelDaoImp();
	
	
	private List<Personnel> listPersonnel = new ArrayList();

	public PersonnelIDao getPersDao() {
		return persDao;
	}

	public void setPersDao(PersonnelIDao persDao) {
		this.persDao = persDao;
	}

	public List<Personnel> getListPersonnel() {
		listPersonnel = persDao.findAll(Personnel.class);
		return listPersonnel;
	}

	public void setListPersonnel(List<Personnel> listPersonnel) {
		this.listPersonnel = listPersonnel;
	}

	public Personnel getPers() {
		return pers;
	}

	public void setPers(Personnel pers) {
		this.pers = pers;
	}
	
	public void ajouter() {
		System.out.println("gege");
		persDao.saveOrUpdate(pers);
		pers = new Personnel();
	}
	
	
	
}
