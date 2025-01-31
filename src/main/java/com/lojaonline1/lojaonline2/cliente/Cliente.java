package com.lojaonline1.lojaonline2.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cliente")  // Alterei para "cliente", pois é sobre cliente agora
@Entity(name = "cliente")  // Alterei para "cliente", para refletir o nome da entidade
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {  // Alterei o nome da classe para Cliente

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private String endereco;


    // Construtor que recebe o DTO ClienteRequestDTO
    public Cliente(ClienteRequestDTO data){
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.email = data.email();
        this.telefone = data.telefone();
        this.endereco = data.endereco();
    }
}
