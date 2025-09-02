# 📌 Projeto de Estudo Prático - API de Produtos

Este projeto faz parte de um estudo prático que estou desenvolvendo para consolidar meus conhecimentos em Java e Spring Framework, aplicando boas práticas de desenvolvimento e explorando o ciclo completo de criação de uma aplicação backend com conexão a banco de dados e endpoints.

## 🛠️ Tecnologias Utilizadas
- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- Bean Validation (Jakarta Validation)
- H2 Database (para ambiente de teste)
- Maven

## 📚 Objetivo
- Praticar a organização em camadas: Controller → Service → Repository → Model.  
- Aplicar boas práticas como separação de responsabilidades e uso de DTOs.  
- Utilizar Bean Validation para validação de dados recebidos.  
- Simular operações básicas de um CRUD de Produtos e Categorias.
- Uso de Endpoints por meio do controller para se comunicar através da web.

## 📂 Estrutura do Projeto
- **controller/** → Endpoints da API.  
- **service/** → Regras de negócio.  
- **repository/** → Acesso e manipulação dos dados (DAO / JPA Repository).  
- **dto/** → Objetos de transferência de dados (entrada e saída).  
- **model/** → Entidades mapeadas para o banco de dados.  
