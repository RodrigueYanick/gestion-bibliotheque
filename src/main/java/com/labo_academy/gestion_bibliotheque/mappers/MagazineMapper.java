package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.magazineDto.MagazineResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.entity.Magazine;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class MagazineMapper {

    private CategoryRepository categoryRepository;
    private AuthorRepository authorRepository;

    // Conversion Entity to DTO
    public MagazineResponseDto fromEntityToDto(Magazine magazine){
        Category category;
        Author author;
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
                magazine.getCategory().getName(),
                magazine.getAuthor().getFirstName(),
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
                Category category = categoryRepository.findByName(magazineCreateDto.getCategoryName());
                Author author = authorRepository.findByLastName(magazineCreateDto.getAuthorName());
                magazine.setIssn(magazineCreateDto.getIssn());
                magazine.setValidationPeriod(magazineCreateDto.getValidationPeriod());

        return magazine;
    }
}
