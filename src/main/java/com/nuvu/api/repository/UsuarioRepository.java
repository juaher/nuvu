/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.repository;

import com.nuvu.api.entity.Cliente;
import com.nuvu.api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juanh
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select count(1) from usuario u where \n" +
"    u.username = ?1 AND u.password = ?2", nativeQuery = true)
    int existsByUsernameAndPassword(String username, String password);
    @Query(value = "select u from Usuario u where \n" +
"    u.username = ?1")
    Usuario findByUsername(String username);
}
