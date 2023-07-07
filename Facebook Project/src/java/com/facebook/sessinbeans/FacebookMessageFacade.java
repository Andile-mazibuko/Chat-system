/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.sessinbeans;

import com.facebook.entities.FacebookMessage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andil
 */
@Stateless
public class FacebookMessageFacade extends AbstractFacade<FacebookMessage> implements FacebookMessageFacadeLocal {

    @PersistenceContext(unitName = "Facebook_ProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacebookMessageFacade() {
        super(FacebookMessage.class);
    }
    
}
