# 🚀 Workshop Spring Boot 3 + JPA / Hibernate  

![Java](https://img.shields.io/badge/Java-17+-red?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-brightgreen?logo=springboot)
![Hibernate](https://img.shields.io/badge/Hibernate-JPA-blue?logo=hibernate)
![Database](https://img.shields.io/badge/Database-H2%20%7C%20PostgreSQL-lightgrey?logo=postgresql)
![Maven](https://img.shields.io/badge/Build-Maven-orange?logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-yellow)
![Status](https://img.shields.io/badge/Status-Completed-success)

---

Projeto desenvolvido por Vinicius Lacerda.  
O objetivo é criar uma aplicação **web com API REST** utilizando **Spring Boot**, **JPA/Hibernate** e **banco de dados relacional**, praticando **mapeamento objeto-relacional**, **serviços**, **repositórios** e **tratamento de exceções**.  

---

## 🎯 Objetivos do Projeto

- Criar um projeto **Spring Boot Java**
- Implementar um **modelo de domínio**
- Estruturar camadas lógicas:  
  `resource`, `service`, `repository`
- Configurar **banco de dados de teste (H2)**
- Popular o banco de dados com **dados iniciais**
- Implementar operações **CRUD (Create, Read, Update, Delete)**
- Tratar **exceções de forma personalizada**

---

## 🛠️ Tecnologias Utilizadas

- ☕ **Java 17+**  
- ⚙️ **Spring Boot 3**  
- 🗃️ **Spring Data JPA / Hibernate**  
- 🌐 **Spring Web**  
- 💾 **H2 Database**  
- 🐘 **PostgreSQL**  
- 🧰 **Maven**  
- 📬 **Postman**

---

## 🧩 Modelo de Domínio

O sistema modela um **fluxo de pedidos**, com as seguintes entidades:

| Entidade | Descrição |
|-----------|------------|
| **User** | Cliente do sistema |
| **Order** | Pedido realizado por um cliente |
| **OrderStatus** | Enum para status do pedido |
| **Category** | Categorias de produtos |
| **Product** | Produtos disponíveis |
| **OrderItem** | Itens do pedido (relação muitos-para-muitos com atributos extras) |
| **Payment** | Pagamento associado ao pedido (relação um-para-um) |

---

## ⚙️ Estrutura do Projeto

src/
├─ main/
│  ├─ java/
│  │  └─ com/
│  │     └─ vinnilacerda/
│  │        └─ workshop/
│  │           ├─ entities/
│  │           ├─ repositories/
│  │           ├─ resources/     # controllers / rest
│  │           └─ services/
│  └─ resources/
│     ├─ application.properties
│     └─ import.sql
└─ test/
   └─ java/
      └─ com/
         └─ vinnilacerda/
            └─ workshop/


---

## ▶️ Como Executar o Projeto

### Pré-requisitos:
- Java JDK 17+
- Maven
- IDE (IntelliJ / Eclipse / VS Code)

### Passos:

1. **Clone o repositório**
   ```bash
   git clone https://github.com/vinni-lacerda/workshop-springboot-jpa.git

2. Acesse o diretório

cd workshop-springboot-jpa


3. Execute o projeto

mvn spring-boot:run


4. Acesse no navegador

http://localhost:8080/

📡 Endpoints Exemplos
Método	 Endpoint	   Descrição
GET	    /users	     Lista todos os usuários
GET	    /users/{id}  Busca usuário por ID
POST	  /users	     Cadastra novo usuário
PUT	    /users/{id}	 Atualiza usuário existente
DELETE	/users/{id}	 Remove usuário

🧱 Próximos Passos:

Implementar Swagger/OpenAPI para documentação automática

Adicionar Spring Security + JWT

Migrar para banco real com Docker + PostgreSQL

Implementar DTOs e ModelMapper

Criar testes de integração e cobertura com MockMvc

📄 Licença

Este projeto está sob a licença MIT.
Sinta-se livre para usar, estudar e modificar conforme desejar.

👨‍💻 Autor

📎 <a href= https://www.linkedin.com/in/vinni-lacerda>Vinícius Lacerda</a>
📎 <a href=https://github.com/vinni-lacerda>GitHub</a>
