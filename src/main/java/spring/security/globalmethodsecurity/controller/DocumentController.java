package spring.security.globalmethodsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.security.globalmethodsecurity.model.Document;
import spring.security.globalmethodsecurity.service.DocumentService;

@RestController
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/document/{code}")
    public Document getDocumentByCode(@PathVariable String code){
        return documentService.getDocumentByCode(code);
    }
}
