package com.scm.scm20.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SocialLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String link;
    private String title;

    @ManyToOne
    private Contact contact;

}
