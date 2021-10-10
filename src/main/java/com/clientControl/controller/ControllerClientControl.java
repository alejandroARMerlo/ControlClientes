package com.clientControl.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clientControl.domain.Cliente;
import com.clientControl.service.ClientService;
import com.clientControl.service.UserService;

@Controller
public class ControllerClientControl {
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	UserService userService;	
	 
/*	@GetMapping("/")
	public String initClientControl(Model model,  @AuthenticationPrincipal User user --> SIRVE PARA OBTENER EL NOMBRE DE USUARIO Y EL ROL  ) {
		
		   var clients=clientService.listClient();
		
		  
		
		model.addAttribute("allClients", clientService.listClient());
		
		model.addAttribute("sumSaldo",  sumaSaldos(clients));
		
		model.addAttribute("cantCli",  clients.size());
		
		model.addAttribute("userName", user.getUsername());  // PASAMOS EL NOMBRE DE USAURIO
		
		model.addAttribute("client", new Cliente()); 
		
		
		
		
		return "clientControl";
	} */	
	
	@GetMapping("/")
	public String initClientControl(Model model) {
		
		   var clients=clientService.listClient();		  
		
		model.addAttribute("allClients", clientService.listClient());
		
		model.addAttribute("sumSaldo",  sumaSaldos(clients));
		
		model.addAttribute("cantCli",  clients.size());		
		
		model.addAttribute("client", new Cliente());		
		
		return "index";
	}

	private float sumaSaldos(List<Cliente> clients) {
		
		var suma=0;
		
		   for (Cliente cliente : clients) {
			
			       suma+= cliente.getSaldo();
			   
		   }
		
		   return suma;		   
	}

	@PostMapping("/addClient")
	public String agregarCliente(Cliente clie) {
		
		clientService.addClient(clie);		
		
		return "redirect: ";		
	}
	
	@GetMapping("/deleteClient")
	public String eliminarCliente(Cliente clie) {
		
		clientService.removeClient(clie);		
		
		return "redirect: ";	
	}
	
	@GetMapping("/editarCliente")
	 public String editarCli( @RequestParam(name = "idCli") int id, Model model ) {
		  
		     Optional<Cliente> c = clientService.buscarClientePorId(id);
		     		    	     
		     model.addAttribute("client", c.get());
		  
		     return "layout/modificarCliente";
	}
	
	

	
}
