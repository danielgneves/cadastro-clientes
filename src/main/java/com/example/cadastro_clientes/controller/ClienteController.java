package com.example.cadastro_clientes.controller;

import com.example.cadastro_clientes.entity.Cliente;
import com.example.cadastro_clientes.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public void salvarCliente(@RequestBody Cliente cliente) {
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
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
    }
}
