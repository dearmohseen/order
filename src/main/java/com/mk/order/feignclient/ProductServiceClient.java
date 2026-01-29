package com.mk.order.feignclient;

import com.mk.order.bean.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product", url = "${services.product.url}")
public interface ProductServiceClient {

    @GetMapping
    List<ProductBean> getProducts();

    @GetMapping("/{id}")
    ProductBean getProduct(@PathVariable("id") Long id);
}
