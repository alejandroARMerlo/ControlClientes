package com.clientControl;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
 	private UserDetailsService detallesDeUsuarioService;
	
	
	@Bean
	public BCryptPasswordEncoder passwordUsuario() {
		
		BCryptPasswordEncoder contrasenaCodificada= new BCryptPasswordEncoder();
		
		return contrasenaCodificada;		
    }	
	
	//sirve para agregar mas usuarios y personalizar usuarios que vamos a utilizar para hacer login
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(detallesDeUsuarioService).passwordEncoder(passwordUsuario());
	}
	
	
     // metodo que obliga a que cualquier peticion que entra debe estar autenticada
	// restringe las urls segun el rol de cada usuario
	protected void configure(HttpSecurity http) throws Exception{			
		
		http.authorizeRequests()
		         .antMatchers("/")
		         .hasAnyRole("ADMIN", "USER")		         
		         .and()
		           .formLogin()
		           .loginPage("/login")
		         .and()
		            .exceptionHandling().accessDeniedPage("/plantilla/errores");
		         		            
				
	}	
	
	
}
