package com.merenaas.models;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@ToString(exclude = "user")
@Data
@Entity
@NoArgsConstructor
@Table(name="library_order")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(name = "order_book",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")})
    private Set<Book> books;
//
//    @Column
//    @NotNull
//    private String address;

//    @Column
//    @NotNull
//    private LocalDate date;
//
//    @Column(name = "user_first_name")
//    private String userFirstName;
//
//    @Column(name = "user_last_name")
//    private String userLastName;
//
//    @Column
//    @NotNull
//    private String phone;
//
//    @Column
//    @NotNull
//    private String email;
//
//    @Column
//    private String comment;
}
