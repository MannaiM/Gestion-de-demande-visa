package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DemandeVisaRepository;
import com.example.demo.dao.DetailsRepository;
import com.example.demo.entities.DemandeVisa;
import com.example.demo.entities.Details;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class DetailsRestService {
	@Autowired
	private DetailsRepository detailsRepository;
	@Autowired
	private DemandeVisaRepository demandeVisaRepository;
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
	
	@PostMapping(value = "/addphoto",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String createVente(@RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2, @RequestParam("id") String id) throws IOException {
        
        File convertFile=new File("C:\\Angular\\Visa\\src\\assets\\images\\"+file1.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout=new FileOutputStream(convertFile);
        fout.write(file1.getBytes());
        fout.close();
        File convertFile1=new File("C:\\Angular\\Visa\\src\\assets\\images\\"+file2.getOriginalFilename());
        convertFile1.createNewFile();
        FileOutputStream fout2=new FileOutputStream(convertFile1);
        fout2.write(file2.getBytes());
        fout2.close();
        Details d=new Details();
        d.setPhoto(file1.getOriginalFilename());
        d.setCopiePasseport(file2.getOriginalFilename());
        d.setDemandeVisa(demandeVisaRepository.findByIdDemandeVisa(Long.parseLong(id)));
        d.setStatut("A");
        
        detailsRepository.save(d);
        return "gg";
    }

}
