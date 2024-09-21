package com.giovaniwahl.investP.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Long cnpj;

    private String symbol; // Código de negociação (ticker)
    private String currency; // Moeda (ex: "BRL")
    private String shortName; // Nome curto da empresa
    private String longName;  // Nome longo da empresa
    private String isinCode;  // Código ISIN
    private Long regularMarketPrice; // Preço atual
    private String logoUrl; // URL do logo

    public Product() {}

    public Product(UUID id, Long cnpj, String symbol, String currency, String shortName, String longName,
                   String isinCode, Long regularMarketPrice, String logoUrl) {
        this.id = id;
        this.cnpj = cnpj;
        this.symbol = symbol;
        this.currency = currency;
        this.shortName = shortName;
        this.longName = longName;
        this.isinCode = isinCode;
        this.regularMarketPrice = regularMarketPrice;
        this.logoUrl = logoUrl;
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public Long getCnpj() {
        return cnpj;
    }
    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getShortName() {
        return shortName;
    }
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }
    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getIsinCode() {
        return isinCode;
    }
    public void setIsinCode(String isinCode) {
        this.isinCode = isinCode;
    }

    public Long getRegularMarketPrice() {
        return regularMarketPrice;
    }
    public void setRegularMarketPrice(Long regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public String getLogoUrl() {
        return logoUrl;
    }
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
