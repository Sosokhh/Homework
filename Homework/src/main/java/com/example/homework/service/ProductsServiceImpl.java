package com.example.homework.service;

import com.example.homework.model.Product;
import com.example.homework.model.Sale;
import com.example.homework.repository.ProductsRepository;
import com.example.homework.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {


    private final ProductsRepository productsRepository;
    private final SalesRepository salesRepository;


    public Product get(String ean_code) {
        return productsRepository.findById(ean_code).orElseThrow();

    }


    public List<Product> getProducts(String product_Name) {

        return productsRepository.findAll();
    }


    public Product AddNewProducts(Product product) {
        return productsRepository.save(product);

    }

    public void delete(String id)  {

        productsRepository.delete(get(id));
    }

    @Override
    public Sale salesproducts(String ean) {
        var product = productsRepository.findById(ean).orElseThrow();
        if (product.getRemaining() < 1) {
            throw new NoSuchElementException("No value present");
        }
        var sale = salesRepository.save(new Sale(product));
        product.setRemaining(product.getRemaining() - 1);
        productsRepository.save(product);
        return sale;
    }

    @Override
    public Product getProduct(String ean) {
        return productsRepository.findById(ean).orElseThrow();
    }

}