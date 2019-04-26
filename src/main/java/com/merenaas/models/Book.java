package com.merenaas.models;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Data
@NoArgsConstructor
//@Builder
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name="book_name")
    private String bookName;

    @Column
    @NotNull
    private String path;

    @Column
    private String description;

    @Column(name ="isbn_10")
    private String ISBN10;

    @Column(name ="isbn_13")
    private String ISBN13;

    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors;
}
