package com.example.cursomc.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service; 
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		var cat1 = new Categoria(1L,"Informática");
		var cat2 = new Categoria(2L,"Escritório"); 
		
		List<Categoria> lista = Arrays.asList(cat1,cat2); 
		
		return lista; 
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		/*
		 * var cat1 = new Categoria(1L,"Informática"); var cat2 = new
		 * Categoria(2L,"Escritório");
		 */
		Categoria obj = service.buscar(id); 
		return ResponseEntity.ok(obj); 
	}
}
