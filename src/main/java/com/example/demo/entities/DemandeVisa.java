package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;
@Entity

public class DemandeVisa implements Serializable {
@Id @GeneratedValue
	private Long idDemandeVisa;
	private String requestCountry;
	private String nationalite;
	private String travelDate;
	private String dateDebut;
	private String dateFin;
	private String periode;
	private double prix;
	private String commentaire;
	@ManyToOne
	@JoinColumn( name="idClient") 
	private Client client;
	
	
	@ManyToOne
	@JoinColumn( name="idTypeVisa") 
	private TypeVisa typeVisa;
	public DemandeVisa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandeVisa(Long idDemandeVisa, String requestCountry, String nationalite, String travelDate,
			String dateDebut, String dateFin, String periode, double prix, String commentaire, Client client,
			TypeVisa typeVisa) {
		super();
		this.idDemandeVisa = idDemandeVisa;
		this.requestCountry = requestCountry;
		this.nationalite = nationalite;
		this.travelDate = travelDate;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.periode = periode;
		this.prix = prix;
		this.commentaire = commentaire;
		this.client = client;
		this.typeVisa = typeVisa;
	}


	public Long getIdDemandeVisa() {
		return idDemandeVisa;
	}

	public void setIdDemandeVisa(Long idDemandeVisa) {
		this.idDemandeVisa = idDemandeVisa;
	}

	public String getRequestCountry() {
		return requestCountry;
	}

	public void setRequestCountry(String requestCountry) {
		this.requestCountry = requestCountry;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

	

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}




	public TypeVisa getTypeVisa() {
		return typeVisa;
	}

	public void setTypeVisa(TypeVisa typeVisa) {
		this.typeVisa = typeVisa;
	}
	
	
	
	
}
