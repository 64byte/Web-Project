package com.story.backend;

import com.story.backend.address.entity.Address;
import com.story.backend.address.repository.AddressRepository;
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

    public DemoCommandLineRunner(UserRepository userRepository, AddressRepository addressRepository, UserAddressRepository userAddressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userAddressRepository = userAddressRepository;
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

//        user.addUserAddress(userAddress);

        System.out.println(userOptional.get().getUserAddresses().isEmpty());
    }

}