/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.serviceImpl;

import com.nuvu.api.entity.Cliente;
import com.nuvu.api.entity.Tarjetacredito;
import com.nuvu.api.repository.ClienteRepository;
import com.nuvu.api.repository.TarjetacreditoRepository;
import com.nuvu.api.service.ClienteService;
import com.nuvu.api.service.TarjetacreditoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author juanh
 */
@Service("clienteService")
public class TarjetacreditoServiceImpl implements TarjetacreditoService {
    
    @Autowired
    TarjetacreditoRepository tarjetacreditoRepository;
    
    @Override
    public List<Tarjetacredito> findByCliente(Long clienteId) {
        return tarjetacreditoRepository.findByCliente(clienteId);
    }
    
    @Override
    public Tarjetacredito save(Tarjetacredito tarjetacredito) {
        return tarjetacreditoRepository.save(tarjetacredito);
    }

    @Override
    public Tarjetacredito findByNumero(Long numero) {
        return tarjetacreditoRepository.findByNumero(numero);
    }
    
}
