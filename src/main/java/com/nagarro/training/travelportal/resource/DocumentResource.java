package com.nagarro.training.travelportal.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.travelportal.dto.DocumentDto;
import com.nagarro.training.travelportal.model.Document;
import com.nagarro.training.travelportal.service.DocumentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class DocumentResource {

	@Autowired
	DocumentService documentService;

	@GetMapping("/tickets/{id}/documents")
	public List<Document> getDocuments(@PathVariable int id) {
		return documentService.getDocuments(id);
	}

	@PostMapping("/documents")
	public Document addDocument(@RequestBody DocumentDto documentDto) {
		return documentService.addDocument(documentDto);
	}
}