package com.giovaniwahl.investP.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_asset")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product asset; // Produto

    private Long amount; // Quantidade de cotas
    private BigDecimal averagePrice; // Preço médio
    private BigDecimal totalPrice; // Preço total

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant purchaseDate; // Data de compra

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio wallet; // Carteira que contém o ativo

    public Asset() {}

    public Asset(UUID id, Product asset, Long amount, BigDecimal averagePrice, BigDecimal totalPrice,
                 Instant purchaseDate, Portfolio wallet) {
        this.id = id;
        this.asset = asset;
        this.amount = amount;
        this.averagePrice = averagePrice;
        this.totalPrice = totalPrice;
        this.purchaseDate = purchaseDate;
        this.wallet = wallet;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public Product getAsset() {
        return asset;
    }
    public void setAsset(Product asset) {
        this.asset = asset;
    }

    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }
    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Instant getPurchaseDate() {
        return purchaseDate;
    }
    public void setPurchaseDate(Instant purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Portfolio getWallet() {
        return wallet;
    }
    public void setWallet(Portfolio wallet) {
        this.wallet = wallet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;
        return Objects.equals(id, asset.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
