package se.lexicon.leo.booklender.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;




@ToString
@EqualsAndHashCode
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private long id;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private LibraryUser loanTaker;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private Book book;
    @Column(nullable = false, updatable = false)
    private LocalDate loanDate = LocalDate.now();
    @Column(nullable = false)
    private boolean concluded;

    public Loan() {
    }

    public Loan(LibraryUser loanTaker, Book book, LocalDate loanDate, boolean concluded) {
        setLoanTaker(loanTaker);
        setBook(book);
        setLoanDate(loanDate);
        setConcluded(concluded);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id < 0) throw new IllegalArgumentException("id must be zero or more");
        this.id = id;
    }

    public LibraryUser getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker) {
        if (loanTaker == null) throw new IllegalArgumentException("loanTaker is null");
        this.loanTaker = loanTaker;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        if (book == null) throw new IllegalArgumentException("book is null");
        if (book.isAvailable()) {
            this.book = book;
            book.setAvailable(false);
        }
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        if (loanDate == null) throw new IllegalArgumentException("loanDate is null");
        this.loanDate = loanDate;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public void setConcluded(boolean concluded) {
        this.concluded = concluded;
    }

    public boolean isOverDue() {
        LocalDate loanDays = LocalDate.of(loanDate.getYear(), loanDate.getMonth(), loanDate.getDayOfMonth()).plusDays(book.getMaxLoanDays());
        return loanDays.compareTo(LocalDate.now()) < 0;
    }

    public boolean extendLoanDays() {
        return !book.isReserved();
    }

    public BigDecimal getFine(){
        if(!isOverDue())  return new BigDecimal(0);
        LocalDateTime loanStartDate = loanDate.atStartOfDay();
        LocalDateTime todayDate = LocalDate.now().atStartOfDay();
        long daysOverDue = Duration.between( loanStartDate, todayDate ).toDays() - book.getMaxLoanDays();
        Double overDueDays = new Double(daysOverDue);
        Double fineForPeriod = new Double(getBook().getFinePerDay().toString()) *overDueDays ;
        return  new BigDecimal(fineForPeriod );
    }
}
