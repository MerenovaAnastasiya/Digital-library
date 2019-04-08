package com.merenaas.models;

import lombok.*;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@ToString(exclude = "basket")
@EqualsAndHashCode(exclude = "basket")
@Data
@Entity
@NoArgsConstructor
@Table(name="library_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column
    @NotNull
    private String login;

    @Column
    @NotNull
    private String phoneNumber;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Order> orders;

    @Column
    private String uuid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Basket basket;
}

