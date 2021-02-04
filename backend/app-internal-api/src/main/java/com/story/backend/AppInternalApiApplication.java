package com.story.backend;

import com.story.backend.address.entity.Address;
import com.story.backend.address.repository.AddressRepository;
import com.story.backend.cart.repository.CartRepository;
import com.story.backend.product.entity.Product;
import com.story.backend.product.entity.ProductSku;
import com.story.backend.product.repository.ProductRepository;
import com.story.backend.product.repository.ProductSkuRepository;
import com.story.backend.user.entity.User;
import com.story.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@SpringBootApplication
public class AppInternalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppInternalApiApplication.class, args);
    }


}