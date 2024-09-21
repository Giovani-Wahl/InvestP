package com.giovaniwahl.investP.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_asset")
@Inheritance(strategy = InheritanceType.JOINED)
public class Asset {

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
}
