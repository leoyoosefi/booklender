package se.lexicon.leo.booklender.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanId;
    @ManyToOne
    @JoinColumn(name = "loan_taker_id")
    private LibraryUser loanTaker;
    @ManyToOne
    @JoinColumn(name = "book_book_id")
    private Book book;
    private LocalDate loanDate;
    private boolean concluded;

    public Loan(LibraryUser loanTaker, Book book, LocalDate loanDate, boolean concluded) {
        this.loanTaker = loanTaker;
        this.book = book;
        this.loanDate = loanDate;
        this.concluded = concluded;
    }

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public LibraryUser getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker) {
        this.loanTaker = loanTaker;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public void setConcluded(boolean concluded) {
        this.concluded = concluded;
    }
}
