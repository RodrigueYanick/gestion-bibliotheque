package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.visitorDto.VisitorCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.visitorDto.VisitorResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Visitor;
import org.springframework.stereotype.Component;

@Component
public class VisitorMapper {

    // Conversion de Entity to Dto
    public VisitorResponseDto fromEntityToDto(Visitor visitor){
        return new VisitorResponseDto(
                visitor.getId(),
                visitor.getLastName(),
                visitor.getFirstName(),
                visitor.getBirthDate(),
                visitor.getEmail(),
                visitor.getAddress(),
                visitor.getRole()
        );
    }

    // Conversion Dto To Entity
    public Visitor fromDtoToEntity(VisitorCreateDto visitorCreateDto){
        Visitor visitor = new Visitor();
        visitor.setLastName(visitorCreateDto.getLastName());
        visitor.setFirstName(visitorCreateDto.getFirstName());
        visitor.setBirthDate(visitorCreateDto.getBirthDate());
        visitor.setPassword(visitorCreateDto.getPassword());
        visitor.setEmail(visitorCreateDto.getEmail());
        visitor.setAddress(visitorCreateDto.getAddress());
        visitor.setRole(visitorCreateDto.getRole());
        return visitor;
    }
}
