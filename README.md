# spring-book

Aplicação do [Livro](https://www.casadocodigo.com.br/products/livro-backend-java?_pos=7&_sid=82fcff755&_ss=r)📘 sobre Java Back-end. 

## 👨‍💻 Tecnolgias utilizadas na construção dos micro-serviços REST:
1. [Spring Boot](https://spring.io/)
2. [Postgres](https://www.postgresql.org/)
3. [Docker](Docker)
4. [Kubernetes](https://kubernetes.io/pt-br/) (Ainda Não implementado) 
5. [VueJs](https://vuejs.org/)

A estrutura da aplicação roda em cima de containers docker.

> O comando para rodar os containers está abaixo.

*Vou implementar compose único*

## Container Postgres:

```bash
docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres
```

Container User-API:

Container Product-API:

Container Shoping-API:


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

2. Criar modal para Alteração.

3. Implementar paginação em uma das telas de consulta.

## 🖥 Back-End 

Ainda são necessários ajustes no back-end.

1. Implementar paginação em uma rotina.
2. Modificar para rodar todos os containers com apenas um docker compose.
3. Gerar os builds dos microserviços.
4. Desenvolver a comunicação do Front com os microserviços.
