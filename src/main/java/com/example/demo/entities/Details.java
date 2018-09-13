package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@DiscriminatorValue("D")
public class Details implements Serializable{
@Id @GeneratedValue
	private Long idDetail;
	private String photo;
	private String copiePasseport;
	private String statut;
	@ManyToOne
	@JoinColumn( name="idDemandeVisa")
	private DemandeVisa demandeVisa;
	
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Details(Long idDetail, String photo, String copiePasseport, String statut, DemandeVisa demandeVisa) {
		super();
		this.idDetail = idDetail;
		this.photo = photo;
		this.copiePasseport = copiePasseport;
		this.statut = statut;
		this.demandeVisa = demandeVisa;
	}



	public Long getIdDetail() {
		return idDetail;
	}

	public void setIdDetail(Long idDetail) {
		this.idDetail = idDetail;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCopiePasseport() {
		return copiePasseport;
	}

	public void setCopiePasseport(String copiePasseport) {
		this.copiePasseport = copiePasseport;
	}

	public DemandeVisa getDemandeVisa() {
		return demandeVisa;
	}

	public void setDemandeVisa(DemandeVisa demandeVisa) {
		this.demandeVisa = demandeVisa;
	}



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
	}

	
	
}
