package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    // Conversion Entity to Dto
    public UsersResponseDto fromEntityToDto(Users users){
        return new UsersResponseDto(
                users.getId(),
                users.getLastName(),
                users.getFirstName(),
                users.getBirthDate(),
                users.getEmail(),
                users.getAddress(),
                users.getRole()
        );
    }

}
