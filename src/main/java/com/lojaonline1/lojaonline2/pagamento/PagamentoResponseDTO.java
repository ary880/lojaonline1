package com.lojaonline1.lojaonline2.pagamento;

public record PagamentoResponseDTO(
        Long id,
        String status,
        Double valor,
        String numeroCartao,
        String nomeTitular
) {
    public PagamentoResponseDTO(Pagamento pagamento) {
        this(
                pagamento.getId(),
                pagamento.getStatus(),
                pagamento.getValor(),
                pagamento.getNumeroCartao(),
                pagamento.getNomeTitular()
        );
    }
}
