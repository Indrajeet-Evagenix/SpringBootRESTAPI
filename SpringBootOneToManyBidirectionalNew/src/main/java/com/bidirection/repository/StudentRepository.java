package com.bidirection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidirection.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}