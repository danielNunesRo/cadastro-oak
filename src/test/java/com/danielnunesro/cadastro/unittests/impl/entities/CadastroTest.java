package com.danielnunesro.cadastro.unittests.impl.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.danielnunesro.cadastro.entities.Cadastro;

@SpringBootTest
public class CadastroTest {
	
	@Test
    public void testSettersAndGetters() {
        Cadastro cadastro = new Cadastro();
        
        cadastro.setId(1L);
        cadastro.setNameProduct("Produto A");
        cadastro.setDescription("Descrição do Produto A");
        cadastro.setPrice(100.00);
        cadastro.setDisponible(true);
        
        assertEquals(1L, cadastro.getId());
        assertEquals("Produto A", cadastro.getNameProduct());
        assertEquals("Descrição do Produto A", cadastro.getDescription());
        assertEquals(100.00, cadastro.getPrice());
        assertEquals(true, cadastro.isDisponible());
    }
	
}
