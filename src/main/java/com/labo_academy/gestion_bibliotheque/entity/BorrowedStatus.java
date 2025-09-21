package com.labo_academy.gestion_bibliotheque.entity;

// Enum qui définit les différents états possibles d'un emprunt
public enum BorrowedStatus {
    IN_PROGRESS, // L’emprunt est en cours
    RETURNED,    // Le document a été rendu
    LATE         // L’emprunt est en retard
}
