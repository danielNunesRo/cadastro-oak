
   <h1>Cadastro de Produtos - README</h1>

   <p>Este projeto é uma aplicação de cadastro de produtos, desenvolvida em Java com Spring Boot e Spring Data JPA para o backend. Ele oferece operações CRUD (Create, Read, Update, Delete) para gerenciar produtos em um banco de dados PostgreSQL.</p>

  <h2>Tecnologias Utilizadas:</h2>

   <h3>Backend:</h3>
    <ul>
        <li>Java</li>
        <li>Spring Boot</li>
        <li>Spring Data JPA</li>
        <li>PostgreSQL</li>
        <li>Docker</li>
    </ul>

  <h2>Funcionalidades:</h2>

   <ul>
        <li><strong>Cadastro de Produtos:</strong> Permite adicionar novos produtos com nome, descrição, preço e disponibilidade.</li>
        <li><strong>Listagem de Produtos:</strong> Exibe todos os produtos cadastrados, ordenados por preço.</li>
        <li><strong>Atualização de Produtos:</strong> Permite modificar os detalhes de um produto existente.</li>
        <li><strong>Remoção de Produtos:</strong> Permite excluir um produto do banco de dados.</li>
    </ul>

   <h2>Configuração e Execução:</h2>

   <ol>
        <li>Clone o repositório do projeto:</li>
        <code>git clone https://github.com/seu-usuario/seu-projeto.git</code>

  <li>Navegue até o diretório do projeto:</li>
        <code>cd seu-projeto</code>

  <li>Execute o Docker Compose para subir os containers do backend e do banco de dados:</li>
        <code>docker-compose up --build</code>
    <li>O backend estará disponível em <code>http://localhost:8080</code> 
    </ol>

  <h2>Documentação da API:</h2>

   <p>A documentação da API pode ser acessada em <code>http://localhost:8080/swagger-ui.html</code>.</p>

   <h2>Desenvolvedores:</h2>

   <ul>
        <li><a href="https://github.com/danielNunesRo">Daniel Nunes</a></li>
    </ul>

 


