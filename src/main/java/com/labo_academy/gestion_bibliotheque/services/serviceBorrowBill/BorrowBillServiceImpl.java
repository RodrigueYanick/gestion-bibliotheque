package com.labo_academy.gestion_bibliotheque.services.serviceBorrowBill;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.labo_academy.gestion_bibliotheque.dto.borrowBillDto.BorrowedBillResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.BorrowedBill;
import com.labo_academy.gestion_bibliotheque.mappers.BorrowBillMapper;
import com.labo_academy.gestion_bibliotheque.repository.BorrowBillRepository;
import com.labo_academy.gestion_bibliotheque.repository.BorrowRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class BorrowBillServiceImpl implements BorrowBillService {

    private final BorrowBillRepository borrowBillRepository;
    private final BorrowRepository borrowRepository;
    private final BorrowBillMapper borrowBillMapper;

    @Override
    public BorrowedBillResponseDto create(Long borrowId) {
        // Vérifier l’existence de l’emprunt
        Borrow borrow = borrowRepository.findById(borrowId)
                .orElseThrow(() -> new RuntimeException("Emprunt non trouvé avec l’ID : " + borrowId));

        // Vérifier si une facture existe déjà pour cet emprunt
        if (borrow.getFacture() != null) {
            throw new RuntimeException("Une facture existe déjà pour cet emprunt.");
        }

        // Créer une nouvelle facture
        BorrowedBill bill = new BorrowedBill();
        bill.setBorrow(borrow);

        // Sauvegarder la facture
        BorrowedBill savedBill = borrowBillRepository.save(bill);

        return borrowBillMapper.toDto(savedBill);
    }

    @Override
    public List<BorrowedBillResponseDto> findAll() {
        List<BorrowedBill> borrowedBills = borrowBillRepository.findAll();
        if(borrowedBills.isEmpty()){throw new RuntimeException("Aucun administrateur trouver.");}
        List<BorrowedBillResponseDto> BorrowBillDtos = new ArrayList<>();
        for (BorrowedBill BorrowBill : borrowedBills) {
            BorrowBillDtos.add(borrowBillMapper.toDto(BorrowBill));
        }
        return BorrowBillDtos;
    }

    @Override
    public BorrowedBillResponseDto findById(Long id) {
        BorrowedBill bill = borrowBillRepository.findById(id).orElseThrow(() -> new RuntimeException("Facture non trouvée avec l’ID : " + id));
        return borrowBillMapper.toDto(bill);
    }

    @Override
    public void delete(Long id) {
        if (!borrowBillRepository.existsById(id)) {
            throw new RuntimeException("Facture non trouvée avec l’ID : " + id);
        }
        borrowBillRepository.deleteById(id);
    }

}
