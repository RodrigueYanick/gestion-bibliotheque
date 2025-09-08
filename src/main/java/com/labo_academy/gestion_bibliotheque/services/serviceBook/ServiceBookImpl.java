package com.labo_academy.gestion_bibliotheque.services.serviceBook;

import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Book;
import com.labo_academy.gestion_bibliotheque.mappers.BookMapper;
import com.labo_academy.gestion_bibliotheque.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

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
        List<Book> books = bookRepository.findAll();
        if(books.isEmpty()){throw new RuntimeException("Aucun Auteur trouver.");}
        List<BookResponseDto> bookResponseDtos = new ArrayList<>();
        for (Book book : books) {
            bookResponseDtos.add(bookMapper.fromEntityToDto(book));
        }
        return bookResponseDtos;     }

    @Override
    public BookResponseDto getBookById(long id) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Livre introuvable"));
    return bookMapper.fromEntityToDto(book);    }

    @Override
    public BookResponseDto update(Long id, BookCreateDto dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author non trouvé avec l’ID : " + id));
        book.setIsbn(dto.getIsbn());
        book.setNumberPages(dto.getNumberPages());
        return bookMapper.fromEntityToDto(bookRepository.save(book));
    }

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

    @Override
    public List<Book> findBookByAuthor(String nameAuthor) {
        return bookRepository.findBookByAuthor(nameAuthor);
    }

    @Override
    public List<Book> findBookByCategory(String categoryName) {
        return bookRepository.findBooKByCategory(categoryName);
    }
}
