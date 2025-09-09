package com.labo_academy.gestion_bibliotheque.mappers;

import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookCreateDto;
import com.labo_academy.gestion_bibliotheque.dto.bookDto.BookResponseDto;
import com.labo_academy.gestion_bibliotheque.entity.Author;
import com.labo_academy.gestion_bibliotheque.entity.Book;
import com.labo_academy.gestion_bibliotheque.entity.Category;
import com.labo_academy.gestion_bibliotheque.repository.AuthorRepository;
import com.labo_academy.gestion_bibliotheque.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    @Autowired
    private final AuthorRepository authorRepository;
    @Autowired
    private final CategoryRepository categoryRepository;

    public BookMapper(AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    // Conversion Entity -> ResponseDto
    public BookResponseDto fromEntityToDto(Book book) {
        if (book == null) {
            return null;
        }

        BookResponseDto dto = new BookResponseDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setDocumentNumber(book.getDocumentNumber());
        dto.setPublicationDate(book.getPublicationDate());
        dto.setCreationDate(book.getCreationDate());
        dto.setLastUpdateDate(book.getLastUpdateDate());
        dto.setDeleted(book.isDeleted());
        dto.setImageUrl(book.getImageUrl());
        dto.setPublisher(book.getPublisher());

        // relations
        if (book.getCategory() != null) {
            dto.setCategoryName(book.getCategory().getName());
        }
        if (book.getAuthor() != null) {
            dto.setAuthorName(book.getAuthor().getLastName());
        }

        // spécificités Book
        dto.setIsbn(book.getIsbn());
        dto.setNumberPages(book.getNumberPages());

        return dto;
    }

    // Conversion CreateDto -> Entity
    public Book fromDtoToEntity(BookCreateDto dto) {
        if (dto == null) {
            return null;
        }

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setDocumentNumber(dto.getDocumentNumber());
        book.setPublicationDate(dto.getPublicationDate());
        book.setPublisher(dto.getPublisher());
        book.setIsbn(dto.getIsbn());
        book.setNumberPages(dto.getNumberPages());

        // relations avec la BD
        Category category = categoryRepository.findByName(dto.getCategoryName());
        Author author = authorRepository.findByLastName(dto.getAuthorName());
        book.setCategory(category);
        book.setAuthor(author);

        return book;
    }
}
