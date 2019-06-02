package com.merenaas.models;
import lombok.*;
import java.util.Set;

import javax.persistence.*;



@Data
@NoArgsConstructor
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
    private String description;
    @Column(name ="isbn_10")
    private String isbn10;
    @Column(name ="isbn_13")
    private String isbn13;
    @Column(name="path")
    private String path;
    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    private Set<Author> authors;


}
