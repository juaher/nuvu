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
import com.nuvu.api.entity.Tarjetacredito;
import com.nuvu.api.model.TarjetacreditoModel;
import java.util.List;


public interface TarjetacreditoService {
	public List<Tarjetacredito> findByCliente(Long clienteId);
        public Tarjetacredito findByNumero(Long numero);
        public Tarjetacredito save(TarjetacreditoModel tarjetacredito);
}
