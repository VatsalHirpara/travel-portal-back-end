package com.nagarro.training.travelportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.travelportal.model.Document;

public interface FileRepository extends JpaRepository<Document, Integer> {
}
