package com.example.cursomc.domain;

import java.io.Serializable;

public class Categoria implements Serializable {
	


	//objetos convertidos para uma sequencia bytes - server para que objetos seja gravados em arquivos, trafegar em redes - Exigencia da linguagem java
	//tem que numero de versão de padrão
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	
	private String nome; 
	
	public Categoria() { //instancia objeto sem jogar nada com atributos
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//Comparar os objetos por valor e não de memória
	@Override
	public int hashCode() { //codigo numerico para cada objeto
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) { //faz comparacao do objeto
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	//comparar os objetos por valor
	
	
}
