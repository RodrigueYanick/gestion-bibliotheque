package com.labo_academy.gestion_bibliotheque.services.serviceBook;

import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Book;
import com.labo_academy.gestion_bibliotheque.mappers.BookMapper;
import com.labo_academy.gestion_bibliotheque.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceBookImpl implements ServiceBook{

    private BookRepository bookRepository;
    private BookMapper bookMapper;
    @Override
    public BookResponseDto createBook(BookCreateDto bookCreateDto) {
        Book book = bookMapper.fromDtoToEntity(bookCreateDto);
        bookRepository.save(book);
        return bookMapper.fromEntityToDto(book);
    }

    @Override
    public List<BookResponseDto> getAllBookk() {
        return bookRepository.findAll().stream().map(bookMapper::fromEntityToDto).collect(Collectors.toList());
    }

    @Override
    public BookResponseDto getBookById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Livre introuvable"));
    return bookMapper.fromEntityToDto(book);    }

    @Override
    public boolean existsById(long id) {
        return bookRepository.existsById(id);
    }

    @Override
    public void deleteById(long id) {
        if (!bookRepository.existsById(id)){
            System.out.println("le livre n'existe pas");
        }
        bookRepository.deleteById(id);
    }
}
