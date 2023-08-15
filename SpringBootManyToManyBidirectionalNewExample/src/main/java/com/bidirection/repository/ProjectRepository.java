package com.bidirection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidirection.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
