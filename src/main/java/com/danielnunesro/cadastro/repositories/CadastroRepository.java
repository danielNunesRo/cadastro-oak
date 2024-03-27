package com.danielnunesro.cadastro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.danielnunesro.cadastro.entities.Cadastro;
import com.danielnunesro.cadastro.vo.ResponseVO;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
	
	 @Query("SELECT new com.danielnunesro.cadastro.vo.ResponseVO(c.nameProduct, c.price) FROM Cadastro c ORDER BY c.price ASC")
	 List<ResponseVO> findAllNamesAndPricesOrderedByPrice();
	
}
