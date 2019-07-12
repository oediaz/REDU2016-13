/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.susolabs.redu.modelo.facade;

import com.susolabs.redu.modelo.entidades.Ecografia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author t4nk
 */
@Stateless
public class EcografiaFacade extends AbstractFacade<Ecografia> {

    @PersistenceContext(unitName = "com.susolabs_redu_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EcografiaFacade() {
        super(Ecografia.class);
    }
    
}
