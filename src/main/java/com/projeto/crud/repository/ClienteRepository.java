package com.projeto.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.crud.entidade.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // clienteRepository é uma interface que estende JpaRepository, que é fornecida pelo Spring Data JPA.
    // Essa interface fornece métodos de acesso aos dados do tipo cliente no banco de dados.

    // cliente é o tipo de entidade com o qual essa interface está associada.
    // Long especifica o tipo de dados do ID da entidade, que neste caso é cliente.
    // Ou seja, os ids dos clientes são tipo Long.

    // Com essa interface, é possível ter acesso a métodos como save, findById, findAll, delete, entre outros,
    // para realizar operações de CRUD no banco de dados associadas à entidade cliente.
    // O Spring Data JPA implementa esses métodos automaticamente.
}

