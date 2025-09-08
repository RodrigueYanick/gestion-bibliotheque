package com.labo_academy.gestion_bibliotheque.services.serviceReturnedBill;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnBillDto.ReturnedBillResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Returned;
import com.labo_academy.gestion_bibliotheque.entity.ReturnedBill;
import com.labo_academy.gestion_bibliotheque.mappers.ReturnedBillMapper;
import com.labo_academy.gestion_bibliotheque.repository.ReturnedBillRepository;
import com.labo_academy.gestion_bibliotheque.repository.ReturnedRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ReturnedBillServiceImpl implements ReturnedBillService {

    private final ReturnedBillRepository returnedBillRepository;
    private final ReturnedRepository returnedRepository;
    private final ReturnedBillMapper returnedBillMapper;

    @Override
    public ReturnedBillResponseDto create(ReturnedBillCreateDto dto) {
        Returned returned = returnedRepository.findByReturnNumber(dto.getReturnedNumber()).orElseThrow(() -> new RuntimeException("Retour introuvable avec numéro : " + dto.getReturnedNumber()));

    // Generer une facture avec un numero unique
    ReturnedBill returnedBill = new ReturnedBill();
    returnedBill.setBillNumber("BILL-" + System.currentTimeMillis());
    returnedBill.setReturned(returned);

    return returnedBillMapper.toDto(returnedBillRepository.save(returnedBill));
    }

    @Override
    public List<ReturnedBillResponseDto> findAll() {
        List<ReturnedBill> returnedBills = returnedBillRepository.findAll();
        if(returnedBills.isEmpty()){throw new RuntimeException("Aucun administrateur trouver.");}
        List<ReturnedBillResponseDto> returnedBillDtos = new ArrayList<>();
        for (ReturnedBill ReturnBill : returnedBills) {
            returnedBillDtos.add(returnedBillMapper.toDto(ReturnBill));
        }
        return returnedBillDtos;
    }

    @Override
    public ReturnedBillResponseDto findById(Long id) {
        ReturnedBill returnedBill = returnedBillRepository.findById(id).orElseThrow(() -> new RuntimeException("Facture introuvable avec l’ID : " + id));
        return returnedBillMapper.toDto(returnedBill);
    }

    @Override
    public void delete(Long id) {
        if (!returnedBillRepository.existsById(id)) {
            throw new RuntimeException("Facture introuvable avec l’ID : " + id);
        }
        returnedBillRepository.deleteById(id);
    }

}
