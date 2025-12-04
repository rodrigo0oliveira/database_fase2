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
  create database fase2_database
  
  ```

  * Antes de rodar o projeto verificar as credenciais do postgres no application.properties, por padrão o usuário está postgres com senha postgres,mas pode alterar de acordo com o que está configurado seu banco de dados
  
## 📥 Clonar o repositório

```
 git clone https://github.com/rodrigo0oliveira/database_fase2.git
```
```
 cd fase2_database
```
```
 mvn spring-boot:run
```

* Não é necessário realizar nenhum comando no sgbd além do create database, todas as tabelas,procedures,functions e triggers são criadas pelas migrations do Flyway.

* As demais informações sobre especificadades do projeto estão descritas no documento : (https://docs.google.com/document/d/1u1iTVWWqQ8DfwUkSKO77tk8mCpJ9kP6Ptp5ibbYXLpo/edit?tab=t.0)


## Como testar o CRUD, procedures ,functions e triggers

* Post:
  - url: http://localhost:8080/consulta
  - body:
```json
{
    "valor": 150.50,
    "dataHoraInicio": "2025-11-27T15:00:00",
    "dataHoraFim": "2025-11-27T16:00:00",
    "medicoId": 1,
    "pacienteId": 2
}
```

* Nessa requisição será disparado a trigger *trg_create_pagamento_consulta_data* que criará um registro na tabela pagamento_consulta com algumas informações sobre a consulta.
* Nessa requisição também é chamada a função *fn_medico_disponivel* para verificar se o médico está disponível no horário, ela pode ser testada depois de criar a consulta com o body acima e tentar repetir novamente a mesma requisição com o mesmo body, irá lançar uma exceção informando que o médico não está disponível.

* Get:
  - url: http://localhost:8080/consulta/1 - get by id
  - url:  http://localhost:8080/consulta - find all

* Delete:
   - url: http://localhost:8080/{id}
     
* Put:
  - url: http://localhost:8080/consulta/finaliza/1 - finaliza consulta
    * Nessa requisição será chamada a procedure finaliza consulta, só permitirá finalizar a consulta se o pagamento tiver sido feito.
  - url: http://localhost:8080/consulta/1 - altera valor da consulta
  - body:
```json
{
    "valor": 270.50,
}
```

* Caso o valor seja diferente do que já existe e o pagamento da consulta já tiver sido realizado, a trigger *trg_proteger_valor_pago* lançará uma exceção informando que não pode ser mudada.
    
