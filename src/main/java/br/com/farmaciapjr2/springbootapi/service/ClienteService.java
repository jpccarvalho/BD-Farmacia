package br.com.farmaciapjr2.springbootapi.service;

import br.com.farmaciapjr2.springbootapi.entity.Cliente;
import br.com.farmaciapjr2.springbootapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }


    public List<Cliente> todosClientesOrdenadosPorNome() {
        return clienteRepository.todosClientesOrdenadosPorNome();
    }

    public List<Cliente> comprasMaiorQueMG() { return clienteRepository.comprasMaiorQueMG();}

    public List<Cliente> clientesPeloMenosUmaCompra(){ return clienteRepository.clientesPeloMenosUmaCompra();}

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> updateCliente(Long id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return Optional.of(clienteRepository.save(cliente));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}