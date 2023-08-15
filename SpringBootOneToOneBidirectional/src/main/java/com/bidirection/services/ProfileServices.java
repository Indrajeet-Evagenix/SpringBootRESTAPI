package com.bidirection.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bidirection.model.Profile;

@Component
public interface ProfileServices {

	public Profile insertProfile(Profile profile);

	public Profile getProfileDetailsById(Long id);

	public List<Profile> getAllProfileDetails();

	public void deleteAllProfileDetails();

	public void deleteProfileDetailsById(Long id);

	public Profile updateProfileDetails(Profile profile);

}
