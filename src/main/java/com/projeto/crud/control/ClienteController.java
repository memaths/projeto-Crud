package com.projeto.crud.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projeto.crud.entidade.Cliente;
import com.projeto.crud.entidade.Pedido;
import com.projeto.crud.repository.ClienteRepository;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    // Injeção de dependência do repositorio do cliente.
    @Autowired
    private ClienteRepository clienteRepository;

    // Retorna todos os clientes.
    @GetMapping
    public Iterable<Cliente> getAllClientes() {
        // Obtém todos os clientes do repositório.
        Iterable<Cliente> clientes = clienteRepository.findAll();
        // Para cada cliente, carrega a lista de pedidos associados.
        for (Cliente cliente : clientes) {
            cliente.setPedidos(cliente.getPedido());
        }
        // Retorna a lista de clientes.
        return clientes;
    }

    // Retorna um cliente específico por ID.
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id) {
        // Busca um cliente pelo ID no repositório ou retorna nulo se não encontrado.
        return clienteRepository.findById(id).orElse(null);
    }

    // Cria um novo cliente.
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        // Salva o novo cliente no repositório e o retorna.
        return clienteRepository.save(cliente);
    }

    // Atualiza um cliente por ID.
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        // Verifica se o cliente existe no repositório.
        if (clienteRepository.findById(id).orElse(null) == null) {
            return null;
        } else {
            // Define o ID do cliente e salva as alterações .
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
    }

    // Exclui um cliente por ID e desassocia os pedidos do cliente.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        // 1: Verifica se o cliente existe.
        Cliente cliente = clienteRepository.findById(id).orElse(null);

        if (cliente != null) {
            try {
                //  2: Desassocia o cliente dos pedidos.
                List<Pedido> pedidos = cliente.getPedido();
                for (Pedido pedido : pedidos) {
                    pedido.setCliente(null);
                }

                //  3: Exclui o cliente do repositório.
                clienteRepository.delete(cliente);

                // Passo 4: Retorna uma resposta com código 204 (No Content) e corpo vazio para indicar exclusao com sucesso.
               
                return ResponseEntity.noContent().build();

            } catch (Exception e) {
                
                // Passo 2b: Se ocorrer uma exceção inesperada, retorne um código de status 500
                // (Internal Server Error).
                return ResponseEntity.status(500).build();
            }
        } else {
            //  Se o cliente não for encontrado, retorne um código de status 404 (Not
            // Found).
            return ResponseEntity.notFound().build();
        }
    }
}