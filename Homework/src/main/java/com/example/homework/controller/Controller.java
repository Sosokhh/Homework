package com.example.homework.controller;

import com.example.homework.model.Product;
import com.example.homework.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("products")
public class Controller {


    private final ProductsService productsService;


    @GetMapping
    public List<Product> getProducts(String product_Name) {
        return productsService.getProducts(product_Name);
    }


    @PostMapping
    public ResponseEntity<Void> AddNewProducts(@RequestBody Product product) {
        try {
            var e = productsService.AddNewProducts(product);
            return ResponseEntity.created(new URI("/product/" + e.getEan())).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("{ean}")
    public ResponseEntity<Product> getproduct(@PathVariable String ean) {
        try {
            var product = productsService.getProduct(ean);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{ean}")
    public ResponseEntity<Void> deletePerson(@PathVariable String ean) {
        try {
            productsService.delete(ean);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/{ean}/sales")
    public ResponseEntity<Void> postsales(@PathVariable String ean) {
        try {
            var e = productsService.salesproducts(ean);
            return ResponseEntity.created(new URI("/orders/" + e.getId())).build();
        } catch (NoSuchElementException ignore) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }


}