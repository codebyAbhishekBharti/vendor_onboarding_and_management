package org.example.vendormanagement.services;

import org.example.vendormanagement.entity.Document;
import org.example.vendormanagement.repository.DocumentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    public Document uploadDocument(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> getDocumentsByOwner(ObjectId ownerId, String ownerType) {
        return documentRepository.findByOwnerIdAndOwnerType(ownerId, ownerType);
    }

    public Optional<Document> getDocumentById(ObjectId id) {
        return documentRepository.findById(id);
    }

    public void deleteDocument(ObjectId id) {
        documentRepository.deleteById(id);
    }

    public Object getAllDocuments() {
        return documentRepository.findAll();
    }
}
