package spring.security.globalmethodsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;
import spring.security.globalmethodsecurity.model.Document;
import spring.security.globalmethodsecurity.repository.DocumentRepository;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @PostAuthorize("hasPermission(returnObject, 'ROLE_admin')")
    public Document getDocumentByCode(String code){
        return documentRepository.findByCode(code);
    }
}
