package com.mk.order.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class OrderUtility {

    @Autowired
    private ResourceLoader resourceLoader;

    public void loadOrders() throws IOException {

    }

    public void loadProducts() throws IOException {
        File file = new ClassPathResource("products.json").getFile();
        String products = new String(Files.readAllBytes(file.toPath()));
        System.out.println(products);
    }
}
