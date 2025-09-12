package com.labo_academy.gestion_bibliotheque.services.serviceBorrow;

import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.borrowDto.BorrowResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.BorrowedStatus;
import com.labo_academy.gestion_bibliotheque.entity.Copy;
import com.labo_academy.gestion_bibliotheque.mappers.BorrowMapper;
import com.labo_academy.gestion_bibliotheque.repository.BorrowRepository;
import com.labo_academy.gestion_bibliotheque.repository.CopyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceBorrowImpl implements ServiceBorrow {

    private final BorrowRepository borrowRepository;
    private final BorrowMapper borrowMapper;
    private final CopyRepository copyRepository;

    @Override
    public BorrowResponseDto createBorrow(BorrowCreateDto borrowCreateDto) {
        // 1. Mapper DTO -> Entity
        Borrow borrow = borrowMapper.fromDtoToEntity(borrowCreateDto);

        // 2. Recuperer le document lie à l’emprunt
        if (borrow.getDocument() == null) {
            throw new RuntimeException("Aucun document associé à cet emprunt.");
        }

        // 3. Chercher une copie disponible
        Copy availableCopy = null;
        for (Copy copy : borrow.getDocument().getExemplaires()) {
            if (!copy.isBorrowed()) {   // si la copie n'est pas empruntée
                availableCopy = copy;
                break; // on s'arrête dès qu’on en trouve une
            }
        }

        if (availableCopy == null) {
            throw new RuntimeException("Aucune copie disponible pour ce document.");
        }

        // 4. Marquer la copie comme empruntee
        availableCopy.setBorrowed(true);
        copyRepository.save(availableCopy);

        // Facultatif : lier la copie choisie au borrow si tu veux garder la traçabilité
        // borrow.setCopy(availableCopy);

        // 6. Sauvegarder l’emprunt
        Borrow savedBorrow = borrowRepository.save(borrow);

        // 7. Retourner le DTO
        return borrowMapper.fromEntityToDto(savedBorrow);
    }


    @Override
    public List<BorrowResponseDto> getAllBorrow() {
        return borrowRepository.findAll()
                .stream()
                .map(borrowMapper::fromEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowResponseDto getBorrowById(long id) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprunt introuvable"));
        return borrowMapper.fromEntityToDto(borrow);
    }

    @Override
    public boolean existsById(long id) {
        return borrowRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!borrowRepository.existsById(id)) {
            throw new RuntimeException("Emprunt introuvable avec l’ID : " + id);
        }
        borrowRepository.deleteById(id);
    }

    @Override
    public BorrowResponseDto updateStatus(Long id, String status) {
        Borrow borrow = borrowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emprunt non trouvé avec l’ID : " + id));

        try {
            borrow.setStatus(BorrowedStatus.valueOf(status.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Statut invalide : " + status);
        }

        return borrowMapper.fromEntityToDto(borrowRepository.save(borrow));
    }
}
