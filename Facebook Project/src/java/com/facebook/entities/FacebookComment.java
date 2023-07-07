/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author andil
 */
@Entity
@Table(name = "comment-tbl")
public class FacebookComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "comment")
    private String commentMessage;
    
    @Column(name = "comment_owner")
    private FacebookUser commentOwner;

    public FacebookComment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    public FacebookUser getCommentOwner() {
        return commentOwner;
    }

    public void setCommentOwner(FacebookUser commentOwner) {
        this.commentOwner = commentOwner;
    }
    
    
    
}
