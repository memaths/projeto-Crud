package com.projeto.crud.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.crud.entidade.Pedido;
import com.projeto.crud.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class Pedidocontroller {
    // Injeção de dependência do repositorio do pedido.
    @Autowired
    private PedidoRepository pedidoRepository;

    // Retorna todos os pedidos.
    @GetMapping
    public Iterable<Pedido> getAllpedidos() {
        // Obtém todos os pedidos do repositório e os retorna.
        return pedidoRepository.findAll();
    }

    // Retorna um pedido por ID.
    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Long id) {
        // Busca um pedido pelo ID no repositório ou retorna nulo se não encontrado.
        return pedidoRepository.findById(id).orElse(null);
    }

    // Cria um novo pedido.
    @PostMapping
    public Pedido createBook(@RequestBody Pedido pedido) {
        // Salva o novo pedido no repositório e o retorna.
        return pedidoRepository.save(pedido);
    }

    // Atualiza um pedido por ID.
    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        // Verifica se o pedido existe no repositório.
        if (pedidoRepository.findById(id).orElse(null) == null) {
            return null;
        } else {
            // Define o ID do pedido e salva as alterações no repositório.
            pedido.setId(id);
            return pedidoRepository.save(pedido);
        }
    }

    // Exclui um pedido por ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        try {
            // Tentar excluir o pedido do repositório com base no ID.
            pedidoRepository.deleteById(id);

            //  Retorna uma resposta com código 204 No Content e corpo vazio se excluida com sucesso
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {

            //  Se o pedido não for encontrado, retorne um código de status 404 (Not
            // Found).
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            
            //  Se ocorrer uma exceção inesperada, retorne um código de status 500
            // (Internal Server Error).
            return ResponseEntity.status(500).build();
        }
    }

}