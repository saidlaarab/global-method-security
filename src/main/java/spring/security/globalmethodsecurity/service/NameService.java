package spring.security.globalmethodsecurity.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NameService {

    @PreAuthorize("hasAuthority('write')")
    public String getName(){
        return "Kpixo";
    }

    private Map<String, List<String>> usersSecretsNames = Map.of(
            "said", List.of("said-secret-01", "said-secret-02"),
            "med", List.of("med-secret-01", "med-secret-02")
    );

    // "#username" --> refers to the parameter of the method
    // the following annotation has access to the beans of context
    @PreAuthorize("#username == authentication.principal.username")
    public List<String> getSecretNamesForUser(String username){
        return usersSecretsNames.get(username);
    }
}
