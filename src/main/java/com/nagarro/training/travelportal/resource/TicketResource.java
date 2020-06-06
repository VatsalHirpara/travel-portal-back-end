package com.nagarro.training.travelportal.resource;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.travelportal.model.Ticket;
import com.nagarro.training.travelportal.service.TicketService;

@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
@RestController
public class TicketResource {

	@Autowired
	TicketService ticketService;

	@GetMapping("/tickets")
	public List<Ticket> getTickets() {
		return ticketService.getAlltickets();
	}

	@GetMapping("/tickets/{id}")
	public Optional<Ticket> getTicketById(@PathVariable(value = "id") Integer id) {
		return ticketService.getTicketById(id);
	}

	@GetMapping("/users/{id}/tickets")
	public Page<Ticket> getTicketsByUserId(@PathVariable(value = "id") Integer id,
			@PathParam(value = "offset") Integer offset, @PathParam(value = "limit") Integer limit) {

		return ticketService.getTicketsByUserId(id, offset, limit);
	}

	@PostMapping("/tickets")
	public Ticket addTicket(@RequestBody Ticket ticket) {
		return ticketService.addTicket(ticket);
	}

}
