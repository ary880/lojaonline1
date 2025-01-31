package com.lojaonline1.lojaonline2.pagamento;

public record PagamentoRequestDTO(
        String numeroCartao,
        String nomeTitular,
        String dataValidade,
        String codigoSeguranca,
        Double valor
){}