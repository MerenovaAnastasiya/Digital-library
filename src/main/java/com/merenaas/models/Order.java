package com.merenaas.models;
import lombok.*;
//import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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

    @Column
    @NotNull
    private String address;

    @Column(name = "date_of_order", columnDefinition = "date")
    private LocalDate dateOfOrder;

    @Column(name = "date_of_delivery", columnDefinition = "date")
    private LocalDate dateOfDelivery;

    @Column(name = "date_of_return", columnDefinition = "date")
    private LocalDate dateOfReturn;

    @Column
    private String comment;

    @Enumerated(EnumType.STRING)
    private OrderStatusEnum status;
}
