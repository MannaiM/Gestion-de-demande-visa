package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.TypeVisa;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface TypeVisaRepository extends JpaRepository<TypeVisa, Long>{
	
	


}
 