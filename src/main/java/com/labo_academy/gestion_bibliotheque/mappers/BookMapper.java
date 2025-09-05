package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import com.labo_academy.gestion_bibliotheque.entity.Book;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    CategoryRepository categoryRepository;
    AuthorRepository authorRepository;

    // Conversion Entity to Dto
    public BookResponseDto fromEntityToDto(Book book){
        Category category;
        Author author;
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
                book.getCategory().getName(),
                book.getAuthor().getFirstName(),
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
        Category category = categoryRepository.findByName(bookCreateDto.getCategoryName());
        Author author = authorRepository.findByLastName(bookCreateDto.getAuthorName());
        book.setIsbn(bookCreateDto.getIsbn());
        book.setNumberPages(bookCreateDto.getNumberPages());

        return book;
    }
}
