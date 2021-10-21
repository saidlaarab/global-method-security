package spring.security.globalmethodsecurity.repository;

import org.springframework.stereotype.Repository;
import spring.security.globalmethodsecurity.model.Document;

import java.util.List;
import java.util.Optional;

@Repository
public class DocumentRepository {
    private List<Document> documents = List.of(
            new Document("a123", "said"),
            new Document("b123", "said"),
            new Document("c123", "med"),
            new Document("d123", "med")
    );

    public Document findByCode(String code){
        Optional<Document> foundDoc = documents.stream().filter(doc -> doc.getCode().equals(code)).findFirst();

        return foundDoc.orElseThrow(() -> new RuntimeException("Book not found"));

    }
}
