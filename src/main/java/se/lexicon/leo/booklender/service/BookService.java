package se.lexicon.leo.booklender.service;

import se.lexicon.leo.booklender.exception.ObjectNotFoundException;
import se.lexicon.leo.booklender.model.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> findByReserved(boolean reserved);

    List<BookDto> findByAvailable(boolean available);

    List<BookDto> findByTitle(String title);

    BookDto findById(int bookId) throws ObjectNotFoundException;

    List<BookDto> findAll();

    BookDto create(BookDto bookDto);

    BookDto update(BookDto bookDto) throws ObjectNotFoundException;

    boolean deleteById(int bookId) throws ObjectNotFoundException;
}
