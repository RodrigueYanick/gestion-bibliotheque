package com.labo_academy.gestion_bibliotheque.dto.libraryClientDto;

import com.labo_academy.gestion_bibliotheque.dto.usersDto.UsersResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Role;
import com.labo_academy.gestion_bibliotheque.entity.RoleClient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LibraryClientResponseDto extends UsersResponseDto {

    private RoleClient roleClient;       // VISITOR ou SUBSCRIBER
    private String accountNumber;        // Null si VISITOR
    private Boolean subscriberStatus;    // Actif uniquement si SUBSCRIBER
    private Boolean visitorStatus;       // Actif uniquement si VISITOR

    public LibraryClientResponseDto(Long id,
                                    String lastName,
                                    String firstName,
                                    LocalDate birthDate,
                                    String email,
                                    String address,
                                    Role role,
                                    String imageUrl,
                                    RoleClient roleClient,
                                    String accountNumber,
                                    Boolean subscriberStatus,
                                    Boolean visitorStatus) {
        super(id, lastName, firstName, birthDate, email, address, role, imageUrl);
        this.roleClient = roleClient;
        this.accountNumber = accountNumber;
        this.subscriberStatus = subscriberStatus;
        this.visitorStatus = visitorStatus;
    }
}
