package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.Client;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ClientRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Client saveUser(Client appUser) {
        String hashPW=bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(hashPW);
        return userRepository.save(appUser);
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String mail, String rolenom) {
        AppRole role=roleRepository.findByRole(rolenom);
        System.out.println(role.getRole());
        Client appUser =userRepository.findByMail(mail);
        System.out.println(appUser.getMail());
        appUser.getRole().add(role);
    }

    @Override
    public Client findUserBynom(String mail) {
        return userRepository.findByMail(mail);
    }
}
