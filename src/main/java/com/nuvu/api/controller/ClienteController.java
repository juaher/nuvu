/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.controller;

import com.nuvu.api.entity.Cliente;
import java.util.List;

/**
 *
 * @author juanh
 */

public interface ClienteController {

    public List<Cliente> clientes();

    public Cliente cliente(Long id);

    public Cliente save(Cliente cliente, String token);
    
     

}
