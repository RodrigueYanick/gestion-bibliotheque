package com.labo_academy.gestion_bibliotheque.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rendre")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Returned {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDate returndeDate;
    
    @PrePersist
    public void returnDate(){
        returndeDate = LocalDate.now();
    }
    
    @OneToOne
    @JoinColumn(name = "borrow_id", nullable = false)
    private Borrow borrow;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "returned")  // relation entre un emprunt et une sanction
    private Sanction sanction;
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "returned")
    private ReturnedBill returnedBill;

    public Returned(Long id, LocalDate returndeDate) {
        Id = id;
        this.returndeDate = returndeDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDate getReturndeDate() {
        return returndeDate;
    }

    public void setReturndeDate(LocalDate returndeDate) {
        this.returndeDate = returndeDate;
    }


}
