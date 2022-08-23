package se.lexicon.leo.booklender.model.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;

@SpringBootTest
public class LibraryUserTest {

    @Test
    void createEmptyLibraryUser() {
        LibraryUser user = new LibraryUser();
        Assertions.assertNotNull(user);
    }

    @Test
    void createUserAllArgsWithoutId() {
        LibraryUser user = new LibraryUser(LocalDate.parse("1991-12-02"), "Leo", "leo@email.com");
        String expected = "leo@email.com";
        Assertions.assertEquals(expected, user.getEmail());
        Assertions.assertEquals(LocalDate.parse("1991-12-02"), user.getRegDate());
        expected = "Leo";
        Assertions.assertEquals(expected, user.getName());

    }
}