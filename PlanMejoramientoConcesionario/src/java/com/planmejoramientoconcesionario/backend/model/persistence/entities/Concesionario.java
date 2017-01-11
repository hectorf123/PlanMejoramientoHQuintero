/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planmejoramientoconcesionario.backend.model.persistence.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "concesionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concesionario.findAll", query = "SELECT c FROM Concesionario c")
    , @NamedQuery(name = "Concesionario.findByNit", query = "SELECT c FROM Concesionario c WHERE c.nit = :nit")
    , @NamedQuery(name = "Concesionario.findByNombre", query = "SELECT c FROM Concesionario c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Concesionario.findByTel\u00e9fono", query = "SELECT c FROM Concesionario c WHERE c.tel\u00e9fono = :tel\u00e9fono")
    , @NamedQuery(name = "Concesionario.findByDirecci\u00f3n", query = "SELECT c FROM Concesionario c WHERE c.direcci\u00f3n = :direcci\u00f3n")})
public class Concesionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Nit")
    private Integer nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Tel\u00e9fono")
    private String teléfono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "Direcci\u00f3n")
    private String dirección;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConcesionario")
    private Collection<Vehículo> vehículoCollection;

    public Concesionario() {
    }

    public Concesionario(Integer nit) {
        this.nit = nit;
    }

    public Concesionario(Integer nit, String nombre, String teléfono, String dirección) {
        this.nit = nit;
        this.nombre = nombre;
        this.teléfono = teléfono;
        this.dirección = dirección;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    @XmlTransient
    public Collection<Vehículo> getVehículoCollection() {
        return vehículoCollection;
    }

    public void setVehículoCollection(Collection<Vehículo> vehículoCollection) {
        this.vehículoCollection = vehículoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concesionario)) {
            return false;
        }
        Concesionario other = (Concesionario) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planmejoramientoconcesionario.backend.persistence.entities.Concesionario[ nit=" + nit + " ]";
    }
    
}
