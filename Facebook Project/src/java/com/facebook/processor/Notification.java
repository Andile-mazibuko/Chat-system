/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.processor;

/**
 *
 * @author andil
 */
public class Notification {
    private String firstname;
    private String lastname;
    private long ownerId;
    private int numberOfdays;
    
    public Notification() {
    }

    public Notification(String firstname, String lastname, long ownerId, int numberOfdays) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.ownerId = ownerId;
        this.numberOfdays = numberOfdays;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getNumberOfdays() {
        return numberOfdays;
    }

    public void setNumberOfdays(int numberOfdays) {
        this.numberOfdays = numberOfdays;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
    
    
    
}
