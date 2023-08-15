package com.bidirection.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "assignments")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long assignmentId;

	@Column(name = "name")
	private String name;

	@Column(name = "grade")
	private int grade;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "student_id", nullable = false)
	@JsonIgnore
	private Student student;

//	public Assignment(Long id, String name, int grade, Student student) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.grade = grade;
//		this.student = student;
//	}

	public Assignment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Assignment [id=" + assignmentId + ", name=" + name + ", grade=" + grade + ", student=" + student + "]";
	}

	public Long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
