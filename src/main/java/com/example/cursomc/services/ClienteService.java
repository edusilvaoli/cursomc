package com.example.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursomc.domain.Cliente;
import com.example.cursomc.exception.ObjectNotFoundException;
import com.example.cursomc.repositories.ClienteRepository;



@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Long id) {
		Optional<Cliente> obj = repo.findById(id); 
		//return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id="+id+", Tipo:"+Cliente.class.getName())); 
	}
}
