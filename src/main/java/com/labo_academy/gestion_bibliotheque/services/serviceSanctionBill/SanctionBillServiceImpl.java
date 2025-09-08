package com.labo_academy.gestion_bibliotheque.services.serviceSanctionBill;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.labo_academy.gestion_bibliotheque.dto.sanctionBillDto.SanctionBillResponseDto;
import com.labo_academy.gestion_bibliotheque.dto.sanctionDto.SanctionResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Sanction;
import com.labo_academy.gestion_bibliotheque.entity.SanctionBill;
import com.labo_academy.gestion_bibliotheque.mappers.SanctionBillMapper;
import com.labo_academy.gestion_bibliotheque.repository.SanctionBillRepository;
import com.labo_academy.gestion_bibliotheque.repository.SanctionRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class SanctionBillServiceImpl implements SanctionBillService {

    private final SanctionBillRepository sanctionBillRepository;
    private final SanctionRepository sanctionRepository;
    private final SanctionBillMapper sanctionBillMapper;

    @Override
    public SanctionBillResponseDto create(Long sanctionId) {
        Sanction sanction = sanctionRepository.findById(sanctionId).orElseThrow(() -> new EntityNotFoundException("Sanction not found with id: " + sanctionId));

        SanctionBill sanctionBill = new SanctionBill(sanction);
        sanctionBill = sanctionBillRepository.save(sanctionBill);

        return sanctionBillMapper.toDto(sanctionBill);
    }

    @Override
    public List<SanctionBillResponseDto> getAll() {
        List<SanctionBill> sanctionBills = sanctionBillRepository.findAll();
        if (sanctionBills.isEmpty()) {
            throw new RuntimeException("Aucune sanctionBill trouvee.");
        }
        List<SanctionBillResponseDto> sanctionBillDtos = new ArrayList<>();
        for (SanctionBill sanctionBill : sanctionBills) {
            sanctionBillDtos.add(sanctionBillMapper.toDto(sanctionBill));
        }
        return sanctionBillDtos;
    }

    @Override
    public SanctionBillResponseDto getById(Long id) {
        SanctionBill sanctionBill = sanctionBillRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("SanctionBill not found with id: " + id));

        return sanctionBillMapper.toDto(sanctionBill);
    }

    @Override
    public void delete(Long id) {
        if (!sanctionBillRepository.existsById(id)) {
            throw new EntityNotFoundException("SanctionBill not found with id: " + id);
        }
        sanctionBillRepository.deleteById(id);
    }

}
