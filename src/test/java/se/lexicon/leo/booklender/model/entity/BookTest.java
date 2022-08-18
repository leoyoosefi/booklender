package se.lexicon.leo.booklender.model.entity;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookTest
{
    Book testObject;

    @BeforeAll
    void setup()
    {
        testObject = new Book("Book", 7, new BigDecimal(7), "TEST TEST TEST");
    }

    @Test
    @Order(1)
    void GetTotalAdditionalDays()
    {
        int expected = 7;
        testObject.setAdditionalLoanDays(7);

        Assertions.assertEquals(testObject.getTotalLoanDays(), expected);
    }
}
