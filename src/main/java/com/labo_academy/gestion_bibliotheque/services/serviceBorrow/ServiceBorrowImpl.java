package com.labo_academy.gestion_bibliotheque.services.serviceBorrow;

import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.BorrowedStatus;
import com.labo_academy.gestion_bibliotheque.mappers.BorrowMapper;
import com.labo_academy.gestion_bibliotheque.repository.BorrowRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceBorrowImpl implements ServiceBorrow{

    BorrowRepository borrowRepository;
    BorrowMapper borrowMapper;
    @Override
    public BorrowResponseDto createBorrow(BorrowCreateDto borrowCreateDto) {
        Borrow borrow = borrowMapper.fromDtoToEntity(borrowCreateDto);

        // Générer un numéro unique pour l’emprunt
        borrow.setBorrowedNumber("BORR-" + System.currentTimeMillis());

        return borrowMapper.fromEntityToDto(borrowRepository.save(borrow));    }

    @Override
    public List<BorrowResponseDto> getAllBorrow() {
        return borrowRepository.findAll().stream().map(borrowMapper::fromEntityToDto).collect(Collectors.toList());
    }

    @Override
    public BorrowResponseDto getBorrowById(long id) {
        Borrow borrow = borrowRepository.findById(id).orElseThrow(()-> new RuntimeException("Emprunt introuvable"));
        return borrowMapper.fromEntityToDto(borrow);
    }

    @Override
    public boolean existsById(long id) {
        return borrowRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!borrowRepository.existsById(id)){
            System.out.println(" n'existe pas");
        }
        borrowRepository.deleteById(id);
    }

    @Override
    public BorrowResponseDto updateStatus(Long id, String status) {
        Borrow borrow = borrowRepository.findById(id).orElseThrow(() -> new RuntimeException("Emprunt non trouvé avec l’ID : " + id));

        try {
            borrow.setStatus(BorrowedStatus.valueOf(status.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Statut invalide : " + status);
        }

        return borrowMapper.fromEntityToDto(borrowRepository.save(borrow));
    }
}
