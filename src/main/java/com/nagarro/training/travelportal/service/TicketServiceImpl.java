package com.nagarro.training.travelportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.training.travelportal.model.Ticket;
import com.nagarro.training.travelportal.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository ticketRepository;

	@Override
	@Transactional
	public List<Ticket> getAlltickets() {
		return ticketRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Ticket> getTicketById(int id) {
		return ticketRepository.findById(id);
	}

	@Override
	@Transactional
	public Page<Ticket> getTicketsByUserId(int id, int offset, int limit) {
		int pageNumber = offset / limit;
		return ticketRepository.findByUserId(id, PageRequest.of(pageNumber, limit));
	}

	@Override
	@Transactional
	public Ticket addTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

}
