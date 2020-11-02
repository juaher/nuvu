/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.controllerImpl;

import com.nuvu.api.controller.ClienteController;
import com.nuvu.api.entity.Cliente;
import com.nuvu.api.entity.Usuario;
import com.nuvu.api.model.ClienteModel;
import com.nuvu.api.service.ClienteService;
import com.nuvu.api.service.UsuarioService;
import com.nuvu.security.jwt.JWTAuthorizationFilter;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juanh
 */
@RestController
public class ClienteControllerImpl implements ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/clientes/test")
    public String hello() {
        return "hello World";
    }

    @Override
    //@RequestMapping(value="all", method = RequestMethod.GET)
    @GetMapping("/clientes")
    public List<Cliente> clientes() {
        return clienteService.findAllClientes();
    }

    @Override
    //@RequestMapping(value = "search/{id}", method = RequestMethod.GET, produces = "application/json")
    @GetMapping(value = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente cliente(@PathVariable Long id) {
        return clienteService.findClienteById(id);
    }

    @Override
    //@RequestMapping(value = "add", method = RequestMethod.POST, produces = "application/json")
    @PutMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente save(@RequestBody ClienteModel cliente, @RequestHeader(value = "Authorization") String token) {
        Cliente clienteExistente = clienteService.findClienteByDocumento(cliente.getDocumento());
        if (clienteExistente != null) {
            return clienteExistente;
        }
        String username = JWTAuthorizationFilter.getUserNameByToken(token);
        Usuario usuario = usuarioService.findByUsername(username);
        return clienteService.save(cliente, usuario);
    }

}
