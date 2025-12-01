# Backend - Fase 2 - Banco de Dados

## Pré-requisitos

Antes de rodar o projeto, você precisa ter instalado:

- [Java 17 JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)  
- [Maven](https://maven.apache.org/install.html)  
- [Git](https://git-scm.com/downloads)  
- [PostgreSQL](https://www.postgresql.org/download/)  
- IDE sugerida: [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- SGBD sugerido: [PgAdmin](https://www.pgadmin.org/)

* No SGBD rodar o comando :
  ```
  create database banco-fase2
  
  ```
  
## 📥 Clonar o repositório

```
 git clone https://github.com/rodrigo0oliveira/database_fase2.git
```
```
 cd database_fase2
```
```
 mvn spring-boot:run
```

* Não é necessário realizar nenhum comando no sgbd além do create database, todas as tabelas,procedures,functions e triggers são criadas pelas migrations do Flyway.

* As demais informações sobre especificadades do projeto estão descritas no documento : (https://docs.google.com/document/d/1u1iTVWWqQ8DfwUkSKO77tk8mCpJ9kP6Ptp5ibbYXLpo/edit?tab=t.0)


