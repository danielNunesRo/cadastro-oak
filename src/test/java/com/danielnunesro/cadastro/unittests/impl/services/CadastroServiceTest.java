package com.danielnunesro.cadastro.unittests.impl.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.danielnunesro.cadastro.entities.Cadastro;
import com.danielnunesro.cadastro.exception.RequiredObjectIsNullException;
import com.danielnunesro.cadastro.exception.ResourceNotFoundException;
import com.danielnunesro.cadastro.repositories.CadastroRepository;
import com.danielnunesro.cadastro.service.CadastroService;
import com.danielnunesro.cadastro.vo.CadastroVO;

@SpringBootTest
public class CadastroServiceTest {
	
	@InjectMocks
	private CadastroService cadastroService;
	
	@Mock
	private CadastroRepository cadastroRepository;
	
	@Test
	public void testCreateWithEmptyOrNullFields() {
		
		CadastroVO cadastroVO = new CadastroVO(null, "", "Descrição do Produto A", null, true);
		
		assertThrows(RequiredObjectIsNullException.class, () -> {
			cadastroService.create(cadastroVO);
		});
	}
	
	@Test
	public void testCreate() {
		CadastroVO cadastroVO = new CadastroVO(null, "Produto A", "Descrição do Produto A", 100.00, true);
		
		Mockito.when(cadastroRepository.save(Mockito.any(Cadastro.class))).thenAnswer(invocation -> {
            Cadastro cadastro = invocation.getArgument(0);
            cadastro.setId(1L); 
            return cadastro;
        });
		
		CadastroVO result = cadastroService.create(cadastroVO);
        
        assertNotNull(result);
        
        assertEquals(cadastroVO.getNameProduct(), result.getNameProduct());
        assertEquals(cadastroVO.getDescription(), result.getDescription());
        assertEquals(cadastroVO.getPrice(), result.getPrice());
        assertEquals(cadastroVO.isDisponible(), result.isDisponible());
		
	}
	
	@Test
	public void testFindAll() {
		Cadastro cadastro1 = new Cadastro();
        cadastro1.setId(1L);
        cadastro1.setNameProduct("Produto A");
        cadastro1.setDescription("Descrição do Produto A");
        cadastro1.setPrice(100.00);
        cadastro1.setDisponible(true);

        Cadastro cadastro2 = new Cadastro();
        cadastro2.setId(2L);
        cadastro2.setNameProduct("Produto B");
        cadastro2.setDescription("Descrição do Produto B");
        cadastro2.setPrice(200.00);
        cadastro2.setDisponible(false);

        Mockito.when(cadastroRepository.findAll()).thenReturn(Arrays.asList(cadastro1, cadastro2));

        List<CadastroVO> cadastroVOList = cadastroService.findAll();

        assertNotNull(cadastroVOList);

        assertEquals(2, cadastroVOList.size());

        
	}
	
	@Test
	public void testFindByIdWhenIdExists() {
		Long id = 1L;
        Cadastro cadastro = new Cadastro();
        cadastro.setId(id);
        when(cadastroRepository.findById(id)).thenReturn(Optional.of(cadastro));

        CadastroVO result = cadastroService.findById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
	}
	
	@Test
	public void testFindByIdWhenIdNotExists() {
		Long id = 2L;
        when(cadastroRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            cadastroService.findById(id);
        });
	}
	
	@Test
	public void testDeleteWhenIdExist() {
        Long id = 1L;

        when(cadastroRepository.existsById(id)).thenReturn(true);

        cadastroService.delete(id);

        verify(cadastroRepository).deleteById(id);
    }
	
	 @Test
	 public void testDeleteQuandoIdNaoExiste() {
	        Long id = 2L;

	        when(cadastroRepository.existsById(id)).thenReturn(false);

	        assertThrows(ResourceNotFoundException.class, () -> {
	            cadastroService.delete(id);
	        });

	        verify(cadastroRepository, never()).deleteById(id);
	    }
	
	 @Test
	 public void testUpdateQuandoIdNaoExiste() {
	     Long id = 2L;
	     when(cadastroRepository.findById(id)).thenReturn(Optional.empty());

	     CadastroVO cadastroVO = new CadastroVO();
	     cadastroVO.setId(id);
	     cadastroVO.setNameProduct("Novo Produto");
	     cadastroVO.setDescription("Nova Descrição");
	     cadastroVO.setPrice(99.99);
	     cadastroVO.setDisponible(true);

	     assertThrows(ResourceNotFoundException.class, () -> {
	         cadastroService.update(id, cadastroVO);
	     });
	 }
	
	
}
