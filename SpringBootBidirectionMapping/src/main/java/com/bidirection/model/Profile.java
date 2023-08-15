package com.bidirection.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
//@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String shift;

	@OneToOne(mappedBy = "profile")
//	@JsonIgnore
	private Employee employee;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(Long id, String shift, Employee employee) {
		super();
		this.id = id;
		this.shift = shift;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", shift=" + shift + ", employee=" + employee + "]";
	}

}
