package se.lexicon.leo.booklender.model.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.leo.booklender.model.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
