package com.cibertec.mspedidos.controller;

import com.cibertec.mspedidos.model.Pedido;
import com.cibertec.mspedidos.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
        System.out.printf("Hola %s, tienes %d mensajes%n", "Luis", 5);
    }

    @GetMapping
    public List<Pedido> listar() {
        System.out.println("ENTRANDO AL ENDPOINT LISTAR");
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Pedido obtener(@PathVariable Integer id) {
        return pedidoService.obtenerPorId(id);
    }

    @PostMapping
    public Pedido guardar(@RequestBody Pedido pedido){
        return pedidoService.guardar(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        pedidoService.eliminar(id);
    }

}
