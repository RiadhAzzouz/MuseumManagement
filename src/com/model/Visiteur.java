package com.model;
// default package
// Generated Apr 24, 2018 8:02:01 AM by Hibernate Tools 4.0.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Visiteur generated by hbm2java
 */
@Entity
@Table(name = "VISITEUR")
public class Visiteur implements java.io.Serializable {

	private BigDecimal id;
	private String nom;
	private String prenom;
	private BigDecimal ntel;
	private String login;
	private String motdepasse;
	private String email;

	public Visiteur() {
	}

	public Visiteur(BigDecimal id, String nom, String prenom, BigDecimal ntel, String login, String motdepasse,
			String email) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.ntel = ntel;
		this.login = login;
		this.motdepasse = motdepasse;
		this.email = email;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
	@SequenceGenerator(name="id_sequence", sequenceName="GM_SEQ")
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Column(name = "NOM", nullable = false, length = 20)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "PRENOM", nullable = false, length = 20)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "NTEL", nullable = false, precision = 22, scale = 0)
	public BigDecimal getNtel() {
		return this.ntel;
	}

	public void setNtel(BigDecimal ntel) {
		this.ntel = ntel;
	}

	@Column(name = "LOGIN", nullable = false, length = 20)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "MOTDEPASSE", nullable = false, length = 20)
	public String getMotdepasse() {
		return this.motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	@Column(name = "EMAIL", nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}