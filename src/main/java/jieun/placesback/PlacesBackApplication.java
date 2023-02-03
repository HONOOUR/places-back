package jieun.placesback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
public class PlacesBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlacesBackApplication.class, args);
    }
}
