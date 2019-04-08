package com.merenaas.models;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


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

    @NonNull
    private String author;

    @Column
    @NotNull
    private String path;

    @Column
    private String description;
}
