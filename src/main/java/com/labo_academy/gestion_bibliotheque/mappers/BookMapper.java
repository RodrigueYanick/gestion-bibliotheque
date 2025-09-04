package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    // Conversion Entity to Dto
    public BookResponseDto fromEntityToDto(Book book){
        return new BookResponseDto(
                book.getId(),
                book.getTitle(),
                book.getQuantity(),
                book.getPublicationDate(),
                book.getLastUpdateDate(),
                book.getCreationDate(),
                book.getisDeleted(),
                book.getImage(),
                book.getPublisher(),
                book.getIsbn(),
                book.getNumberPages()
        );
    }

    // Convertion Dto en Entity
    public Book fromDtoToEntity(BookCreateDto bookCreateDto){
        Book book = new Book();
        book.setTitle(bookCreateDto.getTitle());
        book.setQuantity(bookCreateDto.getQuantity());
        book.setPublicationDate(bookCreateDto.getPublicationDate());
        book.setDeleted(bookCreateDto.getIsDeleted());
        book.setImage(bookCreateDto.getImage());
        book.setPublisher(bookCreateDto.getPublisher());
        book.setIsbn(bookCreateDto.getIsbn());
        book.setNumberPages(bookCreateDto.getNumberPages());

        return book;
    }
}
