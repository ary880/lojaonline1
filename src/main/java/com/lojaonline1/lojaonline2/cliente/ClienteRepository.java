package com.lojaonline1.lojaonline2.cliente;

import com.lojaonline1.lojaonline2.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
