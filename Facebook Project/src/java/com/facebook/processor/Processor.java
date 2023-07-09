/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.processor;

import com.facebook.entities.FacebookUser;
import com.facebook.sessinbeans.FacebookUserFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author andil
 */
@Stateless
public class Processor implements ProcessorLocal{

    @EJB
    private FacebookUserFacadeLocal facebookUserFacade;

    @Override
    public boolean isCellphoneNumber(String mobileOrCellphone) 
    {
        boolean isCellNo = false;
        
        int length = mobileOrCellphone.length();
        if(mobileOrCellphone.length() == 10)
        {
            for(int i = 0; i < length; i++)
            {
                if(Character.isDigit(mobileOrCellphone.charAt(i)))
                {
                    isCellNo = true;
                }
                else
                {
                    isCellNo = false;
                    break;
                }
            }
        }else
        {
            isCellNo = false;
        }
        
        return isCellNo;
    
    }
    public List<FacebookUser> findMatchingUsers(String emailOrPassword)
    {
        List<FacebookUser> allUsers = facebookUserFacade.findAll();
        List<FacebookUser> matchingAccounts = new ArrayList<>();
        
        
            for(FacebookUser facebookUser : allUsers)
            {
                if(isCellphoneNumber(emailOrPassword) && facebookUser.getCellphoneNumber() != null && facebookUser.getCellphoneNumber().equals(Long.parseLong(emailOrPassword)))
                {
                    matchingAccounts.add(facebookUser);
                }else if(facebookUser.getEmailAdddress() != null && !isCellphoneNumber(emailOrPassword))
                {
                    matchingAccounts.add(facebookUser);
                }
                
            }
        return matchingAccounts;
    }
    public FacebookUser findCorrectUser(List<FacebookUser>matchingUsers, String password)
    {
        FacebookUser user = new FacebookUser();
        for(FacebookUser facebookUser : matchingUsers)
        {
            if(facebookUser.getPassword().equals(password))
            {
                user = facebookUser;
                break;
            }
            
        }
        return user;
    }
    
    
}
