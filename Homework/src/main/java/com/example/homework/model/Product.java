package com.example.homework.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column (name = "ean_code")
    private String ean;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "description")
    private String description;
    @Column(name = "maker_id")
    private Integer makeRid;
    @Column(name = "category_id")
    private Integer categorYid;
    @Column(name = "sell_price")
    private Double sellPrice;
    @Column(name = "remaining")
    private Integer remaining;

}







