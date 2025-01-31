package com.lojaonline1.lojaonline2.cliente;

import com.lojaonline1.lojaonline2.pedido.Pedido;

public record ClienteResponseDTO(String nome, String cpf, String email, String telefone, String endereco) {
    public ClienteResponseDTO(Cliente cliente) {
        this(cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco());
    }
}
