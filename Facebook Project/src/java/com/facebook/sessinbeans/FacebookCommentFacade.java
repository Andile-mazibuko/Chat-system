/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.sessinbeans;

import com.facebook.entities.FacebookComment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andil
 */
@Stateless
public class FacebookCommentFacade extends AbstractFacade<FacebookComment> implements FacebookCommentFacadeLocal {

    @PersistenceContext(unitName = "Facebook_ProjectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacebookCommentFacade() {
        super(FacebookComment.class);
    }
    
}
