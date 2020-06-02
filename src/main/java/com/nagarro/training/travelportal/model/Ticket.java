package com.nagarro.training.travelportal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	@Column(nullable = false)
	private String type;

	@Column(nullable = false)
	private String priority;

	@Column(nullable = false)
	private String travelCity;

	@Column(nullable = false)
	private String fromCity;

	@Column(nullable = false)
	private Date startDate;

	@Column(nullable = false)
	private Date endDate;

	@Column(nullable = false)
	private String passportNo;

	@Column(nullable = false)
	private String projectName;

	@Column(nullable = false)
	private String expenseBorneBy;

	@Column(nullable = false)
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
	private String comments;

}
