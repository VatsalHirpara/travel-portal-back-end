package com.nagarro.training.travelportal.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nagarro.training.travelportal.model.Ticket;
import com.nagarro.training.travelportal.model.User;
public interface TicketRepository extends JpaRepository<Ticket,Integer>{
	public List<Ticket> findByUserId(Integer id);
} 
