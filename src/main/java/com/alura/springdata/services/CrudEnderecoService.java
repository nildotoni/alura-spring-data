package com.alura.springdata.services;


import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.alura.springdata.orm.Endereço;
import com.alura.springdata.orm.Funcionario;
import com.alura.springdata.repository.EnderecoRepository;
import com.alura.springdata.repository.FuncionarioRepository;

@Service	
public class CrudEnderecoService {

	private final EnderecoRepository enderecoRepo;
	private final FuncionarioRepository funcionarioRepository;
	
	public CrudEnderecoService(EnderecoRepository enderecoRepo, FuncionarioRepository funcionarioRepository) {
		this.enderecoRepo = enderecoRepo;
		this.funcionarioRepository = funcionarioRepository;
	}
	
	
	public void menuEndereco(Scanner scanner) {
		
		int menuEnd = 0;
		Boolean menubool = true;
		
		while(menubool) {
			System.out.println("Escolha a opção desejada");

			System.out.println("1 - Cadastrar Endereço");
			System.out.println("2 - Atualizar Endereço");
			System.out.println("3 - Excluir Endereço");
			System.out.println("4 - Listar Endereços");
			System.out.println("0 - Sair");
			menuEnd = scanner.nextInt();
			switch(menuEnd) {
			
			case 1:
				cadastraEndereco(scanner);
				break;
			case 2:
				atualizaEndereco(scanner);
				break;
			case 3:
				deletaEndereco(scanner);
				break;
			case 4:
				listaTudo();
				break;
			case 0:
				menubool = false;
				break;
			}
		}
		
	}

	public void atualizaEndereco(Scanner scanner) {
		System.out.println("Digite o nome do funcionario");
		String funcnome = scanner.next();
		Iterable<Endereço> list = enderecoRepo.findByFuncionario_Nome(funcnome);
		list.forEach(Endereço -> System.out.println(Endereço));
		System.out.println("Digite a descrição do endereço que vai atualizar");
		String endid = scanner.next();
		Endereço endereco = enderecoRepo.findBydescricao(endid);
		System.out.println("Digite o novo endereço");
		String rua = scanner.next();
		System.out.println("Digite a nova descrição");
		String desc = scanner.next();
		System.out.println("Valor digitado: " + desc);
		endereco.setDescricao(desc);
		endereco.setEndereço(rua);
		System.out.println(endereco);
		System.out.println("Confirma atualização? 1 - sim 2 - nao");
		int cases = scanner.nextInt();
		switch(cases) {
		case 1:
			enderecoRepo.save(endereco);
			break;
		}
		
		
	}
	
	public void deletaEndereco(Scanner scanner) {
		System.out.println("Digite o nome do funcionario");
		String funcnome = scanner.next();
		Iterable<Endereço> list = enderecoRepo.findByFuncionario_Nome(funcnome);		
		list.forEach(Endereço -> System.out.println(Endereço));
		System.out.println("Digite o id do endereço que vai deletar");
		Integer endid = scanner.nextInt();
	
		System.out.println("Endereço deletado" + enderecoRepo.findById(endid));
		enderecoRepo.deleteById(endid);
	}
	
	public void cadastraEndereco(Scanner scanner) {
		Endereço end = new Endereço();
		
		
		System.out.println("Digite o cpf do usuario");
		Integer cpf = scanner.nextInt();
		Funcionario funcionario = funcionarioRepository.findByCpf(cpf);
		
		end.setFuncionario(funcionario);
		
		System.out.println("Digite o novo endereco");
		@SuppressWarnings("unused")
		String corrigeparagrafoquevemnaoseidaonde = scanner.nextLine();
		String endereco = scanner.nextLine();
		System.out.println(endereco);
		end.setEndereço(endereco);
		
		System.out.println("Digite a descrição");
		String desc = scanner.next();
		end.setDescricao(desc);
		
		enderecoRepo.save(end);
		System.out.println("Endereço Salvo");
	}
	
	public void listaTudo() {
		System.out.println("Lista de Endereços");
		Iterable<Endereço> enderecos = enderecoRepo.findAll();
		enderecos.forEach(Endereço -> System.out.println(Endereço));
	}
	

}