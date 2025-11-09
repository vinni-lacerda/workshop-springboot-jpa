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
- Configurar **banco de dados postgreSQL e H2**
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

```text
src/
├─ main/
│  ├─ java/
│  │  └─ com/SeuUsuario/workshop/
│  │     ├─ entities/
│  │     ├─ repositories/
│  │     ├─ controllers/
│  │     └─ services/
│  └─ resources/
│     ├─ application.properties
│     └─ import.sql
└─ test/
   └─ java/com/SeuUsuario/workshop/
```

---

## ▶️ Como Executar o Projeto

### Pré-requisitos:
- Java JDK 17+
- Maven
- IDE (IntelliJ / Eclipse / VS Code)

### Passos:

1. Usando H2 (padrão — rápido para desenvolvimento)
   
1. **Clone o repositório**
   ```bash
   git clone https://github.com/vinni-lacerda/workshop-springboot-jpa.git

2. Acesse o diretório
```text
cd workshop-springboot-jpa
```

3. Execute o projeto
```text
mvn spring-boot:run
```

4. Acesse no navegador
```text
http://localhost:8080/h2-console
```

5. Coloque usuário e senha no H2 Console
```text
username: sa
password:
```
2. Usando PostgreSQL (opcional)

Use esta opção se quiser persistir os dados em um banco real.

🧱 A. Criar banco e usuário no PostgreSQL

No terminal do Postgres (psql):
```text
CREATE DATABASE workshopdb;
CREATE USER postgres WITH ENCRYPTED PASSWORD 'YOUR_PASSWORD';
GRANT ALL PRIVILEGES ON DATABASE workshopdb TO postgres;
```

Substitua YOUR_PASSWORD pela senha do seu usuário.


B. Atualize o arquivo application.properties

No diretório src/main/resources, use a seguinte configuração:
```text
# PostgreSQL Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/workshopdb
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

C. Execute o projeto
```text
mvn spring-boot:run
```

📡 Endpoints Exemplos
```text
Método	 Endpoint	   Descrição
GET	    /users	     Lista todos os usuários
GET	    /users/{id}  Busca usuário por ID
POST	  /users	     Cadastra novo usuário
PUT	    /users/{id}	 Atualiza usuário existente
DELETE	/users/{id}	 Remove usuário
```

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
