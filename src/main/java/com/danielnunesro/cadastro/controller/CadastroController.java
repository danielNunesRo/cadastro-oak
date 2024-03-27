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
import com.danielnunesro.cadastro.vo.ResponseVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/products")
public class CadastroController {
	
	@Autowired
	private CadastroService cadastroService;
	
	@Operation(summary = "Add a new product and list all products order by price ", description = "Adds a new Product passing in JSON", tags = {"Cadastro"}, responses = {
			@ApiResponse(description = "Created", responseCode = "201", content = @Content(schema = @Schema(implementation = CadastroVO.class))),
			@ApiResponse(description = "OK", responseCode = "200", content = @Content(schema = @Schema(implementation = ResponseVO.class)))
			
	})
	@PostMapping("/createv2")
	public ResponseEntity<?> creating(@RequestBody CadastroVO cadastro) {
		return new ResponseEntity<>(cadastroService.creating(cadastro), HttpStatus.CREATED);
	}
	
	
	@Operation(summary = "Finds all Products", description = "Finds all products", tags = {"Products"}, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", content = @Content(schema = @Schema(implementation = CadastroVO.class)))
			})
	@GetMapping("/allproducts")
    public ResponseEntity<List<CadastroVO>> getAllCadastros() {
        List<CadastroVO> cadastros = cadastroService.findAll();
        return new ResponseEntity<>(cadastros, HttpStatus.OK);
    }
	
	@Operation(summary = "Finds a Product", description = "Finds a product by ID", tags = {"Product"}, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", content = @Content(schema = @Schema(implementation = CadastroVO.class)))
			})
	@GetMapping("/{id}")
    public ResponseEntity<CadastroVO> getCadastroById(@PathVariable Long id) {
        CadastroVO cadastro = cadastroService.findById(id);
        return new ResponseEntity<>(cadastro, HttpStatus.OK);
    }
	
	
	@Operation(summary = "Deletes a Product", description = "Deletes a Product existing by passing in Json", tags = {"Product"}, responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	})
	@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCadastro(@PathVariable Long id) {
        cadastroService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Resource deleted successfully");
	}
    
	
	@Operation(summary = "Update a Product", description = "Update a Product existing passing in JSON", tags = {"Product"}, responses = {
			@ApiResponse(description = "Sucess", responseCode = "200", content = @Content(schema = @Schema(implementation = CadastroVO.class)))
			})
	@PutMapping("/{id}")
    public ResponseEntity<CadastroVO> updateCadastro(@PathVariable Long id, @RequestBody CadastroVO cadastroVO) {
        CadastroVO updatedCadastro = cadastroService.update(id, cadastroVO);
        return new ResponseEntity<>(updatedCadastro, HttpStatus.OK);
    }
	
}
