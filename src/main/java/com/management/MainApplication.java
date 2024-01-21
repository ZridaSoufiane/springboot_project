package com.management;

import com.management.entities.Category;
import com.management.entities.Product;
import com.management.entities.Role;
import com.management.entities.User;
import com.management.services.ProductService;
import com.management.services.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;


@SpringBootApplication
public class MainApplication {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /*@Bean
    CommandLineRunner start(){
        return args -> {
            userService.addRole(new Role(null, "ADMIN"));
            userService.addRole(new Role(null, "CASHIER"));
            userService.addRole(new Role(null, "USER"));
            userService.addRole(new Role(null, "CREATE"));
            userService.saveUser(new User(null, "admin", "123", true, null,"admin@gmail.com"));
            userService.saveUser(new User(null, "cashier", "123", true, null,"cashier@gmail.com"));
            userService.saveUser(new User(null, "accountant", "123", true, null,"accountant@gmail.com"));
            userService.addRoleToUser("admin", "ADMIN");
            userService.addRoleToUser("admin", "CREATE");
            userService.addRoleToUser("cashier", "CASHIER");
            userService.addRoleToUser("cashier", "CREATE");
            userService.addRoleToUser("accountant", "USER");
        };
    }*/
    @Bean
    CommandLineRunner start()
    {
        return args -> {
            productService.saveProduct(new Product("iPhone 12",7000.00,new Date()));
                    productService.saveProduct(new Product("iPhone 13",9000.00,new Date()));
                            productService.saveProduct(new Product("iPhone 14",12000.00,new Date()));
        };
    }
}