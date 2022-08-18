package se.lexicon.leo.booklender.model.entity;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoanTest
{
    Loan isOverdue;
    Loan isNotOverdue;

    @BeforeAll
    void setup()
    {
        isOverdue = new Loan(new LibraryUser(LocalDate.now(), "Leo", "L@gmail.com")
                , new Book("BookTest", 10, new BigDecimal(10), "TEST TEST TEST!")
                , LocalDate.now().minusDays(10), false);

        isNotOverdue = new Loan(new LibraryUser(LocalDate.now(), "Leo", "L@gmail.com")
                , new Book("BookTest", 10, new BigDecimal(10), "TEST TEST TEST!")
                , LocalDate.now(), false);
    }

    @Test
    @Order(1)
    void checkOverdueDate()
    {
        Assertions.assertFalse(isOverdue.isOverdue());
    }

    @Test
    @Order(2)
    void checkOverdueFine()
    {
        BigDecimal expected = isOverdue.getBook().getFinePerDay().multiply(new BigDecimal(Period.between(isOverdue.getLoanDate(), LocalDate.now()).getDays()));
        isOverdue.getFine();
        Assertions.assertNotEquals(isOverdue.getFine(), expected);
    }

    @Test
    @Order(3)
    void checkExtendLoanFail()
    {
        Assertions.assertFalse(isOverdue.extendLoan(0));
    }

    @Test
    @Order(4)
    void checkIsNewDate()
    {
        Assertions.assertFalse(isNotOverdue.isOverdue());
    }

    @Test
    @Order(5)
    void checkGetFineWhenNotOverdue()
    {
        BigDecimal expected = new BigDecimal(0);
        isNotOverdue.getFine();
        Assertions.assertEquals(isNotOverdue.getFine(), expected);
    }

    @Test
    @Order(6)
    void checkExtendLoanInitiated()
    {
        Assertions.assertTrue(isNotOverdue.extendLoan(10));
    }

    @Test
    @Order(7)
    void checkExtendLoanForReserved()
    {
        isNotOverdue.getBook().setReserved(true);
        Assertions.assertFalse(isNotOverdue.extendLoan(10));
    }

}
