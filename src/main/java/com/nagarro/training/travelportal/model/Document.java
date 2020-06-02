package com.nagarro.training.travelportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class Document {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String metadata;

	@Lob
	@Column(name = "data")
	private byte[] data;

	private int ticketId;

}
