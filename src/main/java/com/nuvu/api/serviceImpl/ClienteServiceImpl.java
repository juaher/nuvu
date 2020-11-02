/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.serviceImpl;

import com.nuvu.api.entity.Cliente;
import com.nuvu.api.entity.Usuario;
import com.nuvu.api.model.ClienteModel;
import com.nuvu.api.repository.ClienteRepository;
import com.nuvu.api.service.ClienteService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author juanh
 */
@Service()
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findClienteById(Long id) {
        Optional<Cliente> respuesta = clienteRepository.findById(id);
        Cliente cliente = null;
        if (respuesta.isPresent()) {
            cliente = respuesta.get();
        }
        return cliente;
    }

    @Override
    public Cliente findClienteByDocumento(String documento) {
        Cliente cliente = clienteRepository.findByDocumento(documento);
        return cliente;
    }

    @Override
    @Transactional
    public Cliente save(ClienteModel cliente, Usuario usuario) {
        Date today = Calendar.getInstance().getTime();
        Long clienteId = cliente.getId();
        Cliente clienteEntity = new Cliente();
        clienteEntity.setUsuariocreacion(usuario);
        if (clienteId != null) {
            Optional<Cliente> respuesta = clienteRepository.findById(clienteId);
            if (respuesta.isPresent()) {
                clienteEntity = respuesta.get();
            } 
        }
        clienteEntity.setDocumento(cliente.getDocumento());
        clienteEntity.setCelular(cliente.getCelular());
        clienteEntity.setNombres(cliente.getNombres());
        clienteEntity.setApellidos(cliente.getApellidos());
        clienteEntity.setEmail(cliente.getEmail());
        clienteEntity.setUsuariomodificacion(usuario);
        clienteEntity.setFechamodificacion(today);
        return clienteRepository.save(clienteEntity);
    }

}
