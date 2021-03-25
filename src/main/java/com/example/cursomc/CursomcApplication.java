package com.example.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Produto;
import com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner { // com commandlinerunner pode adicionar os metodos na
																// inicialiazação da app
	@Autowired
	private CategoriaRepository catRep; 
	
	@Autowired
	private ProdutoRepository prodRep; 
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria c1 = new Categoria(null,"Teste info");
		Categoria c2 = new Categoria(null,"Teste Esc");
		
		Produto p1 = new Produto(null,"Cmputador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		c1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		c2.getProdutos().add(p2); 
		
		p1.getCategorias().add(c1);
		p2.getCategorias().addAll(Arrays.asList(c1,c2)); 
		p3.getCategorias().add(c1); 
		
		catRep.saveAll(Arrays.asList(c1,c2)); 
		prodRep.saveAll(Arrays.asList(p1,p2,p3)); 
	}

}
