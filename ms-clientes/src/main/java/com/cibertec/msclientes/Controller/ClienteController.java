package com.cibertec.msclientes.Controller;

import com.cibertec.msclientes.Model.Cliente;
import com.cibertec.msclientes.Repository.ClienteRepository;
import com.cibertec.msclientes.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    @Autowired
    private ClienteRepository repository;

    // Listar todos los clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return repository.findAll();
    }

    // Buscar cliente por ID
    @GetMapping("/{id}")
    public Optional<Cliente> buscarCliente(@PathVariable Integer id) {
        return repository.findById(id);
    }

    // Registrar cliente
    @PostMapping
    public Cliente registrarCliente(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    // Actualizar cliente
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Integer id,
                                     @RequestBody Cliente clienteActualizado) {

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        cliente.setNombres(clienteActualizado.getNombres());
        cliente.setApellidos(clienteActualizado.getApellidos());
        cliente.setDni(clienteActualizado.getDni());
        cliente.setTelefono(clienteActualizado.getTelefono());
        cliente.setCorreo(clienteActualizado.getCorreo());
        cliente.setDireccion(clienteActualizado.getDireccion());
        cliente.setEstado(clienteActualizado.getEstado());

        return repository.save(cliente);
    }

    // Eliminar cliente
    @DeleteMapping("/{id}")
    public String eliminarCliente(@PathVariable Integer id) {

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        repository.delete(cliente);

        return "Cliente eliminado correctamente";
    }
}
