package com.giovaniwahl.investP.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_portfolio_history")
public class PortfolioHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant modificationDate; // Data da modificação

    private UUID portfolioId; // Referência ao ID original do Portfolio
    private String name; // Título da carteira

    private String clientEmail; // Para registrar o usuário dono da carteira na época

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant creationDate; // Data de criação original da carteira

    private String operation; // Tipo de operação (CREATE, UPDATE, DELETE)

    public PortfolioHistory() {}

    public PortfolioHistory(Portfolio portfolio, String operation) {
        this.portfolioId = portfolio.getId();
        this.name = portfolio.getName();
        this.clientEmail = portfolio.getClient().getEmail();
        this.creationDate = portfolio.getCreationDate();
        this.modificationDate = Instant.now();
        this.operation = operation;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getModificationDate() {
        return modificationDate;
    }
    public void setModificationDate(Instant modificationDate) {
        this.modificationDate = modificationDate;
    }

    public UUID getPortfolioId() {
        return portfolioId;
    }
    public void setPortfolioId(UUID portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getClientEmail() {
        return clientEmail;
    }
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public Instant getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PortfolioHistory that = (PortfolioHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

