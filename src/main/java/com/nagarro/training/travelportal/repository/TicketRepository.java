package com.nagarro.training.travelportal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.training.travelportal.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	public List<Ticket> findByUserId(Integer id);

	public Page<Ticket> findByUserId(Integer id, Pageable pageable);
}
