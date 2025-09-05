package com.labo_academy.gestion_bibliotheque.repository;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

}
