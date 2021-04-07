package com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alura.springdata.orm.Cargo;
import com.alura.springdata.repository.CargoRepository;
import com.alura.springdata.services.CrudCargoService;
import com.alura.springdata.services.CrudEnderecoService;
import com.alura.springdata.services.CrudFuncionarioService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	private CrudFuncionarioService funcionarioService;
	private CrudCargoService cargoService;
	private CrudEnderecoService enderecoService;
	Boolean mainmenu = true;
	
	public SpringDataApplication(CrudFuncionarioService funcionarioService, CrudCargoService cargoService, CrudEnderecoService enderecoService) {
		this.funcionarioService = funcionarioService;
		this.cargoService = cargoService;
		this.enderecoService = enderecoService;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			Scanner scanner = new Scanner(System.in);
			   while(mainmenu) {
				   System.out.println("Digite o menu desejado");
				   System.out.println("1 - Funcionários");
				   System.out.println("2 - Cargos");
				   System.out.println("3 - Endereços");
				   int action = scanner.nextInt();
				   
				   switch(action) {
				   case 1:
					   funcionarioService.menuFuncionario(scanner);
				   case 2:
					   cargoService.inicial(scanner);
				   case 3:
					   enderecoService.menuEndereco(scanner);
				   default:
					   mainmenu = false;
					   break;
				   }
				   
			   }
				
			}
			
	


}

