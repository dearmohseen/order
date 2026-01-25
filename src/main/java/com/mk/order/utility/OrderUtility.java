package com.mk.order.utility;

import com.mk.order.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Component
public class OrderUtility {

    @Autowired
    private ResourceLoader resourceLoader;

    public void loadOrders() throws IOException {

    }

    public void loadProducts() throws IOException {
        File file = new ClassPathResource("static/products.json").getFile();
        String products = new String(Files.readAllBytes(file.toPath()));
        System.out.println(products);
    }

    public void initializeData() throws IOException {
        File file = new ClassPathResource("static/products.json").getFile();
        String productsString = new String(Files.readAllBytes(file.toPath()));

        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = mapper.readValue(productsString, new TypeReference<List<Product>>(){});
        products.forEach(p -> System.out.println(p.getName()));
        //System.out.println(products);
    }
}
