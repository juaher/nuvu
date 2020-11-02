/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.model;

import java.io.Serializable;

/**
 *
 * @author juanh
 */
public class ClienteModel implements Serializable{
    private Long id;
    private String documento;
    private String nombres;
    private String apellidos;
    private Long celular;
    private String email;

    public ClienteModel() {
    }

    public ClienteModel(Long id, String documento, String nombres, String apellidos,
            long celular, String email) {
        this.id = id;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Long getCelular() {
        return celular;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

}
