 package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.entities.AppRole;
import com.example.demo.entities.Client;
import com.example.demo.services.AccountService;




@SpringBootApplication

public class MonStageApplication implements CommandLineRunner{
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private ClientRepository userRepository;

	@Autowired
    private AccountService accountService;
	
	public static void main(String[] args) {
		 SpringApplication.run(MonStageApplication.class, args);
		 
	}
	@Bean
	public BCryptPasswordEncoder getpasswordEncoder() {
		return new BCryptPasswordEncoder();
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	/*	Client c1=clientRepository.save(new Client(2,"manai","maha","maa@gmail.com"));
		Client c2=clientRepository.save(new Client(1,"manai1","maha1","ma111a@gmail.com"));

		DemandeVisa dv1=	demandeVisaRepository.save(new DemandeVisa(1,"france","accepte",200,c1));
		 Details d1=detailsRepository.save(new Details(1,"mul.jpg","pas1",dv1));*/
		/*accountService.saveRole(new AppRole("ROLE_ADMIN"));
		accountService.saveRole(new AppRole("ROLE_USER"));*/
		/*accountService.saveUser(new Client("admin","admin","admin@gmail.com","1234",(double) 12,"12/12/12",null));
		accountService.saveUser(new Client("maha","mannai","maha@gmail.com","1234",(double) 12,"12/12/12",null));
		accountService.saveUser(new Client("user","user","user@gmail.com","1234",(double) 12,"12/12/12",null));
	    accountService.addRoleToUser("admin@gmail.com","ROLE_ADMIN");
        accountService.addRoleToUser("admin@gmail.com","ROLE_USER");
        accountService.addRoleToUser("user@gmail.com","ROLE_USER");
        accountService.addRoleToUser("maha@gmail.com","ROLE_USER");*/
	}
	
}
