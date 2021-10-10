package com.clientControl.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_rol")
public class UserRols implements Serializable {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
	@ManyToOne
	private Rol rol;

	@JoinColumn(name = "id_user", referencedColumnName = "id_user")
	@ManyToOne
	private Usuario usuario;

	public UserRols() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Id
	@Column(name = "id_user")
	private int idUser;

	@Id
	@Column(name = "id_rol")
	private int idRol;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	@Override
	public String toString() {
		return "UserRols [rol=" + rol + ", idUser=" + idUser + ", idRol=" + idRol + "]";
	}

	

}
