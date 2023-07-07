/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.sessinbeans;

import com.facebook.entities.Reaction;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andil
 */
@Local
public interface ReactionFacadeLocal {

    void create(Reaction reaction);

    void edit(Reaction reaction);

    void remove(Reaction reaction);

    Reaction find(Object id);

    List<Reaction> findAll();

    List<Reaction> findRange(int[] range);

    int count();
    
}
