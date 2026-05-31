package com.cibertec.mspedidos.repository;

import com.cibertec.mspedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {

}
