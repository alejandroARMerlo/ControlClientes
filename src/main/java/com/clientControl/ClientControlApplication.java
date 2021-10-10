package com.clientControl;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ClientControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientControlApplication.class, args);
		
		/*String contra= "456";
		
		System.out.println("Contra : " + contra);
		
		System.out.println("ENCRIPTADO: " + crearContra(contra) );*/
		
	}

	public static String crearContra(String password) {
		 
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		    
		return encoder.encode(password);	
		
	}
	
	
	
}
