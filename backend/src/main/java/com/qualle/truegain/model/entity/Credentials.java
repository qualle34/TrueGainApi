package com.qualle.truegain.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credentials", schema = "public")
public class Credentials {

    @Id
    @Column(name = "user_id")
    private long userId;
    private String login;
    private String email;
    private String role;
    private String password;

    @MapsId
    @OneToOne
    private User user;
}
