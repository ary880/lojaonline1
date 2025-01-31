package com.lojaonline1.lojaonline2.controller;

import com.lojaonline1.lojaonline2.pedido.Pedido;
import com.lojaonline1.lojaonline2.pedido.PedidoRepository;
import com.lojaonline1.lojaonline2.pedido.PedidoRequestDTO;
import com.lojaonline1.lojaonline2.pedido.PedidoResponseDTO;
import com.lojaonline1.lojaonline2.produto.Produto;
import com.lojaonline1.lojaonline2.produto.ProdutoRepository;
import com.lojaonline1.lojaonline2.produto.ProdutoRequestDTO;
import com.lojaonline1.lojaonline2.produto.ProdutoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController{

    @Autowired
    private ProdutoRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> saveProduto(@RequestBody ProdutoRequestDTO data){
        Produto produtoData = new Produto(data);  // Converte os dados para um objeto Produto
        Produto produtoSalvo = repository.save(produtoData);  // Salva o produto no banco
        ProdutoResponseDTO responseDTO = new ProdutoResponseDTO(produtoSalvo);  // Cria o DTO de resposta

        // Retorna a resposta com código HTTP 201 (Criado)
        return ResponseEntity.status(201).body(responseDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ProdutoResponseDTO> getAll(){
        List<ProdutoResponseDTO> produtoList = repository.findAll().stream()
                .map(ProdutoResponseDTO::new)  // Converte cada produto para ProdutoResponseDTO
                .toList();
        return produtoList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();  // Retorna 404 se o produto não for encontrado
        }

        repository.deleteById(id);  // Deleta o produto
        return ResponseEntity.noContent().build();  // Retorna 204 (Sem conteúdo) após a exclusão
    }
}

