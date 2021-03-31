package com.example.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursomc.domain.Cliente;
import com.example.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service; 
	
	/*
	 * @RequestMapping(method=RequestMethod.GET) public List<Cliente> listar() {
	 * 
	 * var cat1 = new Cliente(1L,"Informática"); var cat2 = new
	 * Cliente(2L,"Escritório");
	 * 
	 * List<Cliente> lista = Arrays.asList(cat1,cat2);
	 * 
	 * return lista; }
	 */
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		/*
		 * var cat1 = new Cliente(1L,"Informática"); var cat2 = new
		 * Cliente(2L,"Escritório");
		 */	
		Cliente obj = service.buscar(id); 
		return ResponseEntity.ok(obj); 
	}
}
