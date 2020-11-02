/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.controllerImpl;

import com.nuvu.api.controller.TarjetacreditoController;
import com.nuvu.api.entity.Tarjetacredito;
import com.nuvu.api.model.TarjetacreditoModel;
import com.nuvu.api.service.TarjetacreditoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juanh
 */
@RestController
public class TarjetacreditoControllerImpl implements TarjetacreditoController {

    @Autowired
    TarjetacreditoService tarjetacreditoService;

    @Override
    @GetMapping(value = "/tarjetas/{clienteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tarjetacredito> tarjetacreditoByCliente(@PathVariable Long clienteId) {
        return tarjetacreditoService.findByCliente(clienteId);
    }

    @Override
    @PutMapping(value = "/tarjetas", produces = MediaType.APPLICATION_JSON_VALUE)
    public Tarjetacredito save(@RequestBody TarjetacreditoModel tarjetacredito) {
        Tarjetacredito tarjetacreditoExistente = tarjetacreditoService.findByNumero(tarjetacredito.getNumero());
        if (tarjetacreditoExistente != null) {
            return tarjetacreditoExistente;
        }
        return tarjetacreditoService.save(tarjetacredito);
    }

}
