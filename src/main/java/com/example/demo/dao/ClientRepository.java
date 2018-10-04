package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Client;

import java.util.List;

@RepositoryRestController
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findClientByNom(String nom);
    public Long findIdByNom(String nom);
    public Client  findByMail(String mail);

}
