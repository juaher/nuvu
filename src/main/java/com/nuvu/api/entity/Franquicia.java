/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nuvu.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juanh
 */
@Entity
@Table(name = "franquicia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Franquicia.findAll", query = "SELECT f FROM Franquicia f"),
    @NamedQuery(name = "Franquicia.findById", query = "SELECT f FROM Franquicia f WHERE f.id = :id"),
    @NamedQuery(name = "Franquicia.findByNombre", query = "SELECT f FROM Franquicia f WHERE f.nombre = :nombre")})
public class Franquicia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "franquiciaid")
    @JsonIgnore
    private List<Tarjetacredito> tarjetacreditoList;

    public Franquicia() {
    }

    public Franquicia(Long id) {
        this.id = id;
    }

    public Franquicia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Tarjetacredito> getTarjetacreditoList() {
        return tarjetacreditoList;
    }

    public void setTarjetacreditoList(List<Tarjetacredito> tarjetacreditoList) {
        this.tarjetacreditoList = tarjetacreditoList;
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
        if (!(object instanceof Franquicia)) {
            return false;
        }
        Franquicia other = (Franquicia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nuvu.api.entity.Franquicia[ id=" + id + " ]";
    }
    
}
