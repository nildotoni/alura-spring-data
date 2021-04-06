package com.alura.springdata.services;

import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class CrudFuncionarioService {

	private Boolean system = true;
	
	private void inicia(Scanner scanner) {
		while(system) {
		System.out.println("Digite a opção desejada");
		System.out.println("1 - Cadastrar Funcionário");
		
		int action = scanner.nextInt();
		
		
		}
	}
	
	private void salvar() {
		
	}
	
	private void atualizar() {
		
	}
	
	private void deletar() {
		
	}
	
	private void listar() {
		
	}
	
}
