package com.giovaniwahl.investP.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
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

    public Portfolio() {}

    public Portfolio(UUID id, String name, User client, Instant creationDate) {
        this.id = id;
        this.name = name;
        this.client = client;
        this.creationDate = creationDate;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }

    public Instant getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Asset> getAssets() {
        return assets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Portfolio portfolio = (Portfolio) o;
        return Objects.equals(id, portfolio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
