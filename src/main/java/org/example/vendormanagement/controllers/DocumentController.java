package org.example.vendormanagement.controllers;

import org.example.vendormanagement.entity.Document;
import org.bson.types.ObjectId;
import org.example.vendormanagement.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping
    public ResponseEntity<?> allDocuments(){
        return ResponseEntity.ok(documentService.getAllDocuments());
    }

    @PostMapping("/upload")
    public ResponseEntity<Document> uploadDocument(@RequestBody Document document) {
        Document savedDocument = documentService.uploadDocument(document);
        return ResponseEntity.ok(savedDocument);
    }

    @GetMapping("/owner/{ownerId}/{ownerType}")
    public ResponseEntity<List<Document>> getDocumentsByOwner(@PathVariable ObjectId ownerId, @PathVariable String ownerType) {
        return ResponseEntity.ok(documentService.getDocumentsByOwner(ownerId, ownerType));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable ObjectId id) {
        Optional<Document> document = documentService.getDocumentById(id);
        return document.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable ObjectId id) {
        documentService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }
}
