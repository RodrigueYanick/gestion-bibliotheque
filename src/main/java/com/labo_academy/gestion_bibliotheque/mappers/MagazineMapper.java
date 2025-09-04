package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Magazine;
import org.springframework.stereotype.Component;

@Component
public class MagazineMapper {

    // Conversion Entity to DTO
    public MagazineResponseDto fromEntityToDto(Magazine magazine){
        return new MagazineResponseDto(
                magazine.getId(),
                magazine.getTitle(),
                magazine.getQuantity(),
                magazine.getPublicationDate(),
                magazine.getCreationDate(),
                magazine.getLastUpdateDate(),
                magazine.getisDeleted(),
                magazine.getImage(),
                magazine.getPublisher(),
                magazine.getIssn(),
                magazine.getValidationPeriod()
        );
    }

    // Conversion DTO to Entity
    public Magazine fromDtoToEntity(MagazineCreateDto magazineCreateDto){
          Magazine magazine = new Magazine ();
                magazine.setTitle(magazineCreateDto.getTitle());
                magazine.setQuantity(magazineCreateDto.getQuantity());
                magazine.setValidationPeriod(magazineCreateDto.getValidationPeriod());
                magazine.setDeleted(magazineCreateDto.getIsDeleted());
                magazine.setImage(magazineCreateDto.getImage());
                magazine.setPublisher(magazineCreateDto.getPublisher());
                magazine.setIssn(magazineCreateDto.getIssn());
                magazine.setValidationPeriod(magazineCreateDto.getValidationPeriod());

        return magazine;
    }
}
