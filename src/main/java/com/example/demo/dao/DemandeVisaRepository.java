package com.example.demo.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import com.example.demo.entities.Client;
import com.example.demo.entities.DemandeVisa;
@RepositoryRestController
public interface DemandeVisaRepository 
extends JpaRepository<DemandeVisa, Long>{

	//public DemandeVisa findByIdDemandeVisa(Long id);
	//@Query("select d from dmandeVisa d where d.client.idClient=:x")
	//public Page<DemandeVisa> listDemandeVisas( @Param("x") Long idClient,Pageable page,int size);
	
//	public List<DemandeVisa> findByClient(Long id);

       @Query("select d from DemandeVisa  d where d.client.idClient=:x")
       public  List<DemandeVisa> findByIdClient( @Param("x") Long id);
       
       @Query("select d from DemandeVisa  d where d.idDemandeVisa=:x")
	   public DemandeVisa findByIdDemandeVisa( @Param("x") Long id);

      /* @Query("select d from demande_visa  d where d.id_type_visa=:x")
       public  List<DemandeVisa> findByType(Long id);*/

}
