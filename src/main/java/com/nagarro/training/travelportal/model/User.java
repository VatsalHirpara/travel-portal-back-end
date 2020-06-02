package com.nagarro.training.travelportal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String businessUnit;

	@Column(nullable = false)
	private String title;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String telephone;

	@Column(nullable = false)
	private String address1;

	@Column(nullable = true)
	private String address2;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private String zip;

	@Column(nullable = false)
	private String country;

	private boolean isAdmin;

	@JsonIgnore
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Ticket> tickets;
}
