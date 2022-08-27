package se.lexicon.leo.booklender.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.leo.booklender.exception.ObjectNotFoundException;
import se.lexicon.leo.booklender.model.dto.BookDto;
import se.lexicon.leo.booklender.model.entity.Book;
import se.lexicon.leo.booklender.model.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BookDto> findByReserved(boolean reserved) {
        List<Book> list = bookRepository.findByReserved(reserved);
        return modelMapper.map(list,
                new TypeToken<List<BookDto>>() {
                }.getType());
    }

    @Override
    public List<BookDto> findByAvailable(boolean available) {
        List<Book> list = bookRepository.findByAvailable(available);
        return modelMapper.map(list,
                new TypeToken<List<BookDto>>() {
                }.getType());
    }

    @Override
    public List<BookDto> findByTitle(String title) {
        if (title == null || title.equals("")) throw new IllegalArgumentException("title is null/empty");
        List<Book> list = bookRepository.findByTitle(title);
        return modelMapper.map(list,
                new TypeToken<List<BookDto>>() {
                }.getType());
    }

    @Override
    public BookDto findById(int bookId) throws ObjectNotFoundException {
        if (bookId < 0) throw new IllegalArgumentException("bookId must be zero or more");
        Optional<Book> book = bookRepository.findById(bookId);
        if (!book.isPresent())
            throw new ObjectNotFoundException("book with id not found");
        return modelMapper.map(bookRepository.findById(bookId).get(), BookDto.class);

    }

    @Override
    public List<BookDto> findAll() {
        List<Book> list = bookRepository.findAll();
        return modelMapper.map(list,
                new TypeToken<List<BookDto>>() {
                }.getType());
    }

    @Override
    public BookDto create(BookDto bookDto) {
        if (bookDto == null) throw new IllegalArgumentException("bookDto is null");
        Book toSave = modelMapper.map(bookDto, Book.class);
        Book savedBook = bookRepository.save(toSave);
        return modelMapper.map(savedBook, BookDto.class);
    }

    @Override
    public BookDto update(BookDto bookDto) {
        if (bookDto == null) throw new IllegalArgumentException("bookDto wis null");
        Book updated = bookRepository.save(modelMapper.map(bookDto, Book.class));

        return modelMapper.map(updated, BookDto.class);
    }

    @Override
    public boolean deleteById(int bookId) throws ObjectNotFoundException {
        if (!bookRepository.existsById(bookId)) throw new ObjectNotFoundException("Object not found");
        bookRepository.deleteById(bookId);
        return true;
    }
}