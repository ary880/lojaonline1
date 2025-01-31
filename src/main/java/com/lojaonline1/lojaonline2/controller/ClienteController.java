package com.lojaonline1.lojaonline2.controller;

import com.lojaonline1.lojaonline2.cliente.Cliente;
import com.lojaonline1.lojaonline2.cliente.ClienteRepository;
import com.lojaonline1.lojaonline2.cliente.ClienteResponseDTO;
import com.lojaonline1.lojaonline2.cliente.ClienteRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> saveCliente(@RequestBody ClienteRequestDTO data) {
        Cliente clienteData = new Cliente(data);  // Converte os dados para um objeto Cliente
        Cliente clienteSalvo = repository.save(clienteData);  // Salva o cliente no banco
        ClienteResponseDTO responseDTO = new ClienteResponseDTO(clienteSalvo);  // Cria o DTO de resposta

        // Retorna a resposta com código HTTP 201 (Criado)
        return ResponseEntity.status(201).body(responseDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ClienteResponseDTO> getAll() {
        List<ClienteResponseDTO> clienteList = repository.findAll().stream()
                .map(ClienteResponseDTO::new)  // Converte cada cliente para ClienteResponseDTO
                .toList();
        return clienteList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404 se o cliente não for encontrado
        }

        repository.deleteById(id);  // Deleta o cliente
        return ResponseEntity.noContent().build();  // Retorna 204 (Sem conteúdo) após a exclusão
    }
}
