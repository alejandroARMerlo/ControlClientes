package com.clientControl.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clientControl.Dao.UsuarioDao;
import com.clientControl.domain.UserRols;
import com.clientControl.domain.Usuario;

@Service("userDetailsService")
public class UserServiceImp implements UserService, UserDetailsService {
     
	@Autowired
     UsuarioDao userDao;	
	
	@Override
	public List<Usuario> listUser() {		
		
		return userDao.findAll();
	}
	

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario= userDao.findByUsername(username);
		
		if (usuario==null) {
			
			throw new UsernameNotFoundException(username);
			
		}
		
		var roles= new ArrayList<GrantedAuthority>();
		
		for (UserRols rol : usuario.getUserRols()) {
			
			roles.add(new SimpleGrantedAuthority(rol.getRol().getRolName()));			
		}		
		
		return new User(usuario.getUsername(), usuario.getContra(), roles);
	}

	

}
