package se.lexicon.leo.booklender.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "library_user")
public class LibraryUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate regDate;

    private String name;

    private String email;

    public LibraryUser(LocalDate regDate, String name, String email)
    {
        this.regDate = regDate;
        this.name = name;
        this.email = email;
    }
}
