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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "veh\u00edculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veh\u00edculo.findAll", query = "SELECT v FROM Veh\u00edculo v")
    , @NamedQuery(name = "Veh\u00edculo.findByIdVehiculo", query = "SELECT v FROM Veh\u00edculo v WHERE v.idVehiculo = :idVehiculo")
    , @NamedQuery(name = "Veh\u00edculo.findByMarca", query = "SELECT v FROM Veh\u00edculo v WHERE v.marca = :marca")
    , @NamedQuery(name = "Veh\u00edculo.findByModelo", query = "SELECT v FROM Veh\u00edculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Veh\u00edculo.findByPrecio", query = "SELECT v FROM Veh\u00edculo v WHERE v.precio = :precio")})
public class Vehículo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdVehiculo")
    private Integer idVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Marca")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private double precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiculo")
    private Collection<Venta> ventaCollection;
    @JoinColumn(name = "idConcesionario", referencedColumnName = "Nit")
    @ManyToOne(optional = false)
    private Concesionario idConcesionario;

    public Vehículo() {
    }

    public Vehículo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Vehículo(Integer idVehiculo, String marca, String modelo, double precio) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @XmlTransient
    public Collection<Venta> getVentaCollection() {
        return ventaCollection;
    }

    public void setVentaCollection(Collection<Venta> ventaCollection) {
        this.ventaCollection = ventaCollection;
    }

    public Concesionario getIdConcesionario() {
        return idConcesionario;
    }

    public void setIdConcesionario(Concesionario idConcesionario) {
        this.idConcesionario = idConcesionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiculo != null ? idVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehículo)) {
            return false;
        }
        Vehículo other = (Vehículo) object;
        if ((this.idVehiculo == null && other.idVehiculo != null) || (this.idVehiculo != null && !this.idVehiculo.equals(other.idVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planmejoramientoconcesionario.backend.persistence.entities.Veh\u00edculo[ idVehiculo=" + idVehiculo + " ]";
    }
    
}
