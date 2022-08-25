package se.lexicon.leo.booklender.model.dto;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class BookDto {
    private int bookId;
    private String title;
    private boolean available;
    private boolean reserved;
    private int maxLoanDays;
    private BigDecimal finePerDay;
    private String description;

    public BookDto(int bookId, String title, boolean available, boolean reserved, int maxLoanDays, BigDecimal finePerDay, String description) {
        setBookId(bookId);
        setTitle(title);
        setAvailable(available);
        setReserved(reserved);
        setMaxLoanDays(maxLoanDays);
        setFinePerDay(finePerDay);
        setDescription(description);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        if(bookId<0) throw new IllegalArgumentException("bookId must be zero or more:"+ bookId );
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title==null || title.equals("")) throw new IllegalArgumentException("title is null or empty");
        this.title = title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public int getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(int maxLoanDays) {
        if (maxLoanDays < 0) throw new IllegalArgumentException("maxLoanDats must be zero or more");
        this.maxLoanDays = maxLoanDays;
    }

    public BigDecimal getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(BigDecimal finePerDay) {
        if (finePerDay.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("finePerDay must be zero or more");
        this.finePerDay = finePerDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description==null || description.equals("")) throw new IllegalArgumentException("description is null or empty");
        this.description = description;
    }
}

