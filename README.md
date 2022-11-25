# spring-book

Aplicação do [Livro](https://www.casadocodigo.com.br/products/livro-backend-java?_pos=7&_sid=82fcff755&_ss=r)📘 sobre Java Back-end. 

## 👨‍💻 Tecnolgias utilizadas na construção dos micro-serviços REST:
1. [Spring Boot](https://spring.io/)
2. [Postgres](https://www.postgresql.org/)
3. [Docker](Docker)
4. [Kubernetes](https://kubernetes.io/pt-br/) (Ainda Não implementado) 
5. [VueJs](https://vuejs.org/)

## Setup

1. Necessário rodar o comando abaixo para gerar o .jar dos microserviços. Necessário acessar a pasta e ter o maven instalado.
```bash
mvn clean package
```

A estrutura da aplicação roda em cima de containers docker.

> O comando para rodar os containers está abaixo.

```bash
docker compose up -d
```

## Swagger-UI

O projeto também possui a lib do Swagger-ui instalado em cada um dos micro-serviços, ela está acessível pelo link:

```bash
[endereco-micro-serviço]/swagger-ui/index.html
```

## 💻 Front-End

O frot-end da aplicação será desenvolvido com VueJS.

1. Tela para cadastro, alteração e exclusão de:
    - Usuários
    - Produtos
    - Shoping

2. Implementar paginação em uma das telas de consulta.

## 🖥 Back-End

Ainda são necessários ajustes no back-end.

1. Implementar paginação em uma rotina.
2. Modificar para rodar todos os containers com apenas um docker compose. [x]
3. Gerar os builds dos microserviços. [x]
4. Desenvolver a comunicação do Front com os microserviços.
