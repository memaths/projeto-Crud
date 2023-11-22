package com.projeto.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.crud.entidade.Pedido;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // pedidoRepository é uma interface que estende JpaRepository, que é fornecida pelo Spring Data JPA.
    // Essa interface fornece métodos de acesso aos dados do tipo pedido no banco de dados.
    // pedido é o tipo de entidade com o qual essa interface está associada.

    // Long especifica o tipo de dados do ID da entidade, que neste caso é pedido.
    // Ou seja, os ids dos livros são tipo Long.
    // Com essa interface, é possivel ter acesso a métodos como save, findById, findAll, delete, entre outros,
    // para realizar operações de CRUD no banco de dados associadas à entidade pedido.
    // O Spring Data JPA implementa esses métodos automaticamente . 
}
