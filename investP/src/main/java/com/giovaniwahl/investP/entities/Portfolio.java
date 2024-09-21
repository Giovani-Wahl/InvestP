package com.giovaniwahl.investP.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name; // Nome da carteira

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User client; // Usuario ao qual a carteira pertence

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant creationDate; // Data de criação da carteira

    @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Asset> assets = new HashSet<>(); // Lista de ativos na carteira
}
