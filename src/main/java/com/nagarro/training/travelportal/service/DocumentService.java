package com.nagarro.training.travelportal.service;

import java.util.List;

import com.nagarro.training.travelportal.dto.DocumentDto;
import com.nagarro.training.travelportal.model.Document;

public interface DocumentService {

	List<Document> getDocuments(int id);

	Document addDocument(DocumentDto documentDto);

}