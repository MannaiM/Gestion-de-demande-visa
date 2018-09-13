package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DetailsRepository;
import com.example.demo.entities.DemandeVisa;
import com.example.demo.entities.Details;
@RestController
public class DetailsRestService {
	@Autowired
	private DetailsRepository detailsRepository;
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/details",method=RequestMethod.GET)
	public java.util.List<Details> getDetails(){
		return detailsRepository.findAll();
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/finddetailvisa/{id}",method=RequestMethod.GET)
	public List<Details> getDetailsByVisa(@PathVariable Long id){
		return detailsRepository.findByVisa(id);
	}

	/*@RequestMapping(value="/details/{id}",method=RequestMethod.GET)
	public Details getDetail(@PathVariable Long id){
		return detailsRepository.findById(id);
	}*/
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/details",method=RequestMethod.POST)
	public Details save(@RequestBody Details dt) {
       return detailsRepository.save(dt);
}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/details/{id}",method=RequestMethod.DELETE)
	public boolean supprimer(@PathVariable Long id) {
		detailsRepository.deleteById(id);
        return true;
}
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/details/{id}",method=RequestMethod.PUT)
	public Details ajouter(@PathVariable Long id, @RequestBody Details dt) {
		dt.setIdDetail(id); 
		return  detailsRepository.save(dt);
       
}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/modifierStat/{id}/{stat}",method=RequestMethod.PUT)
	public void modifierSta(@PathVariable String stat, @PathVariable Long id){
		 detailsRepository.modifierStat(stat,id);
	}

}
