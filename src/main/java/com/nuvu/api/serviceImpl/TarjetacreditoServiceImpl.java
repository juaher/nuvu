/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.serviceImpl;

import com.nuvu.api.entity.Cliente;
import com.nuvu.api.entity.Franquicia;
import com.nuvu.api.entity.Tarjetacredito;
import com.nuvu.api.model.TarjetacreditoModel;
import com.nuvu.api.repository.ClienteRepository;
import com.nuvu.api.repository.TarjetacreditoRepository;
import com.nuvu.api.service.ClienteService;
import com.nuvu.api.service.TarjetacreditoService;
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
@Service
public class TarjetacreditoServiceImpl implements TarjetacreditoService {
    
    @Autowired
    TarjetacreditoRepository tarjetacreditoRepository;
    
    @Override
    public List<Tarjetacredito> findByCliente(Long clienteId) {
        return tarjetacreditoRepository.findByCliente(clienteId);
    }
    
    @Override
    public Tarjetacredito save(TarjetacreditoModel tarjetacredito) {
        Long tarjetaId = tarjetacredito.getId();
        Tarjetacredito tarjetaEntity = new Tarjetacredito();
        if (tarjetaId != null) {
            Optional<Tarjetacredito> respuesta = tarjetacreditoRepository.findById(tarjetaId);
            if (respuesta.isPresent()) {
                tarjetaEntity = respuesta.get();
            } 
        }
        tarjetaEntity.setCvv(tarjetacredito.getCvv());
        tarjetaEntity.setFechavencimiento(tarjetacredito.getFechavencimiento());
        tarjetaEntity.setNumero(tarjetacredito.getNumero());
        tarjetaEntity.setClienteid(new Cliente(tarjetacredito.getClienteid()));
        tarjetaEntity.setFranquiciaid(new Franquicia(tarjetacredito.getFranquiciaid()));
        tarjetaEntity.setClienteid(new Cliente(tarjetacredito.getClienteid()));
        return tarjetacreditoRepository.saveAndFlush(tarjetaEntity);
    }

    @Override
    public Tarjetacredito findByNumero(Long numero) {
        return tarjetacreditoRepository.findByNumero(numero);
    }
    
}
