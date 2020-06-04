package com.nagarro.training.travelportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.nagarro.training.travelportal.model.Ticket;

public interface TicketService {

	List<Ticket> getAlltickets();

	Optional<Ticket> getTicketById(int id);

	Page<Ticket> getTicketsByUserId(int id, int offset, int limit);

	Ticket addTicket(Ticket ticket);

}