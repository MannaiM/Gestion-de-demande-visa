package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.DemandeVisaRepository;
import com.example.demo.entities.Client;
import com.example.demo.entities.DemandeVisa;

@RestController
public class DemandeVisaRestService {
	@Autowired
	private DemandeVisaRepository demandeVisaRepository;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/demandevisas",method=RequestMethod.GET)
	public java.util.List<DemandeVisa> getDemandeVisas(){
		return demandeVisaRepository.findAll();
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/visasbyid/{id}",method=RequestMethod.GET)
	public DemandeVisa getVisa(@PathVariable Long id){
		return demandeVisaRepository.findByIdDemandeVisa(id);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/demandevisas",method=RequestMethod.POST)
	public DemandeVisa save(@RequestBody DemandeVisa dv) {
       return demandeVisaRepository.save(dv);
}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/demandevisas/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		demandeVisaRepository.deleteById(id);
        return true;
}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/modifiervisas/{id}",method=RequestMethod.PUT)
	public DemandeVisa ajouter(@PathVariable Long id, @RequestBody DemandeVisa dv) {
		dv.setIdDemandeVisa(id); 
		return  demandeVisaRepository.save(dv);      
}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/demandevisaClient/{id}",method=RequestMethod.GET)
	public java.util.List<DemandeVisa> getDemandeVisasByClient(@PathVariable Long id){
		return demandeVisaRepository.findByIdClient(id);
	}

}
