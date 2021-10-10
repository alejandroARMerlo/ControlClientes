package com.clientControl.service;

import java.util.List;
import java.util.Optional;

import com.clientControl.domain.Cliente;


public interface ClientService {
	
	public List<Cliente> listClient();
	public void addClient(Cliente c);
	void removeClient(Cliente c);
	Optional<Cliente> buscarClientePorId(int id);
	
	
	

}
