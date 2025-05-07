package com.example.cadastro_clientes.controller;

import com.example.cadastro_clientes.entity.Cliente;
import com.example.cadastro_clientes.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public void salvarCliente(@Valid @RequestBody Cliente cliente) {
        clienteService.salvarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes(Cliente cliente) {
        return clienteService.listarClientes(cliente);
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Long id) {
        return clienteService.buscarCliente(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
        return ResponseEntity.ok("Cliente com ID " + id + " excluído com sucesso!");
    }
}
