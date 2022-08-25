package se.lexicon.leo.booklender.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class BookDtoTest {


    @Test
    void testConstructor() {
        BookDto actualBookDto = new BookDto();
        actualBookDto.setAvailable(true);
        actualBookDto.setReserved(true);
        assertEquals(0, actualBookDto.getBookId());
        assertNull(actualBookDto.getDescription());
        assertNull(actualBookDto.getFinePerDay());
        assertEquals(0, actualBookDto.getMaxLoanDays());
        assertNull(actualBookDto.getTitle());
        assertTrue(actualBookDto.isAvailable());
        assertTrue(actualBookDto.isReserved());
    }

    @Test
    void testConstructor2() {
        BigDecimal valueOfResult = BigDecimal.valueOf(1L);
        BookDto actualBookDto = new BookDto(123, "book1", true, true, 3, valueOfResult,
                "Ugh...give me a break!");

        assertEquals(123, actualBookDto.getBookId());
        assertTrue(actualBookDto.isReserved());
        assertTrue(actualBookDto.isAvailable());
        assertEquals("book1", actualBookDto.getTitle());
        assertEquals(3, actualBookDto.getMaxLoanDays());
        BigDecimal expectedFinePerDay = BigDecimal.ONE;
        BigDecimal finePerDay = actualBookDto.getFinePerDay();
        assertSame(expectedFinePerDay, finePerDay);
        assertEquals("Ugh...give me a break!", actualBookDto.getDescription());
        assertEquals("1", finePerDay.toString());
    }

    @Test
    void testConstructor3() {
        assertThrows(IllegalArgumentException.class,
                () -> new BookDto(0, null, true, true, 0, BigDecimal.valueOf(1L), null));

    }

    @Test
    void testConstructor4() {
        assertThrows(IllegalArgumentException.class,
                () -> new BookDto(0, "", true, true, 0, BigDecimal.valueOf(1L), null));

    }

    @Test
    void testConstructor5() {
        assertThrows(IllegalArgumentException.class, () -> new BookDto(-1, "book1", true, true, 3, BigDecimal.valueOf(1L),
                "Ugh...give me a break!"));

    }

    @Test
    void testConstructor6() {
        assertThrows(IllegalArgumentException.class, () -> new BookDto(123, "book1", true, true, -1, BigDecimal.valueOf(1L),
                "Ugh...give me a break!"));

    }

    @Test
    void testConstructor7() {
        assertThrows(IllegalArgumentException.class, () -> new BookDto(123, "book1", true, true, 3, BigDecimal.valueOf(0L),
                "Ugh...give me a break!"));

    }

    @Test
    void testConstructor8() {
        assertThrows(IllegalArgumentException.class,
                () -> new BookDto(123, "book1", true, true, 3, BigDecimal.valueOf(1L), ""));

    }

    @Test
    void testConstructor9() {
        assertThrows(IllegalArgumentException.class,
                () -> new BookDto(123, "book1", true, true, 3, BigDecimal.valueOf(1L), null));

    }




    @Test
    void testSetBookId() {
        BookDto bookDto = new BookDto();
        bookDto.setBookId(123);
        assertEquals(123, bookDto.getBookId());
    }

    @Test
    void testSetBookId2() {
        assertThrows(IllegalArgumentException.class, () -> (new BookDto()).setBookId(-1));
    }





    @Test
    void testSetTitle() {
        BookDto bookDto = new BookDto();
        bookDto.setTitle("book1");
        assertEquals("book1", bookDto.getTitle());
    }

    @Test
    void testSetTitle2() {
        assertThrows(IllegalArgumentException.class, () -> (new BookDto()).setTitle(null));
    }

    @Test
    void testSetTitle3() {
        assertThrows(IllegalArgumentException.class, () -> (new BookDto()).setTitle(""));
    }



    @Test
    void testSetMaxLoanDays() {
        BookDto bookDto = new BookDto();
        bookDto.setMaxLoanDays(3);
        assertEquals(3, bookDto.getMaxLoanDays());
    }

    @Test
    void testSetMaxLoanDays2() {
        assertThrows(IllegalArgumentException.class, () -> (new BookDto()).setMaxLoanDays(-1));
    }




    @Test
    void testSetFinePerDay() {
        BookDto bookDto = new BookDto();
        BigDecimal valueOfResult = BigDecimal.valueOf(1L);
        bookDto.setFinePerDay(valueOfResult);
        assertSame(valueOfResult, bookDto.getFinePerDay());
    }

    @Test
    void testSetFinePerDay2() {
        BookDto bookDto = new BookDto();
        assertThrows(IllegalArgumentException.class, () -> bookDto.setFinePerDay(BigDecimal.valueOf(0L)));
    }



    @Test
    void testSetDescription() {
        BookDto bookDto = new BookDto();
        bookDto.setDescription("Ugh...give me a break!");
        assertEquals("Ugh...give me a break!", bookDto.getDescription());
    }

    @Test
    void testSetDescription2() {
        assertThrows(IllegalArgumentException.class, () -> (new BookDto()).setDescription(null));
    }

    @Test
    void testSetDescription3() {
        assertThrows(IllegalArgumentException.class, () -> (new BookDto()).setDescription(""));
    }
}

