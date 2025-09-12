package com.labo_academy.gestion_bibliotheque.services.serviceLibrarian;

import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Librarian;
import com.labo_academy.gestion_bibliotheque.entity.Role;
import com.labo_academy.gestion_bibliotheque.mappers.LibrarianMapper;
import com.labo_academy.gestion_bibliotheque.repository.LibrarianRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class LibrarianServiceImpl implements ServiceLibrarian {

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private LibrarianMapper librarianMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //  Creation d'un nouveau bibliothecaire
    @Override
    public LibrarianResponseDto createLibrarian(LibrarianCreateDto dto) {
        Librarian librarian = librarianMapper.toEntity(dto);
        librarian.setRole(Role.LIBRARIAN);
        librarian.setPassword(passwordEncoder.encode(dto.getPassword()));
        Librarian saved = librarianRepository.save(librarian);
        return librarianMapper.toDto(saved);
    }

    //  Recuperer la liste de tous les bibliothecaires
    @Override
    public List<LibrarianResponseDto> getAllLibrarian() {
        List<Librarian> librarians = librarianRepository.findAll();
        List<LibrarianResponseDto> dtos = new ArrayList<>();

        for (Librarian lib : librarians) {
            dtos.add(librarianMapper.toDto(lib));
        }
        return dtos;
    }

    //  Recuperer un bibliothécaire par son ID
    @Override
    public LibrarianResponseDto getLibrarianById(long id) {
        Optional<Librarian> optional = librarianRepository.findById(id);
        if (optional.isPresent()) {
            return librarianMapper.toDto(optional.get());
        }
        return null;
    }

    //  Mettre a jour un bibliothecaire existant
    @Override
    public LibrarianResponseDto update(Long id, LibrarianCreateDto dto) {
        Optional<Librarian> optional = librarianRepository.findById(id);
        if (optional.isPresent()) {
            Librarian librarian = optional.get();
            librarian.setLastName(dto.getLastName());
            librarian.setFirstName(dto.getFirstName());
            librarian.setBirthDate(dto.getBirthDate());
            librarian.setEmail(dto.getEmail());
            librarian.setAddress(dto.getAddress());
            librarian.setImageUrl(dto.getImageUrl());
            librarian.setIdNumber(dto.getIdNumber());

            // Réencoder le mot de passe seulement s'il est modifie
            librarian.setPassword(passwordEncoder.encode(dto.getPassword()));

            Librarian updated = librarianRepository.save(librarian);
            return librarianMapper.toDto(updated);
        }
        return null;
    }

    //  Vérifie si un bibliothecaire existe par ID
    @Override
    public boolean existsById(long id) {
        return librarianRepository.existsById(id);
    }

    //  Supprimer un bibliothecaire par ID
    @Override
    public void deleteById(long id) {
        librarianRepository.deleteById(id);
    }
    
}
