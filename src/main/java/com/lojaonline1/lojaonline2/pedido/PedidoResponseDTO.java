package com.lojaonline1.lojaonline2.pedido;

public record PedidoResponseDTO(Long id, String title, String image, Integer price, String email) {
    public PedidoResponseDTO(Pedido pedido) {
        this(pedido.getId(), pedido.getTitle(), pedido.getImage(), pedido.getPrice(), pedido.getEmail());
    }
}
