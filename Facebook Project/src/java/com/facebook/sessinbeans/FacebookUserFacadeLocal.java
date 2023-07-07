/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.sessinbeans;

import com.facebook.entities.FacebookUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andil
 */
@Local
public interface FacebookUserFacadeLocal {

    void create(FacebookUser facebookUser);

    void edit(FacebookUser facebookUser);

    void remove(FacebookUser facebookUser);

    FacebookUser find(Object id);

    List<FacebookUser> findAll();

    List<FacebookUser> findRange(int[] range);

    int count();
    
}
