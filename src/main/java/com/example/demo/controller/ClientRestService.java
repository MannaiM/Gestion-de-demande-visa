package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ClientRepository;
import com.example.demo.entities.Client;
import antlr.collections.List;

@RestController
public class ClientRestService {
	@Autowired
	private ClientRepository clientRepository;
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public java.util.List<Client> getClients(){
		return clientRepository.findAll();
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/clients/{id}",method=RequestMethod.GET)
	public Client getClient(@PathVariable Long id){
		Optional<Client> client = clientRepository.findById(id);
		return client.get();
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/client",method=RequestMethod.POST)
	public Client save(@RequestBody Client c) {
       return clientRepository.save(c);
}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/clients/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return true;
}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/clients/{id}",method=RequestMethod.PUT)
	public Client ajouter(@PathVariable Long id, @RequestBody Client c) {
		c.setIdClient(id); 
		return  clientRepository.save(c);
       
}
}