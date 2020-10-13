package com.santhosh.optum.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Model class for Address
 */
@Table(name = "address")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@OneToOne(mappedBy = "address")
	private User user;
	
	@Column(name="street_name")
    private String streetName;

	@Column(name="city")
    private String city;

	@Column(name="state")
    private String state;

	@Column(name="zip_code")
    private String zipcode;
    
}
