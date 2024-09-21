package com.giovaniwahl.investP.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch =FetchType.LAZY )
    private Set<Portfolio> wallets = new HashSet<>();
}
