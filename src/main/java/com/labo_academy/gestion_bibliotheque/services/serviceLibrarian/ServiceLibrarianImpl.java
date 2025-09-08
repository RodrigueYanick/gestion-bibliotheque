package com.labo_academy.gestion_bibliotheque.services.serviceLibrarian;

<<<<<<< HEAD
import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.librarianDto.LibrarianResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Librarian;
import com.labo_academy.gestion_bibliotheque.mappers.LibrarianMapper;
import com.labo_academy.gestion_bibliotheque.repository.LibrarianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
=======
>>>>>>> e6a4eb49e23673d9eab285385c8e5178a10f282b

public class ServiceLibrarianImpl implements ServiceLibrarian{

    private LibrarianMapper librarianMapper;
    private LibrarianRepository librarianRepository;
    @Override
    public LibrarianResponseDto createLibrarian(LibrarianCreateDto librarianCreateDto) {
        Librarian librarian = librarianMapper.toEntity(librarianCreateDto);
        librarianRepository.save(librarian);
        return librarianMapper.toDto(librarian);    }

    @Override
    public List<LibrarianResponseDto> getAllLibrarian() {
        return librarianRepository.findAll().stream().map(librarianMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public LibrarianResponseDto getLibrarianById(long id) {
        Librarian librarian = librarianRepository.findById(id).orElseThrow(()-> new RuntimeException("Libraire introuvable"));
        return librarianMapper.toDto(librarian);    }

    @Override
    public LibrarianResponseDto update(Long id, LibrarianCreateDto dto) {
        Librarian librarian = librarianRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author non trouvé avec l’ID : " + id));
        librarian.setLastName(dto.getLastName());
        librarian.setFirstName(dto.getFirstName());
        librarian.setBirthDate(dto.getBirthDate());
        librarian.setEmail(dto.getEmail());
        return librarianMapper.toDto(librarianRepository.save(librarian));    }

    @Override
    public boolean existsById(long id) {
        return librarianRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!librarianRepository.existsById(id)){
            System.out.println("le directeur n'existe pas");
        }
        librarianRepository.deleteById(id);
    }
}
