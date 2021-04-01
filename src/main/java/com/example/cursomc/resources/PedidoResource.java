package com.example.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursomc.domain.Pedido;
import com.example.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service; 
	
/*	@RequestMapping(method=RequestMethod.GET)
	public List<Pedido> listar() {
		
		var cat1 = new Pedido(1L,"Informática");
		var cat2 = new Pedido(2L,"Escritório"); 
		
		List<Pedido> lista = Arrays.asList(cat1,cat2); 
		
		return lista; 
	}*/
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		/*
		 * var cat1 = new Pedido(1L,"Informática"); var cat2 = new
		 * Pedido(2L,"Escritório");
		 */
		Pedido obj = service.buscar(id); 
		return ResponseEntity.ok(obj); 
	}
}
