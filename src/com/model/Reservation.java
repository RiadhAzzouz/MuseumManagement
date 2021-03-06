package com.model;
// default package
// Generated Apr 24, 2018 7:33:10 AM by Hibernate Tools 4.0.1.Final


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Reservation generated by hbm2java
 */
@Entity
@Table(name = "RESERVATION")
public class Reservation implements java.io.Serializable {

	private long numres;
	private String loginvisiteur;
	private String dateres;
	private String heure;
	private long nbrpersonnes;

	public Reservation() {
	}

	public Reservation(long numres, String loginvisiteur, String dateres, long nbrpersonnes) {
		this.numres = numres;
		this.loginvisiteur = loginvisiteur;
		this.dateres = dateres;
		this.nbrpersonnes = nbrpersonnes;
	}

	public Reservation(long numres, String loginvisiteur, String dateres, String heure, long nbrpersonnes) {
		this.numres = numres;
		this.loginvisiteur = loginvisiteur;
		this.dateres = dateres;
		this.heure = heure;
		this.nbrpersonnes = nbrpersonnes;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
	@SequenceGenerator(name="id_sequence", sequenceName="GM_SEQ")
	@Column(name = "NUMRES", unique = true, nullable = false, precision = 22, scale = 0)
	public long getNumres() {
		return this.numres;
	}

	public void setNumres(long numres) {
		this.numres = numres;
	}

	@Column(name = "LOGINVISITEUR", nullable = false, length = 20)
	public String getLoginvisiteur() {
		return this.loginvisiteur;
	}

	public void setLoginvisiteur(String loginvisiteur) {
		this.loginvisiteur = loginvisiteur;
	}

	@Column(name = "DATERES", nullable = false, length = 20)
	public String getDateres() {
		return this.dateres;
	}

	public void setDateres(String dateres) {
		this.dateres = dateres;
	}

	@Column(name = "HEURE", length = 20)
	public String getHeure() {
		return this.heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	@Column(name = "NBRPERSONNES", nullable = false, precision = 22, scale = 0)
	public long getNbrpersonnes() {
		return this.nbrpersonnes;
	}

	public void setNbrpersonnes(long nbrpersonnes) {
		this.nbrpersonnes = nbrpersonnes;
	}

}
