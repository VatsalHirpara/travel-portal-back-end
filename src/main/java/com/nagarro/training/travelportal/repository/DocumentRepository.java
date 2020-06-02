package com.nagarro.training.travelportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.travelportal.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Integer> {

	public List<Document> findByTicketId(int id);
}
