package com.danielnunesro.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielnunesro.cadastro.entities.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

}
