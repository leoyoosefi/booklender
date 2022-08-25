package se.lexicon.leo.booklender.model.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.leo.booklender.model.entity.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {


    List<Book> findAll();

    List<Book> findByReserved(boolean reserved);

    List<Book> findByAvailable(boolean available);

    List<Book> findByTitle(String title);

}
