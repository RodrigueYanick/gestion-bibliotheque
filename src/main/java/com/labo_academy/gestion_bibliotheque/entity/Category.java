package com.labo_academy.gestion_bibliotheque.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//creation de la table category
@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(nullable = false, length = 50)  // le nom de la category
    private String name;
    @Column(nullable = false, length = 250)  // la description de la category
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")  // la relation entre la category et plusieur documents
    private List<Document> documents;

}
