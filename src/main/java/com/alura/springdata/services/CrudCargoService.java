package com.alura.springdata.services;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.alura.springdata.orm.Cargo;
import com.alura.springdata.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private Boolean system = true;
	private final CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao voce quer executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Atualizar Cargo");
			System.out.println("3 - Deletar Cargo");
			System.out.println("4 - Listar Cargos");
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			
			case 3:
				deletar(scanner);
				break;

			case 4:
				visualizarTudo();
				break;
			
			default:
				system = false;
				break;
				}
		}
	}
	
	

	public void salvar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo");
	}
	
	public void atualizar(Scanner scanner) {
		System.out.println("Qual cargo vai atualizar?");
		String finddescricao = scanner.next();
		Cargo cargo = cargoRepository.findByDescricao(finddescricao);
		System.out.println("Qual o novo cargo? ");
		String descricaoatualizada = scanner.next();
		cargo.setDescricao(descricaoatualizada);
		cargoRepository.save(cargo);
		System.out.println("Atualizado para " + cargo.getDescricao());
	}

	public void deletar(Scanner scanner) {
		System.out.println("Qual cargo vai deletar?");
		String finddescricao = scanner.next();
		Cargo cargo = cargoRepository.findByDescricao(finddescricao);
		
		
		Boolean deleta = true;
		while (deleta) {
			System.out.println("Confirma exclusão do cargo "+ finddescricao+ " ?");
			
			System.out.println("1 - SIM, 2 - NAO");
			Integer digitado = scanner.nextInt(); 
			if (digitado == 1 || digitado == 2) {
				deleta = false;
			}
			
		}
		cargoRepository.delete(cargo);
		System.out.println("Deletado o cargo " + cargo.getDescricao());
	}
	
	private void visualizarTudo() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
}
