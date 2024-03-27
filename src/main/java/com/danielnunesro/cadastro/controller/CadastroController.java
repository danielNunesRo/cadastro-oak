package com.danielnunesro.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielnunesro.cadastro.service.CadastroService;
import com.danielnunesro.cadastro.vo.CadastroVO;

@RestController
@RequestMapping("/api/products")
public class CadastroController {
	
	@Autowired
	private CadastroService cadastroService;
	
	@PostMapping("/create")
    public ResponseEntity<CadastroVO> createCadastro(@RequestBody CadastroVO cadastroVO) {
        CadastroVO createdCadastro = cadastroService.create(cadastroVO);
        return new ResponseEntity<>(createdCadastro, HttpStatus.CREATED);
    }
	
	@GetMapping("/allproducts")
    public ResponseEntity<List<CadastroVO>> getAllCadastros() {
        List<CadastroVO> cadastros = cadastroService.findAll();
        return new ResponseEntity<>(cadastros, HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<CadastroVO> getCadastroById(@PathVariable Long id) {
        CadastroVO cadastro = cadastroService.findById(id);
        return new ResponseEntity<>(cadastro, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCadastro(@PathVariable Long id) {
        cadastroService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Resource deleted successfully");
	}
    
	
	@PutMapping("/{id}")
    public ResponseEntity<CadastroVO> updateCadastro(@PathVariable Long id, @RequestBody CadastroVO cadastroVO) {
        CadastroVO updatedCadastro = cadastroService.update(id, cadastroVO);
        return new ResponseEntity<>(updatedCadastro, HttpStatus.OK);
    }
	
}
