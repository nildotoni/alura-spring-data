package com.alura.springdata.orm;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer cpf;
	private Integer salario;
	private Date data_contratacao;
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
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public Integer getSalario() {
		return salario;
	}
	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	public Date getData_contratacao() {
		return data_contratacao;
	}
	public void setData_contratacao(Date data_contratacao) {
		this.data_contratacao = data_contratacao;
	}
	@Override
	public String toString() {
		return "id: " + id + ", nome: " + nome + ", cpf: " + cpf + ", salario: " + salario
				+ ", data_contratacao: " + data_contratacao;
	}
	public Funcionario(String nome, Integer cpf, Integer salario, Date data_contratacao) {
		
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.data_contratacao = data_contratacao;
	}
	
	
	
}
