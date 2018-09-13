package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity

public class Client implements Serializable {
@Id @GeneratedValue
 private Long idClient;
 private String nom;
 private String prenom;
 private String mail;
 private String password;
 private Double numCarte;
 private String dateExpiration;
 @ManyToMany(fetch = FetchType.EAGER)
 private Collection<AppRole> role=new ArrayList<>();
 public Client() {
	super();
	// TODO Auto-generated constructor stub
}
public Client( String nom, String prenom, String mail, String password, Double numCarte,
		String dateExpiration, Collection<AppRole> role) {
	super();
	
	this.nom = nom;
	this.prenom = prenom;
	this.mail = mail;
	this.password = password;
	this.numCarte = numCarte;
	this.dateExpiration = dateExpiration;
	this.role = role;
}
public Long getIdClient() {
	return idClient;
}
public void setIdClient(Long idClient) {
	this.idClient = idClient;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Double getNumCarte() {
	return numCarte;
}
public void setNumCarte(Double numCarte) {
	this.numCarte = numCarte;
}
public String getDateExpiration() {
	return dateExpiration;
}
public void setDateExpiration(String dateExpiration) {
	this.dateExpiration = dateExpiration;
}
public Collection<AppRole> getRole() {
	return role;
}
public void setRole(Collection<AppRole> role) {
	this.role = role;
}








}
