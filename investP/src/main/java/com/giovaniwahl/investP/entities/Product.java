package com.giovaniwahl.investP.entities;

import jakarta.persistence.*;

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
}
