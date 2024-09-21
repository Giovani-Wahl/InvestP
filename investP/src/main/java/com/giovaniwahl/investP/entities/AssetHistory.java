package com.giovaniwahl.investP.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_asset_history")
public class AssetHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant modificationDate; // Data da modificação

    private UUID assetId; // Referência ao ID original do Asset
    private UUID portfolioId; // Referência ao ID da carteira onde o ativo estava
    private UUID productId; // Produto relacionado ao ativo

    private Long amount; // Quantidade de cotas
    private BigDecimal averagePrice; // Preço médio
    private BigDecimal totalPrice; // Preço total
    private Instant purchaseDate; // Data de compra

    private String operation; // Tipo de operação (CREATE, UPDATE, DELETE)

    public AssetHistory() {}

    public AssetHistory(Asset asset, String operation) {
        this.assetId = asset.getId();
        this.portfolioId = asset.getWallet().getId();
        this.productId = asset.getAsset().getId();
        this.amount = asset.getAmount();
        this.averagePrice = asset.getAveragePrice();
        this.totalPrice = asset.getTotalPrice();
        this.purchaseDate = asset.getPurchaseDate();
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

    public UUID getAssetId() {
        return assetId;
    }
    public void setAssetId(UUID assetId) {
        this.assetId = assetId;
    }

    public UUID getPortfolioId() {
        return portfolioId;
    }
    public void setPortfolioId(UUID portfolioId) {
        this.portfolioId = portfolioId;
    }

    public UUID getProductId() {
        return productId;
    }
    public void setProductId(UUID productId) {
        this.productId = productId;
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

        AssetHistory that = (AssetHistory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

