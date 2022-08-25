package se.lexicon.leo.booklender.model.dto;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LoanDto {
    private long id;
    private LibraryUserDto loanTaker;
    private BookDto book;
    private LocalDate loanDate;
    private boolean concluded;

    public LoanDto(long id, LibraryUserDto loanTaker, BookDto book, LocalDate loanDate, boolean concluded) {
        setId(id);
        setLoanTaker(loanTaker);
        setBook(book);
        setLoanDate(loanDate);
        setConcluded(concluded);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if(id<0) throw new IllegalArgumentException("id must be zero or more");
        this.id = id;
    }

    public LibraryUserDto getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUserDto loanTaker) {
        if(loanTaker==null )throw new IllegalArgumentException("loanTaker is null");
        this.loanTaker = loanTaker;
    }

    public BookDto getBook() {
        return book;
    }

    public void setBook(BookDto book) {
        if(book==null) throw new IllegalArgumentException("book is null");
        this.book = book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        if(loanDate==null) throw new IllegalArgumentException("loanDate is null");
        this.loanDate = loanDate;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public void setConcluded(boolean concluded) {
        this.concluded = concluded;
    }
}
