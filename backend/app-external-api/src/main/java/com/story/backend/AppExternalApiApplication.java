package com.story.backend;

import com.story.backend.address.entity.Address;
import com.story.backend.address.repository.AddressRepository;
import com.story.backend.cart.repository.CartRepository;
import com.story.backend.product.entity.Product;
import com.story.backend.product.repository.ProductRepository;
import com.story.backend.sku.entity.Sku;
import com.story.backend.sku.repository.SkuRepository;
import com.story.backend.user.entity.User;
import com.story.backend.user.entity.UserAddress;
import com.story.backend.user.repository.UserAddressRepository;
import com.story.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

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

    private final UserAddressRepository userAddressRepository;

    private final CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SkuRepository skuRepository;

    public DemoCommandLineRunner(UserRepository userRepository, AddressRepository addressRepository, UserAddressRepository userAddressRepository, CartRepository cartRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userAddressRepository = userAddressRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        User user = new User("123@naver.com", "123123");
       // user.setEmail("123456@naver.com");
       // user.setPassword("flskdfasdf");
        userRepository.save(user);

        Address address = Address.builder()
                .receiverName("준영")
                .receiverPhoneNum("01012341234")
                .postalCode("01234")
                .address1("dfaefasefff")
                .address2("ererawerafasdfa").build();

        addressRepository.save(address);

        Address address2 = Address.builder()
                .receiverName("1준영")
                .receiverPhoneNum("01012341234")
                .postalCode("01234")
                .address1("dfaefasefff")
                .address2("ererawerafasdfa").build();

        addressRepository.save(address2);

        UserAddress userAddress  =new UserAddress("asdfasdf", user, address2);

        userAddressRepository.save(userAddress);

        Optional<User> userOptional = userRepository.findByUserId(user.getUserId());

//        cartRepository.save(Cart.builder().user(user)
//                .build());

//        user.addUserAddress(userAddress);

        Product product = new Product("test Prod");

        productRepository.save(product);

        Sku sku = new Sku(product,"260", 7);
        Sku sku2 = new Sku(product, "265", 8);
        skuRepository.save(sku);
        skuRepository.save(sku2);


        product.addSku(sku);
        product.addSku(sku2);

//        productSkuRepository.save(new ProductSku(product, sku));
  //      productSkuRepository.save(new ProductSku(product, sku2));


        Set<UserAddress> userAddressSet = userOptional.get().getUserAddresses();

        System.out.println(userAddressSet.stream().findFirst().get().getAddress().getReceiverName());

        System.out.println(product.getSkus().isEmpty());

        product.getSkus().forEach((s) -> {
            System.out.println(s.getId() + ", " + s.getSkuId() + ", " + s.getProduct().getProductId());
        });
    }

}
