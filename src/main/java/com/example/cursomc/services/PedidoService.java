package com.example.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cursomc.domain.Pedido;
import com.example.cursomc.exception.ObjectNotFoundException;
import com.example.cursomc.repositories.PedidoRepository;



@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Long id) {
		Optional<Pedido> obj = repo.findById(id);
		//return obj.orElse(null);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id="+id+", Tipo:"+Pedido.class.getName())); 
	}
}
