/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facebook.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

/**
 *
 * @author andil
 */
@Entity
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "post_cation")
    private String caption;
    
    @Lob
    @Column(name = "post_file")
    private byte[] postMedia;
    
    @Column(name = "profile_picture")
    private boolean isProfilePicture;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_comments",joinColumns = @JoinColumn(name = "post_id"),inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private List<FacebookComment> postComments;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "post_likes",joinColumns = @JoinColumn(name = "post_id"),inverseJoinColumns = @JoinColumn(name = "like_id"))
    private List<Reaction> postlikes;
    
    
    
    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public byte[] getPostMedia() {
        return postMedia;
    }

    public void setPostMedia(byte[] postMedia) {
        this.postMedia = postMedia;
    }

    public boolean isIsProfilePicture() {
        return isProfilePicture;
    }

    public void setIsProfilePicture(boolean isProfilePicture) {
        this.isProfilePicture = isProfilePicture;
    }

    public List<FacebookComment> getPostComments() {
        return postComments;
    }

    public void setPostComments(List<FacebookComment> postComments) {
        this.postComments = postComments;
    }

    public List<Reaction> getPostlikes() {
        return postlikes;
    }

    public void setPostlikes(List<Reaction> postlikes) {
        this.postlikes = postlikes;
    }
    
    
}
