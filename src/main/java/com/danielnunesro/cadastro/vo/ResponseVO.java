package com.danielnunesro.cadastro.vo;

public class ResponseVO {
	
	private String nameProduct;
    
	private Double price;
	
	public ResponseVO() {
		
	}

	public ResponseVO(String nameProduct, Double price) {
		super();
		this.nameProduct = nameProduct;
		this.price = price;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
