package com.nagarro.training.travelportal.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
public class DocumentDto {
	@Id
	@GeneratedValue
	private int id;

	private String name;

	private String metaData;

	@Lob
	@Column(name = "data")
	private String base64String;

	private int ticketId;
}
