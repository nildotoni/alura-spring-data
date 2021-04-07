package com.alura.springdata.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.alura.springdata.orm.Cargo;
import com.alura.springdata.orm.Funcionario;
import com.alura.springdata.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {

	private final FuncionarioRepository funcionarioRepository;

	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	private Boolean funcmenu = true;

	public void menuFuncionario(Scanner scanner) throws java.text.ParseException {
		while (funcmenu) {
			System.out.println("Digite a opção desejada");
			System.out.println("1 - Cadastrar Funcionário");
			System.out.println("2 - Atualizar Funcionário");
			System.out.println("3 - Deletar Funcionário");
			System.out.println("4 - Listar Funcionários");

			System.out.println("0 - Sair");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvarFuncionario(scanner);
				break;
			case 2:
				atualizarFuncionario(scanner);
				break;
			case 3:
				deletarFuncionario(scanner);
				break;
			case 4:
				listarFuncionario();
				break;
			default:
				funcmenu = false;
				break;
			}
		}
	}

	private void salvarFuncionario(Scanner scanner) throws java.text.ParseException {
		System.out.println("Digite o nome do novo funcionário");
		String nome = scanner.next();

		System.out.println("Digite o cpf");
		Integer cpf = scanner.nextInt();

		System.out.println("Digite o sálario");
		Integer salario = scanner.nextInt();

		Date dataAdmissao = datando(scanner);

		Funcionario funcionario = new Funcionario(nome, cpf, salario, dataAdmissao);
		funcionarioRepository.save(funcionario);
		System.out.println("Funcionário Cadastrado");

		System.out.println(" ");

	}

	private Date datando(Scanner scanner) throws ParseException {
		Integer ano = 0000;
		Boolean anobool = true;
		while (anobool) {
			System.out.println("Digite o ano");
			ano = scanner.nextInt();
			if (ano < 0 || ano > 2021) {
				System.out.println("Digite um ano valido");

			} else {
				anobool = false;
			}
		}
		Integer mes = 00;
		Boolean mesbool = true;
		while (mesbool) {
			System.out.println("Digite o mês");
			mes = scanner.nextInt();
			if (mes < 0 || mes > 31) {
				System.out.println("Digite um mes valido");

			} else {
				mesbool = false;
			}
		}

		Integer dia = 00;
		Boolean diabool = true;
		while (diabool) {
			System.out.println("Digite o dia");
			dia = scanner.nextInt();
			if (dia < 0 || dia > 31) {
				System.out.println("Digite um dia valido");
				if (mes == 2 && dia > 28) {
					System.out.println("Digite um dia valido para fevereiro");
				}
			} else {
				diabool = false;
			}
		}

		String stringdata = Integer.toString(dia) + Integer.toString(mes) + Integer.toString(ano);

		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");

		Date data = format.parse(stringdata);

		return data;
	}

	private void atualizarFuncionario(Scanner scanner) throws ParseException {
	System.out.println("Digite o nome do funcionário que quer atualizar?");
		
		
		String findNome = scanner.next();
		Funcionario funcionario = funcionarioRepository.findByNome(findNome);
		
	System.out.println("Localizado o funcionario");
	System.out.println(funcionario);
	
	Boolean atualizando = true;
	while(atualizando) {
	System.out.println("Digite a opção desejada");
	System.out.println("1 - Atualizar nome");
	System.out.println("2 - Atualizar CPF");
	System.out.println("3 - Atualizar Salario");
	System.out.println("4 - Atualizar Data");
	System.out.println("5 - Salvar Alterações");
	Integer menu = scanner.nextInt();
	
	switch(menu){
	case 1:
		System.out.println("Digite o nome");
		String nome = scanner.next();
		funcionario.setNome(nome);
		break;
	case 2:
		System.out.println("Digite o CPF");
		Integer cpf = scanner.nextInt();
		funcionario.setCpf(cpf);
		break;
	case 3:
		System.out.println("Digite o salario");
		Integer salario = scanner.nextInt();
		funcionario.setSalario(salario);
		break;
	case 4:
		System.out.println("Digite a Data");
		Date novaData = datando(scanner);
		funcionario.setData_contratacao(novaData);
		break;
	case 5:
		
		funcionarioRepository.save(funcionario);
		System.out.println(funcionario);
		
		System.out.println("Funcionário atualizado!");
		
		atualizando = false;
		break;
	}
	}
	}
	private void deletarFuncionario(Scanner scanner) {
		System.out.println("Digite o nome do funcionário que quer deletar?");
		
		
		
		String findNome = scanner.next();
		Funcionario funcionario = funcionarioRepository.findByNome(findNome);
		
		
		Boolean deleta = true;
		while (deleta) {
			System.out.println("Confirma exclusão do funcionario "+ funcionario + " ?");
			
			System.out.println("1 - SIM, 2 - NAO");
			Integer digitado = scanner.nextInt(); 
			if (digitado == 1 || digitado == 2) {
				deleta = false;
			}
			
		}
		funcionarioRepository.delete(funcionario);
		System.out.println("Deletado o funcionario " + funcionario.getNome());
	
	}

	private void listarFuncionario() {
		Iterable<Funcionario> listaFuncionarios = funcionarioRepository.findAll();
		System.out.println("Lista de funcionários");
		listaFuncionarios.forEach(funcionario -> System.out.println(funcionario));
	}

}
