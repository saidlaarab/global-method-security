package spring.security.globalmethodsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.security.globalmethodsecurity.model.Employee;
import spring.security.globalmethodsecurity.service.BookService;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/details/{name}")
    public Employee getDetails(@PathVariable String name){
        return bookService.getBookDetails(name);
    }

}
