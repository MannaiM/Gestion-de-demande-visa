package com.example.demo.services;

import com.example.demo.entities.AppRole;
import com.example.demo.entities.Client;

public interface AccountService {
    public Client saveUser(Client appUser);
    public AppRole saveRole(AppRole role);
    public void addRoleToUser(String usernom, String rolenom);
    public Client findUserBynom(String nom);
}
