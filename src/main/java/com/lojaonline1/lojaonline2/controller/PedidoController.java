package com.lojaonline1.lojaonline2.controller;

import com.lojaonline1.lojaonline2.pedido.Pedido;
import com.lojaonline1.lojaonline2.pedido.PedidoRepository;
import com.lojaonline1.lojaonline2.pedido.PedidoRequestDTO;
import com.lojaonline1.lojaonline2.pedido.PedidoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<PedidoResponseDTO> saveProduto(@RequestBody PedidoRequestDTO data){
        Pedido pedidoData = new Pedido(data);  // Converte os dados para um objeto Pedido
        Pedido pedidoSalvo = repository.save(pedidoData);  // Salva o pedido no banco
        PedidoResponseDTO responseDTO = new PedidoResponseDTO(pedidoSalvo);  // Cria o DTO de resposta

        // Retorna a resposta com código HTTP 201 (Criado)
        return ResponseEntity.status(201).body(responseDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<PedidoResponseDTO> getAll(){
        List<PedidoResponseDTO> pedidoList = repository.findAll().stream()
                .map(PedidoResponseDTO::new)  // Converte cada pedido para PedidoResponseDTO
                .toList();
        return pedidoList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404 se o pedido não for encontrado
        }

        repository.deleteById(id);  // Deleta o pedido
        return ResponseEntity.noContent().build();  // Retorna 204 (Sem conteúdo) após a exclusão
    }
}
