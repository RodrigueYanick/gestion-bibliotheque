package com.labo_academy.gestion_bibliotheque.services.serviceReturn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.returnedDto.ReturnedResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Borrow;
import com.labo_academy.gestion_bibliotheque.entity.BorrowedStatus;
import com.labo_academy.gestion_bibliotheque.entity.Copy;
import com.labo_academy.gestion_bibliotheque.entity.Returned;
import com.labo_academy.gestion_bibliotheque.mappers.ReturnedMapper;
import com.labo_academy.gestion_bibliotheque.repository.BorrowRepository;
import com.labo_academy.gestion_bibliotheque.repository.ReturnedRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReturnedServiceImpl implements ReturnedService {

    private final ReturnedRepository returnedRepository;
    private final BorrowRepository borrowRepository;
    private final ReturnedMapper returnedMapper;

    @Override
    public ReturnedResponseDto create(ReturnedCreateDto dto) {
        // Convertir DTO -> Entity
        Returned returned = returnedMapper.toEntity(dto);

        // Récupérer l'emprunt associé
        Borrow borrow = returned.getBorrow();

        // Mettre à jour le statut de l’emprunt
        borrow.setStatus(BorrowedStatus.RETURNED);

        // 3. Chercher une copie disponible
        Copy availableCopy = null;
        for (Copy copy : borrow.getDocument().getExemplaires()) {
            if (copy.isBorrowed() == true) {   // si la copie n'est pas empruntée
                availableCopy = copy;
                break; // on s'arrête des qu’on en trouve une
            }
        }

        if (availableCopy == null) {
            throw new RuntimeException("Aucune copie disponible pour ce document.");
        }

        availableCopy.setBorrowed(true);

        // Sauvegarder l’emprunt mis à jour
        borrowRepository.save(borrow);

        // Sauvegarder le retour
        returned = returnedRepository.save(returned);

        // Retourner le DTO
        return returnedMapper.toDto(returned);
    }

    @Override
    public List<ReturnedResponseDto> findAll() {
        List<Returned> returneds = returnedRepository.findAll();
        if (returneds.isEmpty()) {
            throw new RuntimeException("Aucun retour trouvé.");
        }
        List<ReturnedResponseDto> returnedDtos = new ArrayList<>();
        for (Returned r : returneds) {
            returnedDtos.add(returnedMapper.toDto(r));
        }
        return returnedDtos;
    }

    @Override
    public ReturnedResponseDto findById(Long id) {
        Returned returned = returnedRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Retour non trouvé avec ID : " + id));
        return returnedMapper.toDto(returned);
    }

    @Override
    public void delete(Long id) {
        if (!returnedRepository.existsById(id)) {
            throw new RuntimeException("Retour non trouvé avec ID : " + id);
        }
        returnedRepository.deleteById(id);
    }
}
