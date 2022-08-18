package se.lexicon.leo.booklender.model.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.leo.booklender.model.entity.LibraryUser;

import java.util.Optional;

public interface LibraryUserRepository extends CrudRepository<LibraryUser, Integer> {

    Optional<LibraryUser> findByEmail(String email);

}
