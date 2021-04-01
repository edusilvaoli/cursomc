package com.example.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.cursomc.domain.Categoria;
import com.example.cursomc.domain.Cidade;
import com.example.cursomc.domain.Cliente;
import com.example.cursomc.domain.Endereco;
import com.example.cursomc.domain.Estado;
import com.example.cursomc.domain.ItemPedido;
import com.example.cursomc.domain.Pagamento;
import com.example.cursomc.domain.PagamentoComBoleto;
import com.example.cursomc.domain.PagamentoComCartao;
import com.example.cursomc.domain.Pedido;
import com.example.cursomc.domain.Produto;
import com.example.cursomc.domain.enums.EstadoPagamento;
import com.example.cursomc.domain.enums.TipoCliente;
import com.example.cursomc.repositories.CategoriaRepository;
import com.example.cursomc.repositories.CidadeRepository;
import com.example.cursomc.repositories.ClienteRepository;
import com.example.cursomc.repositories.EnderecoRepository;
import com.example.cursomc.repositories.EstadoRepository;
import com.example.cursomc.repositories.ItemPedidoRepository;
import com.example.cursomc.repositories.PagamentoRepository;
import com.example.cursomc.repositories.PedidoRepository;
import com.example.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner { // com commandlinerunner pode adicionar os metodos na
																// inicialiazação da app
	@Autowired
	private CategoriaRepository catRep; 
	
	@Autowired
	private ProdutoRepository prodRep; 
	
	@Autowired
	private CidadeRepository cidRep; 
	
	@Autowired
	private EstadoRepository estRep; 
	
	@Autowired
	private ClienteRepository cliRep; 
	
	@Autowired
	private EnderecoRepository endRep;
	
	@Autowired
	private PagamentoRepository pagRep;
	
	@Autowired
	private PedidoRepository pedRep;
	
	@Autowired
	private ItemPedidoRepository itemRep;
	
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
		
		//catRep.saveAll(Arrays.asList(c1,c2)); 
		//prodRep.saveAll(Arrays.asList(p1,p2,p3)); 
		
		Estado est1 = new Estado(null,"Minas Gerais"); 
		Estado est2 = new Estado(null,"São Paulo"); 
		
		Cidade cid1 = new Cidade(null,"Uberlandia",est1); 
		Cidade cid2 = new Cidade(null,"São Paulo",est2);
		Cidade cid3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().add(cid1); 
		
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
		
		
		//estRep.saveAll(Arrays.asList(est1,est2)); 
		//cidRep.saveAll(Arrays.asList(cid1,cid2,cid3)); 
		
		Cliente cli1 = new Cliente(null,"Maria Silva 3","maria@gmail.com","30020010020",TipoCliente.PESSOAFISICA); 
		
		//cli1.getTelefones().addAll(Arrays.asList("20002000","20003001")); 
		
		Endereco e1 = new Endereco(null,"Rua FLores 3","20",null,"Teste","07089999",cli1,cidRep.findById(1L).get());
		Endereco e2 = new Endereco(null,"Rua Teste 3","33",null,"Teste 2","07089991",cli1,cidRep.findById(2L).get());
		
		/*cli1.getEnderecos().addAll(Arrays.asList(e1,e2)); 
		
		cliRep.save(cli1); 
		
		endRep.saveAll(Arrays.asList(e1,e2)); */
		
		Cliente cliente1 = cliRep.findById(2L).get(); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm"); //uma mascara para instaciar a data
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2010 10:32"),cliente1, endRep.findById(3L).get());
		Pedido ped2 = new Pedido(null,sdf.parse("30/10/2012 10:32"),cliente1, endRep.findById(4L).get());
		
		Pagamento pag1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6); 
		ped1.setPagamento(pag1); 
		
		Pagamento pag2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2010 00:00"),null); 
		ped2.setPagamento(pag2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		/*pedRep.saveAll(Arrays.asList(ped1,ped2)); 
		pagRep.saveAll(Arrays.asList(pag1,pag2));*/ 
		
		ItemPedido ip1 = new ItemPedido(pedRep.findById(1L).get(), prodRep.findById(1L).get(), 0.00, 1, 2000.00); 
		ItemPedido ip2 = new ItemPedido(pedRep.findById(1L).get(),  prodRep.findById(3L).get(), 0.00, 2, 80.00); 
		ItemPedido ip3 = new ItemPedido(pedRep.findById(2L).get(), prodRep.findById(2L).get(), 100.00,1,800.00); 
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2)); 
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1)); 
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		
		//itemRep.saveAll(Arrays.asList(ip1,ip2,ip3)); 
	}

}
