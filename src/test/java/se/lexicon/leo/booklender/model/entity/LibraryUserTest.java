package se.lexicon.leo.booklender.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class LibraryUserTest {
    @Test
    void testConstructor() {
        LibraryUser actualLibraryUser = new LibraryUser();
        assertNull(actualLibraryUser.getEmail());
        assertNull(actualLibraryUser.getName());
        assertNull(actualLibraryUser.getRegDate());
        assertEquals(0, actualLibraryUser.getUserId());
    }
    @Test
    void testConstructor1() {
        LibraryUser actualLibraryUser = new LibraryUser(LocalDate.parse("1991-12-02"), "Leo", "leo@gmail.com");

        assertEquals("leo@gmail.com", actualLibraryUser.getEmail());
        assertEquals("1991-12-02", actualLibraryUser.getRegDate().toString());
        assertEquals("Leo", actualLibraryUser.getName());
    }

    @Test
    void testSetUserId() {
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setUserId(1);
        assertEquals(1, libraryUser.getUserId());
    }
    @Test
    void testSetUserId2() {
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.parse("1991-12-02"));
        libraryUser.setUserId(-1);
        assertThrows(IllegalArgumentException.class, () -> libraryUser.setUserId(1));
    }




    @Test
    void testSetRegDate() {
        LibraryUser libraryUser = new LibraryUser();
        LocalDate ofResult = LocalDate.parse("1991-12-02");
        libraryUser.setRegDate(ofResult);
        assertSame(ofResult, libraryUser.getRegDate());
    }
    @Test
    void testSetRegDate2() {
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.parse("1991-12-02"));
        libraryUser.setUserId(1);
        assertThrows(IllegalArgumentException.class, () -> libraryUser.setRegDate(null));
    }




    @Test
    void testSetName() {
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setName("Leo");
        assertEquals("Leo", libraryUser.getName());
    }
    @Test
    void testSetName2() {
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.parse("1991-12-02"));
        libraryUser.setUserId(1);
        assertThrows(IllegalArgumentException.class, () -> libraryUser.setName(null));
    }
    @Test
    void testSetName3() {
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.parse("1991-12-02"));
        libraryUser.setUserId(1);
        assertThrows(IllegalArgumentException.class, () -> libraryUser.setName(""));
    }




    @Test
    void testSetEmail() {
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        assertEquals("leo@gmail.com", libraryUser.getEmail());
    }
    @Test
    void testSetEmail2() {
        assertThrows(IllegalArgumentException.class, () -> (new LibraryUser()).setEmail(""));
    }
    @Test
    void testSetEmail3() {
        assertThrows(IllegalArgumentException.class, () -> (new LibraryUser()).setEmail(null));
    }
}

