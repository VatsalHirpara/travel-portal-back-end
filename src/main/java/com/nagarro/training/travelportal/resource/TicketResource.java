package com.nagarro.training.travelportal.resource;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Ticket> getTickets(){
		return ticketRepository.findAll();
	}
	
	@PostMapping("/tickets")
	public Ticket addTicket(@RequestBody Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	
	@GetMapping("/users/{id}/tickets")
	public List<Ticket> getTicketsById(@PathParam(value = "id") int id){
		return ticketRepository.findByUser_Id(id);
	}
}
