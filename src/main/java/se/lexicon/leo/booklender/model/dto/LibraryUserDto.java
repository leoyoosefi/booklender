package se.lexicon.leo.booklender.model.dto;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LibraryUserDto {
    private int id;
    private LocalDate regDate;
    private String name;
    private String email;

    public LibraryUserDto(int id, LocalDate regDate, String name, String email) {
        setId(id);
        setRegDate(regDate);
        setName(name);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id<0) throw new IllegalArgumentException("id has to be zero or more");
        this.id = id;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        if(regDate==null) throw new IllegalArgumentException("regDate is null");
        this.regDate = regDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name==null || name.equals("")) throw new IllegalArgumentException("name is empty or null");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email==null || email.equals("")) throw new IllegalArgumentException("email is empty or null");
        this.email = email;
    }
}
