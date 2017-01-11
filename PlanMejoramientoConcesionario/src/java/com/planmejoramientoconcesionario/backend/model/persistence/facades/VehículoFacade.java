/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planmejoramientoconcesionario.backend.model.persistence.facades;

import com.planmejoramientoconcesionario.backend.model.persistence.entities.Vehículo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juank
 */
@Stateless
public class VehículoFacade extends AbstractFacade<Vehículo> implements VehículoFacadeLocal {

    @PersistenceContext(unitName = "PlanMejoramientoConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehículoFacade() {
        super(Vehículo.class);
    }
    
}
