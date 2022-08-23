package se.lexicon.leo.booklender.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class LibraryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int userId;
    @Column(nullable = false)
    private LocalDate regDate;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;


    public LibraryUser(LocalDate regDate, String name, String email) {
        setRegDate(regDate);
        setName(name);
        setEmail(email);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        if (userId < 0) throw new IllegalArgumentException("id is zero or more");
        this.userId = id;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        if (regDate == null) throw new IllegalArgumentException("regDate is null");
        this.regDate = regDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("name is null");
        if (name.equals("")) throw new IllegalArgumentException("name is empty");

        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) throw new IllegalArgumentException("email is null");
        if (email.equals("")) throw new IllegalArgumentException("email is empty");

        this.email = email;
    }
}