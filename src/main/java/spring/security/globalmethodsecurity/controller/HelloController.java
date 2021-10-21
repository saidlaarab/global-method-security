package spring.security.globalmethodsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.security.globalmethodsecurity.service.NameService;

@RestController
public class HelloController {

    @Autowired
    private NameService nameService;

    @GetMapping("/hello")
    public String hello(){
        String name = nameService.getName();
        return "Hello " + name + " !";
    }
}
