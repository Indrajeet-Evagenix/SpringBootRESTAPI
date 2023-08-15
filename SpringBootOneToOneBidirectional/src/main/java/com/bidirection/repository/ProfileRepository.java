package com.bidirection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bidirection.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
