/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.sessinbeans;

import com.facebook.entities.FacebookComment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andil
 */
@Local
public interface FacebookCommentFacadeLocal {

    void create(FacebookComment facebookComment);

    void edit(FacebookComment facebookComment);

    void remove(FacebookComment facebookComment);

    FacebookComment find(Object id);

    List<FacebookComment> findAll();

    List<FacebookComment> findRange(int[] range);

    int count();
    
}
