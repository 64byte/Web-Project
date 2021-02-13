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
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

@EnableJpaAuditing
@SpringBootApplication
public class AppExternalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppExternalApiApplication.class, args);
    }
}

@Lazy
@Component
class DemoCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;

    private final CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductSkuRepository skuRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DemoCommandLineRunner(UserRepository userRepository, AddressRepository addressRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        User user = new User("123@naver.com", passwordEncoder.encode("123123"), "이름", "01012341234");

        // user.setEmail("123456@naver.com");
        // user.setPassword("flskdfasdf");
        userRepository.save(user);

        Address address = Address.builder()
                .receiverName("준영")
                .receiverEmail("1@1.net")
                .receiverPhoneNum("01012341234")
                .postalCode("01234")
                .address1("dfaefasefff")
                .address2("ererawerafasdfa")
                .user(user)
                .build();

        addressRepository.save(address);

        Address address2 = Address.builder()
                .receiverName("1준영")
                .receiverEmail("2@1.net")
                .receiverPhoneNum("01012341234")
                .postalCode("01234")
                .address1("dfaefasefff")
                .address2("ererawerafasdfa")
                .user(user)
                .build();

        addressRepository.save(address2);

        //      user.addAddress(address);
//        user.addAddress(address2);


        Optional<User> userOptional = userRepository.findByUserId(user.getUserId());

//        cartRepository.save(Cart.builder().user(user)
//                .build());

//        user.addUserAddress(userAddress);

        Product product = new Product("test Prod", "CD1234-011", "this is test item", 139000, "원");

        productRepository.save(product);

        ProductSku sku = new ProductSku(product,"260", 7);
        ProductSku sku2 = new ProductSku(product, "265", 8);
        skuRepository.save(sku);
        skuRepository.save(sku2);


        product.addProductSku(sku);
        product.addProductSku(sku2);


        Product product2 = new Product("test Prod2", "DA1234-001", "this is test item2", 139000, "원");

        productRepository.save(product2);

        ProductSku sku3 = new ProductSku(product2,"260", 7);
        ProductSku sku4 = new ProductSku(product2, "265", 8);
        skuRepository.save(sku3);
        skuRepository.save(sku4);


        product.addProductSku(sku3);
        product.addProductSku(sku4);

//        productSkuRepository.save(new ProductSku(product, sku));
        //      productSkuRepository.save(new ProductSku(product, sku2));



//        user.getAddresses().forEach((addr) -> {
//            System.out.println(addr.getAddressId());
//        });

        System.out.println(product.getProductSkus().isEmpty());

        product.getProductSkus().forEach((s) -> {
            System.out.println(s.getId() + ", " + s.getSkuId() + ", " + s.getProduct().getProductId());
        });
    }

}