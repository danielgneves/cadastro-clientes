package com.example.cadastro_clientes.service;

import com.example.cadastro_clientes.entity.Cliente;
import com.example.cadastro_clientes.repository.ClienteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvarCliente(Cliente cliente) {
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new RuntimeException("CPF já cadastrado");
        }
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes(Cliente cliente) {
        Sort sort = Sort.by("nome").ascending();
        return clienteRepository.findAll(sort);
    }

    public Cliente buscarCliente(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizarCliente(Long id, Cliente cliente) {
        Cliente clienteExistente = buscarCliente(id);
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setTelefone(cliente.getTelefone());
        return clienteRepository.save(clienteExistente);
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
