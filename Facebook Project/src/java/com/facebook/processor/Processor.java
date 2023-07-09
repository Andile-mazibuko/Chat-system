/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.processor;

import javax.ejb.Stateless;

/**
 *
 * @author andil
 */
@Stateless
public class Processor implements ProcessorLocal{

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

    
}
