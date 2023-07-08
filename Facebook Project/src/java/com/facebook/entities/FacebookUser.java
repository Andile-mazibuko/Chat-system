/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author andil
 */

@Entity
public class FacebookUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "dateof_bith")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    
    @Column(name = "gender")
    private String gender;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_friend", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<Friend> friends;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_post", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "post_id"))
    private List<Post> posts;
    @Column(name = "email_address")
    private String emailAdddress;
    
    @Column(name = "cellphone_number")
    private Long cellphoneNumber;
    
    @Column(name = "user_password")
    private String password;
    
    @Column(name = "user_address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_messege", joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "msg_id"))
    private List<FacebookMessage> messages;

    public FacebookUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getEmailAdddress() {
        return emailAdddress;
    }

    public void setEmailAdddress(String emailAdddress) {
        this.emailAdddress = emailAdddress;
    }

    public Long getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(Long cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<FacebookMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<FacebookMessage> messages) {
        this.messages = messages;
    }
    
    
}
