package com.example.homework.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sales")
@SequenceGenerator(name = "salesIDgenerator", sequenceName = "sales_id_seq", allocationSize = 1)
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salesIDgenerator")
    private Integer id;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "sell_price")
    private Double sellPrice;
    @Column(name = "sale_date")
    private LocalDateTime saleDate;


    public Sale(Product product) {
        productId = product.getEan();
        sellPrice = product.getSellPrice();
        saleDate = LocalDateTime.now();
    }
}

