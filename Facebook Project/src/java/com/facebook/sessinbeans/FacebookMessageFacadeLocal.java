/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.sessinbeans;

import com.facebook.entities.FacebookMessage;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andil
 */
@Local
public interface FacebookMessageFacadeLocal {

    void create(FacebookMessage facebookMessage);

    void edit(FacebookMessage facebookMessage);

    void remove(FacebookMessage facebookMessage);

    FacebookMessage find(Object id);

    List<FacebookMessage> findAll();

    List<FacebookMessage> findRange(int[] range);

    int count();
    
}
