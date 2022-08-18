package se.lexicon.leo.booklender.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@EqualsAndHashCode

@Entity
@Table(name = "library_users")
public class LibraryUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private LocalDate regDate;

    private String name;

    @Column(unique = true)
    private String email;

    public LibraryUser(LocalDate regDate, String name, String email)
    {
        this.regDate = regDate;
        this.name = name;
        this.email = email;
    }

    public LibraryUser() {

    }

    public Integer getUserId()
    {
        return userId;
    }

    public LocalDate getRegDate()
    {
        return regDate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}