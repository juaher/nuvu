/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.controller;

import com.nuvu.api.entity.Usuario;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author juanh
 */

public interface UserController {

    public ResponseEntity<?> login(Usuario usuario);
    public String logout();

}
