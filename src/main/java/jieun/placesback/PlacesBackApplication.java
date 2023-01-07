package jieun.placesback;

import jieun.placesback.config.ChatAstraCassandraConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties(ChatAstraCassandraConfig)
public class PlacesBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlacesBackApplication.class, args);
    }

}
