package com.merenaas.models;
import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Data
public class Book {
    private Long id;
    private String bookName;
    private String author;
    private String path;
    private String description;
}
