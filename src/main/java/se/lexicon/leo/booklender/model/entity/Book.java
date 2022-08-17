package se.lexicon.leo.booklender.model.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoanDays;
    private BigDecimal finePerDay;
    private String description;




    public Book(String title, int maxLoanDays, BigDecimal finePerDay, String description) {
        this.title = title;
        this.maxLoanDays = maxLoanDays;
        this.finePerDay = finePerDay;
        this.description = description;
    }

}
