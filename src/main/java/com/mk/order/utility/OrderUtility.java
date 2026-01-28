package com.mk.order.utility;

import com.mk.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class OrderUtility {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    ProductRepository productRepository;

    public void loadOrders() throws IOException {

    }

    public void initializeData() throws IOException {
        File file = new ClassPathResource("static/products.json").getFile();
        String productsString = new String(Files.readAllBytes(file.toPath()));

        ObjectMapper mapper = new ObjectMapper();
//        List<Product> products = mapper.readValue(productsString, new TypeReference<List<Product>>() {
//        });
//        products.forEach(p -> {
//            productRepository.save(p);
//        });
    }
}
