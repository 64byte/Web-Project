package com.story.backend;

import com.story.backend.user.entity.User;
import com.story.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

@Component
class DemoCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    public DemoCommandLineRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        User user = new User("123@naver.com", "123123");
       // user.setEmail("123456@naver.com");
       // user.setPassword("flskdfasdf");
        userRepository.save(user);

        Optional<User> userOptional = userRepository.findByUserId(user.getUserId());
        System.out.println(userOptional);
    }

}