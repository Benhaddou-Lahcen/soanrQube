package ehtp._gi.tp_initiation_sonarqube.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    String password = "12345";

    List<String> getNames() {
        List<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Sara");
        names.add("Imane");
        return names;
    }

    @GetMapping("/hello")
    public String hello() {
        String message = "";
        for (int i = 0; i < 5; i++) {
            message += "Hello ";
        }

        List<String> names = getNames();

        return "Hello Students! Names:" + names.toString() + " Pass=" + password;
    }
}

