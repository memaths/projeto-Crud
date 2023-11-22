package com.projeto.crud.entidade;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// A classe representa um pedido no sistema.
@Entity
@Table(name = "pedidos")
public class Pedido {
    // ID único do pedido.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nome do item.
    private String item;
    
    //valor deste item
    private float valor;

   

    // Relacionamento muitos-para-um com a entidade cliente.
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    // Anotação para evitar referências cíclicas ao serializar para JSON.
    @JsonBackReference
    private Cliente cliente;

    // Construtor vazio padrão.
    public Pedido() {
    }

    // Getters e Setters

    // Método getter para obter o id do pedido.
    public Long getId() {
        return id;
    }

    // Método setter para definir o id do pedido.
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para obter o item do pedido.
    public String getitem() {
        return item;
    }

    // Método setter para definir o item do pedido.
    public void setitem(String item) {
        this.item = item;
    }
    // metodo getter para obter o valor do item pedido.
    public float getValor() {
        return valor;
    }
    // metodo setter para definir o valor do item pedido.
    public void setValor(float valor) {
        this.valor = valor;
    }

    // Método getter para obter o cliente do pedido.
    public Cliente getCliente() {
        return cliente;
    }

    // Método setter para definir o cliente do pedido.
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}