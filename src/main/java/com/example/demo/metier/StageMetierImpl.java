package com.example.demo.metier;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.DemandeVisaRepository;
import com.example.demo.entities.Client;
import com.example.demo.entities.DemandeVisa;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StageMetierImpl implements IStageMetier {
	/*@Autowired
private ClientRepository clientRepository;
	@Autowired
	private DemandeVisaRepository demandeVisaRepository;
	@Override
	public Client ConsulterClient(String nom) {
		// TODO Auto-generated method stub
		Client cl= clientRepository.findClientByNom(nom);
		if(cl==null) throw new RuntimeException("client Introuvable"); 
		
		return cl;
	}

	@Override
	public Client AjouterClient( Client c) {
		// TODO Auto-generated method stub
		
		Client cl=clientRepository.save(c);
		return cl;
	}
	@Override
	public void findAll() {
		// TODO Auto-generated method stub
		 clientRepository.findAll();
	}

	@Override
	public void SuppClient(Client c) {
		// TODO Auto-generated method stub
		clientRepository.delete(c);
	}

	@Override
	public Client modifierClient(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public List<DemandeVisa> listDemandeVisas(Long idClient) {
		// TODO Auto-generated method stub
		return demandeVisaRepository.findByClient(idClient);

}*/
}