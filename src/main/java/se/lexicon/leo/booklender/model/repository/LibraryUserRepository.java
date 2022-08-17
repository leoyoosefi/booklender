package se.lexicon.leo.booklender.model.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.leo.booklender.model.entity.LibraryUser;

public interface LibraryUserRepository extends CrudRepository<LibraryUser, Integer> {
}
