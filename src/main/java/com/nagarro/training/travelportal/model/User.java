package com.nagarro.training.travelportal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

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
	private int id;
	private String firstName;
	private String lastName;
	private String businessUnit;
	private String title;
	private String email;
	private String telephone;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private boolean isAdmin;
	@JsonIgnore
	private String password;
	
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
	private List<Ticket> tickets;
}
