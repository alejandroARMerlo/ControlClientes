package com.clientControl.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rol {

	@Id
	@Column(name = "id_rol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;

	@Column(name = "nombre_rol")
	private String rolName;
	
	
	
	public Rol() {
		super();
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getRolName() {
		return rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", rolName=" + rolName + "]";
	}
	
	// terminar con esta clase: crear los atributos que faltan
	
	
	
	
}
