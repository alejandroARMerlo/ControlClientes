package com.clientControl.domain;

import java.util.List; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser; 
	
	@Column(name = "contrasena")
	private String contra;
	
	@Column(name = "user_name")
	private String username;
	
	
	@OneToMany(mappedBy = "usuario")
	private List<UserRols> userRols;
	

	public Usuario() {
		super();
		
	}
	

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	

	public List<UserRols> getUserRols() {
		return userRols;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setUserRols(List<UserRols> userRols) {
		this.userRols = userRols;
	}


	@Override
	public String toString() {
		return "Usuario [idUser=" + idUser + ", contra=" + contra + ", username=" + username + ", userRols=" + userRols
				+ "]";
	}

	
	

}
