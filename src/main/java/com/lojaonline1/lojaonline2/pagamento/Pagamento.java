package com.lojaonline1.lojaonline2.pagamento;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pagamento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCartao;

    private String nomeTitular;

    private String dataValidade;

    private String codigoSeguranca;

    private Double valor;

    // Construtor que recebe os dados do DTO
    public Pagamento(PagamentoRequestDTO data) {
        this.numeroCartao = data.numeroCartao();
        this.nomeTitular = data.nomeTitular();
        this.dataValidade = data.dataValidade();
        this.codigoSeguranca = data.codigoSeguranca();
        this.valor = data.valor();
    }

    // Método getStatus que retorna o status do pagamento
    public String getStatus() {
        // Logica simples para determinar o status, como exemplo.
        // Pode ser modificado conforme os requisitos (ex: se o valor for maior que 0, considerado como pago)
        if (this.valor > 0) {
            return "Pago";
        } else {
            return "Pendente";
        }
    }
}
