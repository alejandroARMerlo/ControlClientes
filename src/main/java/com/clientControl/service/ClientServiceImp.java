package com.clientControl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clientControl.Dao.ClientDAO;
import com.clientControl.domain.Cliente;

@Service
public class ClientServiceImp implements ClientService {
     
	@Autowired
     ClientDAO clientDao;
	
	
	@Override
	public List<Cliente> listClient() {		
		
		return clientDao.findAll();
	}


	@Override
	public void addClient(Cliente c) {
		
		  clientDao.save(c);		
	}
	
	@Override
	public void removeClient(Cliente c) {
		
		  clientDao.delete(c);		
	}
	

	@Override
	public Optional<Cliente> buscarClientePorId(int id) {
		
		  return clientDao.findById(id);
		
	}

}
