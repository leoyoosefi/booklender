package se.lexicon.leo.booklender.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class LoanDtoTest {

    @Test
    void testConstructor() {
        LoanDto actualLoanDto = new LoanDto();
        actualLoanDto.setConcluded(true);
        assertNull(actualLoanDto.getBook());
        assertEquals(0L, actualLoanDto.getId());
        assertNull(actualLoanDto.getLoanDate());
        assertNull(actualLoanDto.getLoanTaker());
        assertTrue(actualLoanDto.isConcluded());
    }

    @Test
    void testConstructor2() {
        LibraryUserDto libraryUserDto = new LibraryUserDto();
        BookDto bookDto = new BookDto();
        LoanDto actualLoanDto = new LoanDto(123L, libraryUserDto, bookDto, LocalDate.parse("1991-12-02"), true);

        assertSame(bookDto, actualLoanDto.getBook());
        assertTrue(actualLoanDto.isConcluded());
        assertEquals(123L, actualLoanDto.getId());
        assertSame(libraryUserDto, actualLoanDto.getLoanTaker());
        assertEquals("1991-12-02", actualLoanDto.getLoanDate().toString());
    }

    @Test
    void testConstructor3() {
        assertThrows(IllegalArgumentException.class, () -> new LoanDto(1L, null, null, null, true));

    }

    @Test
    void testConstructor4() {
        LibraryUserDto loanTaker = new LibraryUserDto();
        assertThrows(IllegalArgumentException.class,
                () -> new LoanDto(-1L, loanTaker, new BookDto(), LocalDate.parse("1991-12-02"), true));

    }

    @Test
    void testConstructor5() {
        assertThrows(IllegalArgumentException.class,
                () -> new LoanDto(123L, new LibraryUserDto(), null, LocalDate.parse("1991-12-02"), true));

    }

    @Test
    void testConstructor6() {
        LibraryUserDto loanTaker = new LibraryUserDto();
        assertThrows(IllegalArgumentException.class, () -> new LoanDto(123L, loanTaker, new BookDto(), null, true));

    }




    @Test
    void testSetId() {
        LoanDto loanDto = new LoanDto();
        loanDto.setId(123L);
        assertEquals(123L, loanDto.getId());
    }

    @Test
    void testSetId2() {
        assertThrows(IllegalArgumentException.class, () -> (new LoanDto()).setId(-1L));
    }





    @Test
    void testSetLoanTaker() {
        LoanDto loanDto = new LoanDto();
        LibraryUserDto libraryUserDto = new LibraryUserDto();
        loanDto.setLoanTaker(libraryUserDto);
        assertSame(libraryUserDto, loanDto.getLoanTaker());
    }

    @Test
    void testSetLoanTaker2() {
        assertThrows(IllegalArgumentException.class, () -> (new LoanDto()).setLoanTaker(null));
    }






    @Test
    void testSetBook() {
        LoanDto loanDto = new LoanDto();
        BookDto bookDto = new BookDto();
        loanDto.setBook(bookDto);
        assertSame(bookDto, loanDto.getBook());
    }

    @Test
    void testSetBook2() {
        assertThrows(IllegalArgumentException.class, () -> (new LoanDto()).setBook(null));
    }






    void testSetLoanDate() {
        LoanDto loanDto = new LoanDto();
        LocalDate ofDayResult = LocalDate.parse("1991-12-02");
        loanDto.setLoanDate(ofDayResult);
        assertSame(ofDayResult, loanDto.getLoanDate());
    }

    @Test
    void testSetLoanDate2() {
        assertThrows(IllegalArgumentException.class, () -> (new LoanDto()).setLoanDate(null));
    }
}

