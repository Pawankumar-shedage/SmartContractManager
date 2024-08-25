package com.scm.scm20.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Contact {

    @Id
    private String id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String picture;
    @Column(length = 8000)
    private String description;
    private boolean isFavourite = false;
    private String websiteLink;
    private String linkedInLink;

    //Group of social media links
    @OneToMany(mappedBy = "contact",cascade=CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<SocialLink> socialLinks = new ArrayList<>();

    //Many to one : mapping, one user can have multiple contacts, BUT one contact cant have many users.
    @ManyToOne
    private User user;

}
