package com.labo_academy.gestion_bibliotheque.services.serviceBook;

import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Book;


import java.util.List;

public interface ServiceBook {

    // CRUD sur le BooK
    public BookResponseDto createBook(BookCreateDto bookCreateDto);
    public List<BookResponseDto> getAllBookk();
    public BookResponseDto getBookById(long id);
    public BookResponseDto update(Long id, BookCreateDto dto);
    public boolean existsById (long id);
    public  void deleteById(long id);
    List<Book> findBookByAuthor(String nameAuthor);
    List<Book> findBookByCategory(String categoryName);

}
