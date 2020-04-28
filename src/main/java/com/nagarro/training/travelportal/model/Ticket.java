package com.nagarro.training.travelportal.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ticket {
	@Id
	@GeneratedValue
	private Integer id;
	private String type;
	private String priority;
	private String travelCity;
	private String fromCity;
	private Date startDate;
	private Date endDate;
	private String passportNo;
	private String projectName;
	private String expenseBorneBy;
	private String approverName;
	@Column(nullable = true)
	private String expectedDuration;
	@Column(nullable = true)
	private String upperBound;
	@Column(nullable = true)
	private String additionalDetails;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private User user;
	
	@Column(columnDefinition = "varchar(255) default 'Submitted'")
	private String status;
	private Date submitDate;
	
	@Lob
	private List<byte[]> files; 
}
