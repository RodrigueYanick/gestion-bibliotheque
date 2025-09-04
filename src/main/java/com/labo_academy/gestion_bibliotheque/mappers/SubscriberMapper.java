package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.subscriberDto.SubscriberCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.subscriberDto.SubscriberResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Suscriber;
import org.springframework.stereotype.Component;

import java.util.concurrent.Flow;

@Component
public class SubscriberMapper {

    // Conversion Entity To Dto
    public SubscriberResponseDto fromEntityToDto(Suscriber suscriber){
        return new SubscriberResponseDto(
                suscriber.getId(),
                suscriber.getLastName(),
                suscriber.getFirstName(),
                suscriber.getBirthDate(),
                suscriber.getEmail(),
                suscriber.getAddress(),
                suscriber.getRole()
        );
    }

    // Conversion Dto To Entity
    public Suscriber fromDtoToEntity(SubscriberCreateDto subscriberCreateDto){
        Suscriber suscriber = new Suscriber();
        suscriber.setLastName(subscriberCreateDto.getLastName());
        suscriber.setFirstName(subscriberCreateDto.getFirstName());
        suscriber.setBirthDate(subscriberCreateDto.getBirthDate());
        suscriber.setPassword(subscriberCreateDto.getPassword());
        suscriber.setEmail(subscriberCreateDto.getEmail());
        suscriber.setAddress(subscriberCreateDto.getAddress());
        suscriber.setRole(subscriberCreateDto.getRole());
        return suscriber;
    }
}
