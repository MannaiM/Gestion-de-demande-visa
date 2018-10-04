package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ClientRepository;
import com.example.demo.entities.Client;
import com.example.demo.services.AccountService;

import antlr.collections.List;

@RestController
public class ClientRestService {
	@Autowired
    private AccountService accountService;
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
	public String save(@RequestBody Client c) {
        //clientRepository.save(c);
		accountService.saveUser(c);
		System.out.println(c);
        return "true";
}
	@CrossOrigin(origins = "*")
	@PostMapping(value="/role1",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public String rolesave(@RequestParam("role") String role,@RequestParam("mail") String mail) {
        //clientRepository.save(c);
		//accountService.saveUser(c);
		
		//if(s.equals(admin))
		System.out.println(role);
		System.out.println(mail);
		if(role.equals('A')) {
			accountService.addRoleToUser(mail,"ROLE_ADMIN");
		}else {
			accountService.addRoleToUser(mail,"ROLE_USER");
		}
		//accountService.addRoleToUser(mail,"ROLE_ADMIN");
		System.out.println("************************************");
		
        return "gg";
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
	@CrossOrigin(origins = "*")
	@GetMapping(value="/clientid/{nom}")
	public Client getid(@PathVariable String nom) {
		System.out.println(nom);
		Client c=clientRepository.findClientByNom(nom);
		
		return c;
	}
}