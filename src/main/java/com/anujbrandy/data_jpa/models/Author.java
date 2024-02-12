package com.anujbrandy.data_jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
//@Table(
//        name="author_tbl"
//)
@NamedQueries(
        {
                @NamedQuery(
                        name="Author.findByNamedQuery",
                        query = "select a from Author a where a.age >= :age"
                ),
                @NamedQuery(
                        name="Author.updateByNamedQuery",
                        query="update Author a set a.age = :age where a.id = :authorId"
                )
        }
)
public class Author extends BaseEntity {
    @Column(
            length = 30
    )
    private String firstName;

    private String lastName;

    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;

    @ManyToMany(
            mappedBy = "authors"
    )
    private List<Course> courses;

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
