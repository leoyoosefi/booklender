package se.lexicon.leo.booklender.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class LibraryUserDtoTest {

    @Test
    void testConstructor() {
        LibraryUserDto actualLibraryUserDto = new LibraryUserDto();
        assertNull(actualLibraryUserDto.getEmail());
        assertEquals(0, actualLibraryUserDto.getId());
        assertNull(actualLibraryUserDto.getName());
        assertNull(actualLibraryUserDto.getRegDate());
    }

    @Test
    void testConstructor2() {
        LibraryUserDto actualLibraryUserDto = new LibraryUserDto(1, LocalDate.parse("1991-12-02"), "Leo",
                "leo@gmail.com");

        assertEquals("leo@gmail.com", actualLibraryUserDto.getEmail());
        assertEquals("1991-12-02", actualLibraryUserDto.getRegDate().toString());
        assertEquals("Leo", actualLibraryUserDto.getName());
        assertEquals(1, actualLibraryUserDto.getId());
    }

    @Test
    void testConstructor3() {
        assertThrows(IllegalArgumentException.class, () -> new LibraryUserDto(0, null, null, null));

    }

    @Test
    void testConstructor4() {
        assertThrows(IllegalArgumentException.class,
                () -> new LibraryUserDto(-1, LocalDate.parse("1991-12-02"), "Leo", "leo@gmail.com"));

    }

    @Test
    void testConstructor5() {
        assertThrows(IllegalArgumentException.class,
                () -> new LibraryUserDto(1, LocalDate.parse("1991-12-02"), "", "leo@gmail.com"));

    }

    @Test
    void testConstructor6() {
        assertThrows(IllegalArgumentException.class,
                () -> new LibraryUserDto(1, LocalDate.parse("1991-12-02"), null, "leo@gmail.com"));

    }

    @Test
    void testConstructor7() {
        assertThrows(IllegalArgumentException.class, () -> new LibraryUserDto(1, LocalDate.parse("1991-12-02"), "Leo", ""));

    }

    @Test
    void testConstructor8() {
        assertThrows(IllegalArgumentException.class, () -> new LibraryUserDto(1, LocalDate.parse("1991-12-02"), "Leo", null));

    }




    @Test
    void testSetId() {
        LibraryUserDto libraryUserDto = new LibraryUserDto();
        libraryUserDto.setId(1);
        assertEquals(1, libraryUserDto.getId());
    }

    @Test
    void testSetId2() {
        assertThrows(IllegalArgumentException.class, () -> (new LibraryUserDto()).setId(-1));
    }




    @Test
    void testSetRegDate() {
        LibraryUserDto libraryUserDto = new LibraryUserDto();
        LocalDate ofDayResult = LocalDate.parse("1991-12-02");
        libraryUserDto.setRegDate(ofDayResult);
        assertSame(ofDayResult, libraryUserDto.getRegDate());
    }

    @Test
    void testSetRegDate2() {
        assertThrows(IllegalArgumentException.class, () -> (new LibraryUserDto()).setRegDate(null));
    }




    @Test
    void testSetName() {
        LibraryUserDto libraryUserDto = new LibraryUserDto();
        libraryUserDto.setName("Leo");
        assertEquals("Leo", libraryUserDto.getName());
    }

    @Test
    void testSetName2() {
        assertThrows(IllegalArgumentException.class, () -> (new LibraryUserDto()).setName(null));
    }

    @Test
    void testSetName3() {
        assertThrows(IllegalArgumentException.class, () -> (new LibraryUserDto()).setName(""));
    }




    @Test
    void testSetEmail() {
        LibraryUserDto libraryUserDto = new LibraryUserDto();
        libraryUserDto.setEmail("leo@gmail.com");
        assertEquals("leo@gmail.com", libraryUserDto.getEmail());
    }

    @Test
    void testSetEmail2() {
        assertThrows(IllegalArgumentException.class, () -> (new LibraryUserDto()).setEmail(null));
    }

    @Test
    void testSetEmail3() {
        assertThrows(IllegalArgumentException.class, () -> (new LibraryUserDto()).setEmail(""));
    }
}

