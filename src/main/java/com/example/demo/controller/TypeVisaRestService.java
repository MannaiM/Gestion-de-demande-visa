package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DetailsRepository;
import com.example.demo.dao.TypeVisaRepository;
import com.example.demo.entities.Client;
import com.example.demo.entities.Details;
import com.example.demo.entities.TypeVisa;

@RestController
public class TypeVisaRestService {
	@Autowired
	private TypeVisaRepository typeVisaRepository;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/types",method=RequestMethod.GET)
	public java.util.List<TypeVisa> getTypes(){
		return typeVisaRepository.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/typevisa/{id}",method=RequestMethod.GET)
	public TypeVisa getTypeVisa(@PathVariable Long id){
		 Optional<TypeVisa> typeVisa = typeVisaRepository.findById(id);
		 return typeVisa.get();
	}
	
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/typevisa",method=RequestMethod.POST)
	public TypeVisa save(@RequestBody TypeVisa tv) {
       return typeVisaRepository.save(tv);
}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/typevisa/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		typeVisaRepository.deleteById(id);
        return true;
}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/typevisa/{id}",method=RequestMethod.PUT)
	public TypeVisa ajouter(@PathVariable Long id, @RequestBody TypeVisa dt) {
		dt.setIdType(id); 
		return  typeVisaRepository.save(dt);
       
}

}
