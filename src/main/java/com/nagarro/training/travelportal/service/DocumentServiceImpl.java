package com.nagarro.training.travelportal.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.training.travelportal.dto.DocumentDto;
import com.nagarro.training.travelportal.model.Document;
import com.nagarro.training.travelportal.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	DocumentRepository documentRepository;

	@Override
	@Transactional
	public List<Document> getDocuments(int id) {
		return documentRepository.findByTicketId(id);
	}

	@Override
	@Transactional
	public Document addDocument(DocumentDto documentDto) {
		byte[] data = Base64.getDecoder().decode(documentDto.getBase64String());
		Document document = new Document();
		document.setData(data);
		document.setMetadata(documentDto.getMetaData());
		document.setTicketId(documentDto.getTicketId());
		document.setName(documentDto.getName());
		return documentRepository.save(document);
	}
}
