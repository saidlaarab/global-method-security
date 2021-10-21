package spring.security.globalmethodsecurity.service;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;
import spring.security.globalmethodsecurity.model.Employee;

import java.util.List;
import java.util.Map;


@Service
public class BookService {
    private Map<String, Employee> records = Map.of(
            "Emma", new Employee("Emma Watson", List.of("Harry Potter 01", "Harry Potter 02"), List.of("actor", "speaker")),
            "Nancy", new Employee("Nancy Drew", List.of("The mystery of the old clock", "The mystery of hidden stairs"), List.of("sleuth", "reader"))
    );

    // @PostAuthorize is applied after the execution of the method, and so can access the object it returns to do some checks
    // "returnObect" in the expression below refers to the object returned by the method
    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetails(String name){
        return records.get(name);
    }
}
