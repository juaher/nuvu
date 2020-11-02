/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.repository;

import com.nuvu.api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juanh
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
     @Query(value = "select c from Cliente c where \n" +
"    c.documento = ?1")
    Cliente findByDocumento(String username);
}
