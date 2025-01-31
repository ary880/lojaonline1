package com.lojaonline1.lojaonline2.controller;

import com.lojaonline1.lojaonline2.pagamento.Pagamento;
import com.lojaonline1.lojaonline2.pagamento.PagamentoRepository;
import com.lojaonline1.lojaonline2.pagamento.PagamentoRequestDTO;
import com.lojaonline1.lojaonline2.pagamento.PagamentoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoRepository repository;

    // Endpoint para salvar um pagamento
    @PostMapping
    public ResponseEntity<PagamentoResponseDTO> savePagamento(@RequestBody PagamentoRequestDTO data) {
        // Converte os dados de pagamento do DTO para a entidade Pagamento
        Pagamento pagamentoData = new Pagamento(data);
        // Salva o pagamento no banco de dados
        Pagamento pagamentoSalvo = repository.save(pagamentoData);
        // Cria o DTO de resposta
        PagamentoResponseDTO responseDTO = new PagamentoResponseDTO(pagamentoSalvo);

        // Retorna a resposta com o código HTTP 201 (Criado)
        return ResponseEntity.status(201).body(responseDTO);
    }

    // Endpoint para recuperar todos os pagamentos
    @GetMapping
    public List<PagamentoResponseDTO> getAll() {
        // Recupera todos os pagamentos do banco e os converte para o formato DTO
        List<PagamentoResponseDTO> pagamentoList = repository.findAll().stream()
                .map(PagamentoResponseDTO::new)
                .collect(Collectors.toList());  // Ajustado para versões de Java 8 ou anteriores
        return pagamentoList;
    }

    // Endpoint para excluir um pagamento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePagamento(@PathVariable Long id) {
        // Verifica se o pagamento existe
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404 se não encontrado
        }

        // Deleta o pagamento
        repository.deleteById(id);
        // Retorna 204 (Sem conteúdo) após a exclusão
        return ResponseEntity.noContent().build();
    }
}