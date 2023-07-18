/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.processor;

import com.facebook.entities.FacebookUser;
import com.facebook.entities.Friend;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author andil
 */
@Local
public interface ProcessorLocal {
     
    boolean isCellphoneNumber(String mobileOrCellphone);
    List<FacebookUser> findMatchingUsers(String emailOrPassword);
    FacebookUser findCorrectUser(List<FacebookUser>matchingUsers, String password); 
    Friend createFacebookFriendship(Long user,Long friendId);
    //new searching algorithm
    List<FacebookUser> searchForUsers(String search);
}
