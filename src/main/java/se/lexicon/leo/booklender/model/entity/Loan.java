package se.lexicon.leo.booklender.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;



@EqualsAndHashCode
@ToString

@Entity
@Table(name = "loans")
public class Loan
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_taker_id")
    private LibraryUser loanTaker;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_book_id")
    private Book book;

    LocalDate loanDate;

    boolean concluded;

    public Loan() {
    }

    public Loan(LibraryUser loanTaker, Book book, LocalDate loanDate, boolean concluded)
    {
        this.loanTaker = loanTaker;
        this.book = book;
        this.loanDate = loanDate;
        this.concluded = concluded;
    }

    public long getLoanId()
    {
        return loanId;
    }

    public LibraryUser getLoanTaker()
    {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker)
    {
        this.loanTaker = loanTaker;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public boolean isOverdue()
    {
        return LocalDate.now().isAfter(getLoanDate().plusDays(book.getTotalLoanDays()));
    }

    public BigDecimal getFine()
    {
        return isOverdue() ? book.getFinePerDay().multiply(new BigDecimal(Period.between(getLoanDate(), LocalDate.now()).getDays())) : new BigDecimal(0);
    }

    public LocalDate getLoanDate()
    {
        return loanDate;
    }

    public boolean isConcluded()
    {
        return concluded;
    }

    public void setConcluded(boolean concluded)
    {
        this.concluded = concluded;
    }

    boolean extendLoan(int days)
    {
        if(book.isReserved() || days <= book.getAdditionalLoanDays())
            return false;

        book.setAdditionalLoanDays(days);
        return true;
    }
}
