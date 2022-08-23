package se.lexicon.leo.booklender.model.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.leo.booklender.model.entity.LibraryUser;

import java.util.List;
import java.util.Optional;

public interface LibraryUserRepository extends CrudRepository<LibraryUser, Integer> {

    List<LibraryUser> findAll();

    Optional<LibraryUser> findByEmail(String email);

}
