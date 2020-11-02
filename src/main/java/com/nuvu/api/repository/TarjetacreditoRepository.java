/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.repository;

import com.nuvu.api.entity.Cliente;
import com.nuvu.api.entity.Tarjetacredito;
import com.nuvu.api.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juanh
 */
@Repository
public interface TarjetacreditoRepository extends JpaRepository<Tarjetacredito, Long> {
    @Query(value = "select t from Tarjetacredito t where t.clienteid.id = ?1")
    List<Tarjetacredito> findByCliente(Long clienteId);
    @Query(value = "select t from Tarjetacredito t where t.numero = ?1")
    Tarjetacredito findByNumero(Long numero);
}
