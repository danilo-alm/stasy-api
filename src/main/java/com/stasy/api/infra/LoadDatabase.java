package com.stasy.api.infra;

import com.stasy.api.domain.product.Product;
import com.stasy.api.domain.product.ProductCategory;
import com.stasy.api.dtos.ProductDTO;
import com.stasy.api.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Product(new ProductDTO(
              "Coquinha Gelada hmmmm",
              "Coca-Cola",
              ProductCategory.DRINKS,
              5,
              100
            ))));

            log.info("Preloading " + repository.save(new Product(new ProductDTO(
              "Camiseta Naruto",
              "Maria Costureira",
              ProductCategory.CLOTHING,
              50,
              10
            ))));

            log.info("Preloading " + repository.save(new Product(new ProductDTO(
              "Notebook Dell",
              "Dell",
              ProductCategory.ELECTRONICS,
              5000,
              2
            ))));
        };

    }
}