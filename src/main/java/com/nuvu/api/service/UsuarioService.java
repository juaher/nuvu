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
import com.nuvu.api.entity.Usuario;


public interface UsuarioService {
	public int existsByUsernameAndPassword(String username, String password);;
	public Usuario findByUsername(String username);
}
