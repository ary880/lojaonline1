package com.lojaonline1.lojaonline2.pedido;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pedido")
@Entity(name = "pedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String title;

    private String image;

    private Integer price;

    private String email;


    public Pedido(PedidoRequestDTO data){
        this.image = data.image();

        this.price = data.price();

        this.title = data.title();

        this.email = data.email();
    }
}
