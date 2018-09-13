package com.example.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.entities.Details;
@RepositoryRestController
public interface DetailsRepository extends JpaRepository<Details, Long>{
	 @Query("select d from Details  d where d.demandeVisa.idDemandeVisa=:x")
     public  List<Details> findByVisa( @Param("x") Long id);

	 @Modifying(clearAutomatically = true)
	@Transactional
	 @Query("UPDATE Details d SET d.statut=:s WHERE d.idDetail=:y")
	 public void modifierStat(@Param("s") String statut, @Param("y") Long id);
}
