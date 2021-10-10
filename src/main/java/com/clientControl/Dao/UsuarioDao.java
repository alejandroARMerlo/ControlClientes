package com.clientControl.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientControl.domain.Usuario;



@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer>{

	  Usuario findByUsername(String username);
	
	
}
