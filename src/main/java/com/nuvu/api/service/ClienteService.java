/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.service;

/**
 *
 * @author juanh
 */
import com.nuvu.api.entity.Cliente;
import java.util.List;


public interface ClienteService {
	public List<Cliente> findAllClientes();
	public Cliente findClienteById(Long id);
        public Cliente findClienteByDocumento(String documento);
	public Cliente save(Cliente cliente);
}
