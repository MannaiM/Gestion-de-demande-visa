package com.example.demo.controller;

import com.example.demo.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Client;
import com.example.demo.metier.IStageMetier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StageController {//Client

/*
	@Autowired
	private IStageMetier stageMetier;

	@GetMapping	("/clientss")
	public String index() {
		return "clients";
	}
	
	@RequestMapping("/ajouterClient")
	public Client AddClient(Model model,Client c) {
		try {
	Client cl= stageMetier.AjouterClient(c);
	model.addAttribute("client",cl);
	return cl;
	
	}catch (Exception e)
		{model.addAttribute("exception",e) ;	
		return null;
	}

}
	@RequestMapping("/consulterClient")
	public String consulter(Model model,String idClient) {
		model.addAttribute("idClient",idClient);
		try { Client cl = stageMetier.ConsulterClient(idClient);
		model.addAttribute("client", cl);
		} catch (Exception e) {
			model.addAttribute("exception" ,e);
			
		}
		return "clients";
		
		}*/
	}
