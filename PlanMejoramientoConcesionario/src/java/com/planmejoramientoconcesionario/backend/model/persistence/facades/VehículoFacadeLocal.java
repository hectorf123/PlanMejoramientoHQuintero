/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planmejoramientoconcesionario.backend.model.persistence.facades;

import com.planmejoramientoconcesionario.backend.model.persistence.entities.Vehículo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juank
 */
@Local
public interface VehículoFacadeLocal {

    void create(Vehículo vehículo);

    void edit(Vehículo vehículo);

    void remove(Vehículo vehículo);

    Vehículo find(Object id);

    List<Vehículo> findAll();

    List<Vehículo> findRange(int[] range);

    int count();
    
}
