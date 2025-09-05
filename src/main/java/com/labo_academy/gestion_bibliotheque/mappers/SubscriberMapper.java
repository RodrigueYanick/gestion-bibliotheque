package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.subscribersDto.SubscribersCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.subscribersDto.SubscribersResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Subscribers;
import com.labo_academy.gestion_bibliotheque.repository.SubscribersRepository;
import org.springframework.stereotype.Component;

@Component
public class SubscriberMapper {

    SubscribersRepository subscribersRepository;

    // Conversion Entity To Dto
    public SubscribersResponseDto fromEntityToDto(Subscribers suscriber){
        return new SubscribersResponseDto(
                suscriber.getId(),
                suscriber.getLastName(),
                suscriber.getFirstName(),
                suscriber.getBirthDate(),
                suscriber.getEmail(),
                suscriber.getAddress(),
                suscriber.getRole(),
                suscriber.isStatut()
        );
    }

    // Conversion Dto To Entity
    public Subscribers fromDtoToEntity(SubscribersCreateDto subscriberCreateDto){
        Subscribers suscriber = new Subscribers();
        suscriber.setLastName(subscriberCreateDto.getLastName());
        suscriber.setFirstName(subscriberCreateDto.getFirstName());
        suscriber.setBirthDate(subscriberCreateDto.getBirthDate());
        suscriber.setPassword(subscriberCreateDto.getPassword());
        suscriber.setEmail(subscriberCreateDto.getEmail());
        suscriber.setAddress(subscriberCreateDto.getAddress());
        suscriber.setRole(subscriberCreateDto.getRole());
        suscriber.setStatut(subscriberCreateDto.isStatut());
        return suscriber;
    }
}
