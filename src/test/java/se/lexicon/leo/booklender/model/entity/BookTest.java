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
        testObject = new Book("BookTest", 10, new BigDecimal(10), "TEST TEST TEST");
    }

    @Test
    @Order(1)
    void GetTotalAdditionalDays()
    {
        int expected = 20;
        testObject.setAdditionalLoanDays(10);

        Assertions.assertEquals(testObject.getTotalLoanDays(), expected);
    }
}