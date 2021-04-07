package com.alura.springdata.orm;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Endereços")
public class Endereço {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String endereço;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Funcionario funcionario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Endereço(String descricao, String endereço, Funcionario funcionario) {
		
		this.descricao = descricao;
		this.endereço = endereço;
		this.funcionario = funcionario;
	}

	public Endereço() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Endereço_id: " + id + ", descricao: " + descricao + ", endereço: =" + endereço + ", funcionario: "
				+ funcionario.getNome();
	}

	
}
