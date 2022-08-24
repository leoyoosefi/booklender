package se.lexicon.leo.booklender.model.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class LoanTest {
    @Test
    void testConstructor() {
        Loan actualLoan = new Loan();
        actualLoan.setConcluded(true);
        assertNull(actualLoan.getBook());
        assertEquals(0L, actualLoan.getId());
        assertNull(actualLoan.getLoanTaker());
        assertTrue(actualLoan.isConcluded());
    }
    @Test
    void testConstructor2() {
        Loan actualLoan = new Loan();
        assertNull(actualLoan.getBook());
        assertFalse(actualLoan.isConcluded());
        assertNull(actualLoan.getLoanTaker());
        assertEquals(0L, actualLoan.getId());
    }
    @Test
    void testConstructor3() {
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.ofEpochDay(1L));
        libraryUser.setUserId(1);

        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("book1");
        Loan actualLoan = new Loan(libraryUser, book, LocalDate.ofEpochDay(1L), true);

        Book book1 = actualLoan.getBook();
        assertSame(book, book1);
        assertTrue(actualLoan.isConcluded());
        assertEquals("1970-01-02", actualLoan.getLoanDate().toString());
        assertSame(libraryUser, actualLoan.getLoanTaker());
        assertFalse(book1.isAvailable());
        assertEquals("1", book1.getFinePerDay().toString());
    }

    @Test
    void testConstructor4() {
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.ofEpochDay(1L));
        libraryUser.setUserId(1);

        Book book = new Book();
        book.setAvailable(false);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("Dr");
        Loan actualLoan = new Loan(libraryUser, book, LocalDate.ofEpochDay(1L), true);

        assertTrue(actualLoan.isConcluded());
        assertSame(libraryUser, actualLoan.getLoanTaker());
        assertEquals("1970-01-02", actualLoan.getLoanDate().toString());
    }

    @Test
    void testConstructor5() {
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.ofEpochDay(1L));
        libraryUser.setUserId(1);

        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("Dr");
        assertThrows(IllegalArgumentException.class, () -> new Loan(libraryUser, book, null, true));

    }

    @Test
    void testConstructor6() {
        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("loanTaker is null");
        libraryUser.setRegDate(LocalDate.ofEpochDay(1L));
        libraryUser.setUserId(1);
        assertThrows(IllegalArgumentException.class, () -> new Loan(libraryUser, null, null, true));

    }

    @Test
    void testSetId() {
        Loan loan = new Loan();
        loan.setId(123L);
        assertEquals(123L, loan.getId());
    }

    @Test
    void testSetId2() {
        assertThrows(IllegalArgumentException.class, () -> (new Loan()).setId(-1L));
    }

    @Test
    void testSetLoanTaker() {
        Loan loan = new Loan();

        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.ofEpochDay(1L));
        libraryUser.setUserId(1);
        loan.setLoanTaker(libraryUser);
        assertSame(libraryUser, loan.getLoanTaker());
    }

    @Test
    void testSetLoanTaker2() {
        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("book1");

        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.ofEpochDay(1L));
        libraryUser.setUserId(1);

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setConcluded(true);
        loan.setId(123L);
        loan.setLoanDate(LocalDate.ofEpochDay(1L));
        loan.setLoanTaker(libraryUser);
        assertThrows(IllegalArgumentException.class, () -> loan.setLoanTaker(null));
    }

    @Test
    void testSetBook() {
        Loan loan = new Loan();

        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        BigDecimal valueOfResult = BigDecimal.valueOf(1L);
        book.setFinePerDay(valueOfResult);
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("book1");
        loan.setBook(book);
        assertFalse(book.isAvailable());
        BigDecimal expectedFine = BigDecimal.ZERO;
        assertEquals(expectedFine, loan.getFine());
    }

    @Test
    void testSetBook2() {
        Loan loan = new Loan();

        Book book = new Book();
        book.setAvailable(false);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        BigDecimal valueOfResult = BigDecimal.valueOf(1L);
        book.setFinePerDay(valueOfResult);
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("book1");
        loan.setBook(book);
        assertEquals(123, book.getBookId());
        assertTrue(book.isReserved());
        assertFalse(book.isAvailable());
        assertEquals("book1", book.getTitle());
        assertEquals(3, book.getMaxLoanDays());
        BigDecimal expectedFinePerDay = BigDecimal.ONE;
        assertSame(expectedFinePerDay, book.getFinePerDay());
        assertEquals("This is a very boring book", book.getDescription());
        assertFalse(loan.isConcluded());
        assertEquals(0L, loan.getId());
    }

    @Test
    void testSetLoanDate1() {
        Loan loan = new Loan();
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        loan.setLoanDate(ofEpochDayResult);
        assertSame(ofEpochDayResult, loan.getLoanDate());
    }

    @Test
    void testSetLoanDate2() {
        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("book1");

        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.ofEpochDay(1L));
        libraryUser.setUserId(1);

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setConcluded(true);
        loan.setId(123L);
        loan.setLoanDate(LocalDate.ofEpochDay(1L));
        loan.setLoanTaker(libraryUser);
        assertThrows(IllegalArgumentException.class, () -> loan.setLoanDate(null));
    }

    @Test
    void testIsOverDue1() {

        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("book1");

        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.ofEpochDay(1L));
        libraryUser.setUserId(1);

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setConcluded(true);
        loan.setId(123L);
        loan.setLoanDate(LocalDate.ofEpochDay(1L));
        loan.setLoanTaker(libraryUser);
        loan.isOverDue();
    }

    @Test
    void testIsOverDue2() {
        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("book1");

        Loan loan = new Loan();
        loan.setBook(book);
        assertFalse(loan.isOverDue());
    }


    @Test
    void testExtendLoanDays1() {
        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("book1");

        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.ofEpochDay(1L));
        libraryUser.setUserId(1);

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setConcluded(true);
        loan.setId(123L);
        loan.setLoanDate(LocalDate.ofEpochDay(1L));
        loan.setLoanTaker(libraryUser);
        assertFalse(loan.extendLoanDays());
    }

    @Test
    void testExtendLoanDays2() {
        LibraryUser loanTaker = new LibraryUser();
        assertTrue((new Loan(loanTaker, new Book(), LocalDate.ofEpochDay(1L), true)).extendLoanDays());
    }

    @Test
    void testGetFine1() {

        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("book1");

        LibraryUser libraryUser = new LibraryUser();
        libraryUser.setEmail("leo@gmail.com");
        libraryUser.setName("Leo");
        libraryUser.setRegDate(LocalDate.ofEpochDay(1L));
        libraryUser.setUserId(1);

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setConcluded(true);
        loan.setId(123L);
        loan.setLoanDate(LocalDate.ofEpochDay(1L));
        loan.setLoanTaker(libraryUser);
        loan.getFine();
    }

    @Test
    void testGetFine2() {
        Book book = new Book();
        book.setAvailable(true);
        book.setBookId(123);
        book.setDescription("This is a very boring book");
        book.setFinePerDay(BigDecimal.valueOf(1L));
        book.setMaxLoanDays(3);
        book.setReserved(true);
        book.setTitle("book1");

        Loan loan = new Loan();
        loan.setBook(book);
        assertEquals("0", loan.getFine().toString());
    }

}

