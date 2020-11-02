/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juanh
 */
@Entity
@Table(name = "tarjetacredito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjetacredito.findAll", query = "SELECT t FROM Tarjetacredito t"),
    @NamedQuery(name = "Tarjetacredito.findById", query = "SELECT t FROM Tarjetacredito t WHERE t.id = :id"),
    @NamedQuery(name = "Tarjetacredito.findByNumero", query = "SELECT t FROM Tarjetacredito t WHERE t.numero = :numero"),
    @NamedQuery(name = "Tarjetacredito.findByFechavencimiento", query = "SELECT t FROM Tarjetacredito t WHERE t.fechavencimiento = :fechavencimiento"),
    @NamedQuery(name = "Tarjetacredito.findByCvv", query = "SELECT t FROM Tarjetacredito t WHERE t.cvv = :cvv")})
public class Tarjetacredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "numero")
    private long numero;
    @Basic(optional = false)
    @Column(name = "fechavencimiento")
    private String fechavencimiento;
    @JsonIgnore
    @Column(name = "cvv")
    private int cvv;
    @JoinColumn(name = "franquiciaid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Franquicia franquiciaid;
    @JoinColumn(name = "clienteid", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteid;

    public Tarjetacredito() {
    }

    public Tarjetacredito(Long id) {
        this.id = id;
    }

    public Tarjetacredito(Long id, long numero, String fechavencimiento) {
        this.id = id;
        this.numero = numero;
        this.fechavencimiento = fechavencimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getFechavencimiento() {
        return fechavencimiento;
    }

    public void setFechavencimiento(String fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Franquicia getFranquiciaid() {
        return franquiciaid;
    }

    public void setFranquiciaid(Franquicia franquiciaid) {
        this.franquiciaid = franquiciaid;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarjetacredito)) {
            return false;
        }
        Tarjetacredito other = (Tarjetacredito) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nuvu.api.entity.Tarjetacredito[ id=" + id + " ]";
    }
    
}
