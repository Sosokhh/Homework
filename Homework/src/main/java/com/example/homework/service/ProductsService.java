package com.example.homework.service;

import com.example.homework.model.Product;
import com.example.homework.model.Sale;


import java.util.List;

public interface ProductsService {
     List<Product> getProducts(String product_Name);
     Product AddNewProducts(Product product);
     void delete(String ean) throws Exception ;

     Sale salesproducts(String ean_code);

     Product getProduct(String ean);
}
