package se.lexicon.leo.booklender.model.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class LibraryUserTest {

    @Test
    public void test_create_LibraryUser_SUCCESS() {
        //arranged
        LocalDate expectedRegDate = LocalDate.parse("2022-08-21");
        String expectedName = "Test Testsson";

        //testing act
        LibraryUser testUser = new LibraryUser(LocalDate.parse("2022-08-21"), "Test test");


        //applied assertions
        assertEquals(expectedRegDate, testUser.getRegDate());
        assertEquals(expectedName, testUser.getName());
    }

}
