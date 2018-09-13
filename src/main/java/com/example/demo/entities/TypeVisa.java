package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity

public class TypeVisa implements Serializable {
	@Id @GeneratedValue
	private Long idType;
	
	private String libelle;
	
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	public TypeVisa(Long idType, String libelle) {
		super();
		this.idType = idType;
		this.libelle = libelle;
	}
	public TypeVisa() {
		super();
	}
	

}
