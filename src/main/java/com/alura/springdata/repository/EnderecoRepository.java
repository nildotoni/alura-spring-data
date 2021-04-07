package com.alura.springdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alura.springdata.orm.Endereço;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereço, Integer> {

	Iterable<Endereço> findByFuncionario_Nome(String funcnome);

	Endereço findBydescricao(String endid);

}
