package jieun.placesback.main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/hello")
    void hello () {
        System.out.println("hello.");
    }
}
