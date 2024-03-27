package com.danielnunesro.cadastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("Prova experimental Oak")
				.version("v1")
				.description(""
						+ "𝐂𝐚𝐝𝐚𝐬𝐭𝐫𝐨:"
						+ "- Formulário com os campos abaixo:\r\n"
						+ "\r\n"
						+ "  - Nome do produto - campo de texto\r\n"
						+ "  - Descrição do produto - campo de texto\r\n"
						+ "  - Valor do produto - campo de valor\r\n"
						+ "  - Disponível para venda - campo com 2 opções: sim / não\r\n"
						+ "\r\n"
						+ "𝐋𝐢𝐬𝐭𝐚𝐠𝐞𝐦:\r\n"
						+ "\r\n"
						+ "- Colunas da listagem: nome, valor\r\n"
						+ "- Ordenação por valor do menor para o maior\r\n"
						+ "- Quando cadastrar um novo produto é para abrir a listagem automaticamente\r\n"
						+ "- Deve existir um botão para cadastrar um novo produto a partir da listagem")
				.termsOfService("https://github.com/danielNunesRo")
				.license(
					new License()
						.name("Apache 2.0")
						.url("https://github.com/danielNunesRo")
					)
				);
	}

	
}
