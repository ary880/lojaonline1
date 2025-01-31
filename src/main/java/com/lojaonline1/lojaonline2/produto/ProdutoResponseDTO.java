package com.lojaonline1.lojaonline2.produto;

import com.lojaonline1.lojaonline2.produto.Produto;

public record ProdutoResponseDTO(Long id, String title, String image, Integer price) {

    // Construtor para criar ProdutoResponseDTO a partir de um objeto Produto
    public ProdutoResponseDTO(Produto produto) {
        this(produto.getId(), produto.getTitle(), produto.getImage(), produto.getPrice());
    }
}
