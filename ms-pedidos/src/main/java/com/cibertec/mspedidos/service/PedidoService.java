package com.cibertec.mspedidos.service;

import com.cibertec.mspedidos.model.Pedido;
import java.util.List;

public interface PedidoService {

    List<Pedido> listarTodos();

    Pedido obtenerPorId(Integer id);

    Pedido guardar(Pedido Pedido);

    void eliminar(Integer id);



}
