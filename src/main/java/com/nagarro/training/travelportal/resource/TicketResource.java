package com.nagarro.training.travelportal.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.travelportal.model.Ticket;
import com.nagarro.training.travelportal.repository.TicketRepository;

@RestController
public class TicketResource {

	@Autowired
	TicketRepository ticketRepository;

	@GetMapping("/tickets")
	public List<Ticket> getTickets() {
		return ticketRepository.findAll();
	}

	@GetMapping("/users/{id}/tickets")
	public List<Ticket> getTicketsById(@PathVariable(value = "id") Integer id) {
		return ticketRepository.findByUserId(id);
	}

	@PostMapping("/tickets")
	public Ticket addTicket(@RequestBody Ticket ticket) {
		return ticketRepository.save(ticket);
	}

}
