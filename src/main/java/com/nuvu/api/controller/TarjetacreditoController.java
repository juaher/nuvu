/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.controller;

import com.nuvu.api.entity.Cliente;
import com.nuvu.api.entity.Tarjetacredito;
import java.util.List;

/**
 *
 * @author juanh
 */

public interface TarjetacreditoController {

    public List<Tarjetacredito> tarjetacreditoByCliente(Long clienteId);
    public Tarjetacredito save(Tarjetacredito tarjetacredito);

}
