package com.alibaba.finnova.sample.Domains;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String socialSecurity;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

}
