# spring-book

Aplicação do [Livro](https://www.casadocodigo.com.br/products/livro-backend-java?_pos=7&_sid=82fcff755&_ss=r)📘 sobre Java Back-end. 

## 👨‍💻 Tecnolgias utilizadas na construção dos micro-serviços REST:
1. [Spring Boot](https://spring.io/)
2. [Postgres](https://www.postgresql.org/)
3. [Docker](Docker)
4. [Kubernetes](https://kubernetes.io/pt-br/)

A estrutura da aplicação roda em cima de containers docker, abaixo estão os comandos para colocar os containers em funcionamento.

## Container Postgres:

```bash
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres
```

## Container User-API:

```bash
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres
```

## Container Product-API:

```bash
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres
```

## Container Product-API:

```bash
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres
```