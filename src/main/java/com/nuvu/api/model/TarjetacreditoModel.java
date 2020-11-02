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
public class TarjetacreditoModel implements Serializable{
    private Long id;
    private Long numero;
    private String fechavencimiento;
    private int cvv;
    private Long franquiciaid;
    private Long clienteid;

    public TarjetacreditoModel() {
    }
    

    public TarjetacreditoModel(Long id, Long numero, String fechavencimiento, Long franquiciaid, int cvv) {
        this.id = id;
        this.numero = numero;
        this.fechavencimiento = fechavencimiento;
        this.cvv = cvv;
        this.franquiciaid = franquiciaid;
        this.cvv = cvv;
    }

    public Long getId() {
        return id;
    }
    
    public Long getClienteid() {
        return clienteid;
    }

    public int getCvv() {
        return cvv;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public Long getFranquiciaid() {
        return franquiciaid;
    }

    public long getNumero() {
        return numero;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setClienteid(Long clienteid) {
        this.clienteid = clienteid;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public void setFranquiciaid(Long franquiciaid) {
        this.franquiciaid = franquiciaid;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
    
    
    
}
