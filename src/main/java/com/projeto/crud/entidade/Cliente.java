package com.projeto.crud.entidade;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

// A classe representa um cliente que realizou um pedido no sistema.
@Entity
@Table(name = "cliente")
public class Cliente {
    // ID único do cliente.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do Cliente.
    private String name;

    // Relacionamento um-para-muitos com a entidade pedidos.
    @OneToMany(mappedBy = "cliente")
    // Anotação para gerenciar referências no JSON (evita referências
    // cíclicas/loops).
    @JsonManagedReference
    private List<Pedido> pedido;

    // Construtor vazio padrão.
    public Cliente() {
    }

    // Getters e Setters

    // Método getter para obter o id do cliente.
    public Long getId() {
        return id;
    }

    // Método setter para definir o id do cliente.
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para obter o nome do cliente.
    public String getName() {
        return name;
    }

    // Método setter para definir o nome do cliente.
    public void setName(String name) {
        this.name = name;
    }

    // Método getter para obter a lista de pedidos associados a este cliente.
    public List<Pedido> getPedido() {
        return pedido;
    }

    // Método setter para definir a lista de pedidos associados a este cliente.
    public void setBooks(List<Pedido> pedidos) {
        this.pedido = pedidos;
    }

    public void setPedidos(List<Pedido> pedido) {
    }
}