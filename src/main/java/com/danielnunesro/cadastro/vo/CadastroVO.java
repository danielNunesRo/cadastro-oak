package com.danielnunesro.cadastro.vo;

import com.danielnunesro.cadastro.entities.Cadastro;

public class CadastroVO {
	
	private Long id;
	
	private String nameProduct;
	
	private String description;
	
	private Double price;
	
	private boolean disponible;
	
	public CadastroVO() {
		
	}

	public CadastroVO(Long id, String nameProduct, String description, Double price, boolean disponible) {
		this.id = id;
		this.nameProduct = nameProduct;
		this.description = description;
		this.price = price;
		this.disponible = disponible;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public CadastroVO(Cadastro cadastro) {
        this.id = cadastro.getId();
        this.nameProduct = cadastro.getNameProduct();
        this.description = cadastro.getDescription();
        this.price = cadastro.getPrice();
        this.disponible = cadastro.isDisponible();
    }
	
	
	
	
	
	
}
