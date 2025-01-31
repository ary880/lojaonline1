package com.lojaonline1.lojaonline2.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;  // Importando a anotação Lombok

@Entity
@Data  // Lombok irá gerar automaticamente os métodos getters, setters, equals(), hashCode(), e toString()
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String image;

    private Integer price;

    // Construtor padrão para o JPA
    public Produto() {}

    // Construtor para criar um Produto a partir de um ProdutoRequestDTO
    public Produto(ProdutoRequestDTO data) {
        this.image = data.getImage();  // Corrigido para usar os métodos getImage()
        this.price = data.getPrice();  // Corrigido para usar os métodos getPrice()
        this.title = data.getTitle();  // Corrigido para usar os métodos getTitle()
    }
}
