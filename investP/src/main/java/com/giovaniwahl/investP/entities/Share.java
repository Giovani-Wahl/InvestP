package com.giovaniwahl.investP.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

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
}
