package com.lojaonline1.lojaonline2.produto;

public class ProdutoRequestDTO {

    private String title;
    private String image;
    private Integer price;

    // Construtor com parâmetros
    public ProdutoRequestDTO(String title, String image, Integer price) {
        this.title = title;
        this.image = image;
        this.price = price;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Integer getPrice() {
        return price;
    }
}
