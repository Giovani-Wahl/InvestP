package com.giovaniwahl.investP.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_share") // Ativo
public class Share extends Asset {

    private BigDecimal dividendYield; // calculado com base nos proventos dos ultimos 12 meses
    private BigDecimal dividendMonthly; // dividendo referente o meses
    private BigDecimal jcpMonthly; // JCP referente o meses
    private BigDecimal totalDividend; // soma total de dividendos recebidos desde a data que aquisição
    private BigDecimal profitabilityMonthly; // rentabilidade do mes calculada dividindo o valor do dividendo mensal pelo valor total investido no fundo
    private BigDecimal profitabilityAverage; // rentabilidade media dos ultimos 12 meses
    private BigDecimal assetValue; // preço medio descontado do dividendo recebidos

    public Share() {}

    public Share(UUID id, Product asset, Long amount, BigDecimal averagePrice, BigDecimal totalPrice,
                 Instant purchaseDate, Portfolio wallet, BigDecimal dividendYield, BigDecimal dividendMonthly,
                 BigDecimal jcpMonthly, BigDecimal totalDividend, BigDecimal profitabilityMonthly,
                 BigDecimal profitabilityAverage, BigDecimal assetValue) {
        super(id, asset, amount, averagePrice, totalPrice, purchaseDate, wallet);
        this.dividendYield = dividendYield;
        this.dividendMonthly = dividendMonthly;
        this.jcpMonthly = jcpMonthly;
        this.totalDividend = totalDividend;
        this.profitabilityMonthly = profitabilityMonthly;
        this.profitabilityAverage = profitabilityAverage;
        this.assetValue = assetValue;
    }

    public BigDecimal getDividendYield() {
        return dividendYield;
    }
    public void setDividendYield(BigDecimal dividendYield) {
        this.dividendYield = dividendYield;
    }

    public BigDecimal getDividendMonthly() {
        return dividendMonthly;
    }
    public void setDividendMonthly(BigDecimal dividendMonthly) {
        this.dividendMonthly = dividendMonthly;
    }

    public BigDecimal getJcpMonthly() {
        return jcpMonthly;
    }
    public void setJcpMonthly(BigDecimal jcpMonthly) {
        this.jcpMonthly = jcpMonthly;
    }

    public BigDecimal getTotalDividend() {
        return totalDividend;
    }
    public void setTotalDividend(BigDecimal totalDividend) {
        this.totalDividend = totalDividend;
    }

    public BigDecimal getProfitabilityMonthly() {
        return profitabilityMonthly;
    }
    public void setProfitabilityMonthly(BigDecimal profitabilityMonthly) {
        this.profitabilityMonthly = profitabilityMonthly;
    }

    public BigDecimal getProfitabilityAverage() {
        return profitabilityAverage;
    }
    public void setProfitabilityAverage(BigDecimal profitabilityAverage) {
        this.profitabilityAverage = profitabilityAverage;
    }

    public BigDecimal getAssetValue() {
        return assetValue;
    }
    public void setAssetValue(BigDecimal assetValue) {
        this.assetValue = assetValue;
    }
}
