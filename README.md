# Trabalho CRUD da disciplina de Programação Orientada a Objetos em Java

![Java Logo](https://www.pngmart.com/files/21/Spring-Logo-PNG-HD-Isolated.png)

**Aluno:** Mateus de mesquita sousa

**Matrícula:** 202202139807

Este projeto crud foi desenvolvido como parte da disciplina Programação Orientada a Objetos em Java. 
depedencias:jpa,h2 data base e springweb



### cliente (Relação Um-para-Muitos)
- **Id:** Identificador único
- **Name:** Nome do cliente
- **pedidos:** Lista de pedidos feitos pelo cliente

### pedidos (Relação Muitos-para-Um)
- **Id:** Identificador único
- **item:** nome do item
- **valor** valor do item
- **cliente:** cliente do pedido

## Como Usar o Postman

Você pode testar as operações da API CRUD usando o Postman, um cliente HTTP que permite interagir com APIs. Abaixo estão os endpoints e operações disponíveis:

### Criar um Novo Cliente (POST Cliente)
- Cria um novo cliente na base de dados.
- Endpoint: `POST localhost:8090/clientes`
![post cliente](https://github.com/memaths/projeto-Crud/assets/112908920/d106de3f-2f94-4ba9-867d-5d45b625010b)

### Criar um Novo Pedido (POST Pedido)
- Cria um novo pedido na base de dados.
- Endpoint: `POST localhost:8090/pedidos`
![post pedido](https://github.com/memaths/projeto-Crud/assets/112908920/a83d5b94-e173-4c68-93cc-e13739620631)

### Recuperar Informações de um Cliente (GET Cliente)
- Recupera informações de um cliente .
- Endpoint: `GET localhost:8090/clientes`
![get cliente](https://github.com/memaths/projeto-Crud/assets/112908920/afcdb590-c29b-43db-9423-41535ee64cb4)

### Recuperar Informações de um Pedido (GET Pedido)
- Recupera informações de um pedido .
- Endpoint: `GET localhost:8090/pedidos`
![get pedidos](https://github.com/memaths/projeto-Crud/assets/112908920/8546d72b-1a22-4373-a135-dfee1230b370)

### Atualizar Informações de um cliente (PUT cliente)
- Atualiza informações de um cliente existente.
- Endpoint: `PUT localhost:8090/clientes/{id}`
![put clientes](https://github.com/memaths/projeto-Crud/assets/112908920/00006dd0-7754-49f7-aced-7e301ac826f9)

### Atualizar Informações de um pedido (PUT pedido)
- Atualiza informações de um pedido existente.
- Endpoint: `PUT localhost:8090/pedidos/{id}`
![put pedidos](https://github.com/memaths/projeto-Crud/assets/112908920/7f055ca5-5711-4a8e-81b1-486b49d70d04)

### Excluir um cliente (DELETE cliente)
- Exclui um cliente da base de dados pelo ID.
- Endpoint: `DELETE localhost:8090/clientes/{id}`
![delete cliente](https://github.com/memaths/projeto-Crud/assets/112908920/368bbdf5-20d2-48c1-b2e0-a3e0ddbd46a8)

### Excluir um pedido (DELETE pedido)
- Exclui um pedido da base de dados pelo ID.
- Endpoint: `DELETE localhost:8090/pedidos/{id}`
![delete pedidos](https://github.com/memaths/projeto-Crud/assets/112908920/15f54b58-6ced-4bc4-b478-9c717e71245f)
