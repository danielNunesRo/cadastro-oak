package com.danielnunesro.cadastro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielnunesro.cadastro.entities.Cadastro;
import com.danielnunesro.cadastro.exception.RequiredObjectIsNullException;
import com.danielnunesro.cadastro.exception.ResourceNotFoundException;
import com.danielnunesro.cadastro.repositories.CadastroRepository;
import com.danielnunesro.cadastro.vo.CadastroVO;
import com.danielnunesro.cadastro.vo.ResponseVO;

@Service
public class CadastroService {
	
	@Autowired
	private CadastroRepository repository;
	
	
	public List<ResponseVO> creating(CadastroVO cadastro) {
		if (cadastro == null || cadastro.getNameProduct() == null || cadastro.getNameProduct().isEmpty() || 
		        cadastro.getDescription() == null || cadastro.getDescription().isEmpty() || 
		        cadastro.getPrice() == null || cadastro.getPrice().isNaN()) {
		        throw new RequiredObjectIsNullException("Todos os campos, exceto ID, devem ser preenchidos!");
		    }

		    Cadastro newCadastro = new Cadastro();
		    newCadastro.setNameProduct(cadastro.getNameProduct());
		    newCadastro.setDescription(cadastro.getDescription());
		    newCadastro.setPrice(cadastro.getPrice());
		    newCadastro.setDisponible(cadastro.isDisponible());

		    repository.save(newCadastro);

		    return repository.findAllNamesAndPricesOrderedByPrice();
	}
	
	
	public List<CadastroVO> findAll() {
		List<Cadastro> cadastroList = repository.findAll();
		
		List<CadastroVO> cadastroVOList = cadastroList.stream().map(cadastro -> new CadastroVO(cadastro)).collect(Collectors.toList());
		
		return cadastroVOList;
		
	}
	
	public CadastroVO findById(Long id) {
		
		var existingProduct = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NOT FOUND IN DB"));
		
		CadastroVO product = new CadastroVO(existingProduct);
		return product;
		
	}
	
	public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id); 
        } else {
            throw new ResourceNotFoundException("ID NOT FOUND IN DB"); 
        }
    }
	
	public CadastroVO update(Long id, CadastroVO cadastroVO) {
		
		var existingProduct = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ID NOT FOUND IN DB"));
        
		existingProduct.setNameProduct(cadastroVO.getNameProduct());
        existingProduct.setDescription(cadastroVO.getDescription());
        existingProduct.setPrice(cadastroVO.getPrice());
        existingProduct.setDisponible(cadastroVO.isDisponible());

        Cadastro updatedProduct = repository.save(existingProduct);

        return new CadastroVO(updatedProduct);
    }
	
}
