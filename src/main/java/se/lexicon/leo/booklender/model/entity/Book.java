package se.lexicon.leo.booklender.model.entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "books")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String title;

    private boolean available = true;

    private boolean reserved = false;

    private int maxLoanDays;

    private int additionalLoanDays;

    private BigDecimal finePerDay;

    private String description;


    public Book() {
    }

    public Book(String title, int maxLoanDays, BigDecimal finePerDay, String description) {
        setTitle(title);
        setMaxLoanDays(maxLoanDays);
        setFinePerDay(finePerDay);
        setDescription(description);
        setAvailable(true);
        setReserved(false);
    }

    public int getBookId()
    {
        return bookId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    public boolean isReserved()
    {
        return reserved;
    }

    public void setReserved(boolean reservedStatus)
    {
        this.reserved = reservedStatus;
    }

    public int getMaxLoanDays()
    {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays)
    {
        this.maxLoanDays = maxLoanDays;
    }

    public int getAdditionalLoanDays()
    {
        return additionalLoanDays;
    }

    public void setAdditionalLoanDays(int additionalLoanDays)
    {
        this.additionalLoanDays = additionalLoanDays;
    }

    public int getTotalLoanDays()
    {
        return maxLoanDays + additionalLoanDays;
    }

    public BigDecimal getFinePerDay()
    {
        return finePerDay;
    }

    public void setFinePerDay(BigDecimal finePerDay)
    {
        this.finePerDay = finePerDay;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

}
