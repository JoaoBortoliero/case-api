package br.com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    public Optional<Pessoa> findBycnpjCpf(String cnpjCpf);

}
