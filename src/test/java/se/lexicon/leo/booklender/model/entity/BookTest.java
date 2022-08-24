package se.lexicon.leo.booklender.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class BookTest {
    @Test
    void testConstructor() {
        Book actualBook = new Book();
        actualBook.setAvailable(true);
        actualBook.setReserved(true);
        assertEquals(0, actualBook.getBookId());
        assertNull(actualBook.getDescription());
        assertNull(actualBook.getFinePerDay());
        assertEquals(20, actualBook.getMaxLoanDays());
        assertNull(actualBook.getTitle());
        assertTrue(actualBook.isAvailable());
        assertTrue(actualBook.isReserved());
    }

    @Test
    void testConstructor2() {
        Book actualBook = new Book();
        assertFalse(actualBook.isReserved());
        assertTrue(actualBook.isAvailable());
        assertEquals(20, actualBook.getMaxLoanDays());
    }
    @Test
    void testConstructor3() {
        BigDecimal valueOfResult = BigDecimal.valueOf(1L);
        Book actualBook = new Book("Book1", 3, valueOfResult, "Most books are boring!");

        assertFalse(actualBook.isReserved());
        assertTrue(actualBook.isAvailable());
        assertEquals("Book1", actualBook.getTitle());
        assertEquals(3, actualBook.getMaxLoanDays());
        BigDecimal expectedFinePerDay = BigDecimal.ONE;
        BigDecimal finePerDay = actualBook.getFinePerDay();
        assertSame(expectedFinePerDay, finePerDay);
        assertEquals("Most books are boring!", actualBook.getDescription());
        assertEquals("1", finePerDay.toString());
    }
   @Test
    void testConstructor4() {
        BigDecimal valueOfResult = BigDecimal.valueOf(1L);
        Book actualBook = new Book("Book1", true, true, 3, valueOfResult, "Most books are boring!");

        assertTrue(actualBook.isReserved());
        assertTrue(actualBook.isAvailable());
        assertEquals("Book1", actualBook.getTitle());
        assertEquals(3, actualBook.getMaxLoanDays());
        BigDecimal expectedFinePerDay = BigDecimal.ONE;
        BigDecimal finePerDay = actualBook.getFinePerDay();
        assertSame(expectedFinePerDay, finePerDay);
        assertEquals("Most books are boring!", actualBook.getDescription());
        assertEquals("1", finePerDay.toString());


    }
    @Test
    void testSetBookId() {
        Book book = new Book();
        book.setBookId(123);
        assertEquals(123, book.getBookId());
    }
    @Test
    void testSetBookId2() {
        assertThrows(IllegalArgumentException.class, () -> (new Book()).setBookId(-1));
    }


    @Test
    void testSetTitle() {
        Book book = new Book();
        book.setTitle("Book1");
        assertEquals("Book1", book.getTitle());
    }
    @Test
    void testSetTitle2() {
        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("Most books suck!");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("Book1");
        assertThrows(IllegalArgumentException.class, () -> book.setTitle(null));
    }
    @Test
    void testSetTitle3() {
        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("Most books suck!");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("Book1");
        assertThrows(IllegalArgumentException.class, () -> book.setTitle(""));
    }
    @Test
    void testSetMaxLoanDays() {
        Book book = new Book();
        book.setMaxLoanDays(3);
        assertEquals(3, book.getMaxLoanDays());
    }

    @Test
    void testSetMaxLoanDays2() {
        assertThrows(IllegalArgumentException.class, () -> (new Book()).setMaxLoanDays(-1));
    }

    @Test
    void testSetFinePerDay() {
        Book book = new Book();
        BigDecimal valueOfResult = BigDecimal.valueOf(1L);
        book.setFinePerDay(valueOfResult);
        assertSame(valueOfResult, book.getFinePerDay());
    }

    @Test
    void testSetFinePerDay2() {
        Book book = new Book();
        assertThrows(IllegalArgumentException.class, () -> book.setFinePerDay(BigDecimal.valueOf(0L)));
    }
    @Test
    void testSetDescription() {
        Book book = new Book();
        book.setDescription("Most books are boring!");
        assertEquals("Most books are boring!", book.getDescription());
    }

    @Test
    void testSetDescription2() {
        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("Most books are boring!");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("Book1");
        assertThrows(IllegalArgumentException.class, () -> book.setDescription(null));
    }

}

