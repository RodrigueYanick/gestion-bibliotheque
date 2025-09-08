package com.labo_academy.gestion_bibliotheque.services.serviceSanction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Returned;
import com.labo_academy.gestion_bibliotheque.entity.Sanction;
import com.labo_academy.gestion_bibliotheque.entity.SanctionStatus;
import com.labo_academy.gestion_bibliotheque.mappers.SanctionMapper;
import com.labo_academy.gestion_bibliotheque.repository.ReturnedRepository;
import com.labo_academy.gestion_bibliotheque.repository.SanctionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class SanctionServiceImpl implements SanctionService {

    private final SanctionRepository sanctionRepository;
    private final ReturnedRepository returnedRepository;
    private final SanctionMapper sanctionMapper;

    @Override
    public SanctionResponseDto create(SanctionCreateDto dto) {
        // Récuperation du retour via son numero
        Returned returned = returnedRepository.findByReturnNumber(dto.getReturnedNumber()).orElseThrow(() -> new RuntimeException("Retour introuvable avec numéro : " + dto.getReturnedNumber()));

        // Calcul de la sanction automatique
        Sanction sanction = sanctionMapper.fromReturned(returned);

        // Sauvegarde en BD
        return sanctionMapper.toDto(sanctionRepository.save(sanction));
    }

    @Override
    public List<SanctionResponseDto> findAll() {
        List<Sanction> sanctions = sanctionRepository.findAll();
        if (sanctions.isEmpty()) {
            throw new RuntimeException("Aucune sanction trouvee.");
        }
        List<SanctionResponseDto> sanctionDtos = new ArrayList<>();
        for (Sanction sanction : sanctions) {
            sanctionDtos.add(sanctionMapper.toDto(sanction));
        }
        return sanctionDtos;
    }

    @Override
    public SanctionResponseDto findById(Long id) {
        Sanction sanction = sanctionRepository.findById(id).orElseThrow(() -> new RuntimeException("Sanction introuvable avec l'ID : " + id));
        return sanctionMapper.toDto(sanction);
    }

    @Override
    public SanctionResponseDto updateStatus(Long id, String status) {
        Sanction sanction = sanctionRepository.findById(id).orElseThrow(() -> new RuntimeException("Sanction introuvable avec l'ID : " + id));

        // Conversion du statut
        try {
            SanctionStatus newStatus = SanctionStatus.valueOf(status.toUpperCase());
            sanction.setStatus(newStatus);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Statut invalide : " + status);
        }

        return sanctionMapper.toDto(sanctionRepository.save(sanction));
    }

    @Override
    public void delete(Long id) {
        if (!sanctionRepository.existsById(id)) {
            throw new RuntimeException("Sanction introuvable avec l'ID : " + id);
        }
        sanctionRepository.deleteById(id);
    }

}
