package se.lexicon.leo.booklender.model.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "loans")
public class Loan
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loanId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private LibraryUser loanTaker; // changed cascade from cascade.all to the correct fetch options

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    private Book book; // changed cascade from cascade.all to the correct fetch options

    LocalDate loanDate;

    @Column(name = "concluded")
    boolean terminated; //added new column name instead of terminated

    public Loan(LibraryUser loanTaker, Book book, LocalDate loanDate) {
        setLoanTaker(loanTaker);
        setBook(book);
        setLoanDate(loanDate);
        setTerminated(false);  //applied chain constructor for set
    }

    public boolean isOverDue() {
        LocalDate dueDate = loanDate.plusDays(book.getMaxLoanDays());
        return LocalDate.now().isAfter(dueDate);
    }

    public BigDecimal getFine() {
        Period period = Period.between(loanDate.plusDays(book.getMaxLoanDays()), LocalDate.now());
        int daysOverdue = period.getDays();
        BigDecimal fine = BigDecimal.ZERO;
        if (daysOverdue > 0)
            fine = BigDecimal.valueOf(daysOverdue * book.getFinePerDay().longValue());
        return fine;
    }

    public boolean extendLoan(int days) {
        if (book.isReserved() || isOverDue()) return false;
        if (days > book.getMaxLoanDays()) return false;

        setLoanDate(getLoanDate().plusDays(days));
        return true;
    }

    public void returnBook() {
        this.book.setAvailable(true);
        this.terminated = true;
    }





}
