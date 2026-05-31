package com.cibertec.mspedidos.service;

import com.cibertec.mspedidos.model.Pedido;
import com.cibertec.mspedidos.repository.IPedidoRepository;
import org.springframework.stereotype.Service;
import com.cibertec.mspedidos.service.PedidoService;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final IPedidoRepository iPedidoRepository;

    public PedidoServiceImpl(IPedidoRepository iPedidoRepository) {
        this.iPedidoRepository = iPedidoRepository;
    }

    @Override
    public List<Pedido> listarTodos(){
        return iPedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPorId(Integer id) {
        return iPedidoRepository.findById(id).
                orElseThrow(()-> new RuntimeException("pedido no encontrado"));
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        return iPedidoRepository.save(pedido);
    }

    @Override
    public void eliminar(Integer id) {
    iPedidoRepository.deleteById(id);
    }


}
