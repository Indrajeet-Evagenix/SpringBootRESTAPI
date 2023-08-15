package com.bidirection.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidirection.model.Profile;
import com.bidirection.repository.ProfileRepository;

@Service
public class ProfieServicesEmpl implements ProfileServices {

	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile insertProfile(Profile profile) {
		profileRepository.save(profile);
		return profile;
	}

	@Override
	public Profile getProfileDetailsById(Long id) {
		Optional<Profile> profile = profileRepository.findById(id);
		return profile.get();
	}

	@Override
	public List<Profile> getAllProfileDetails() {
		List<Profile> list = profileRepository.findAll();
		return list;
	}

	@Override
	public void deleteAllProfileDetails() {
		profileRepository.deleteAll();

	}

	@Override
	public void deleteProfileDetailsById(Long id) {
		profileRepository.deleteById(id);

	}

	@Override
	public Profile updateProfileDetails(Profile profile) {
		Long id = profile.getId();
		Optional<Profile> optionalProfile = profileRepository.findById(id);
		if (optionalProfile.isPresent()) {
			Profile pf = optionalProfile.get();
			pf.setProfileName(profile.getProfileName());
			pf.setEmployee(profile.getEmployee());
			return profileRepository.save(pf);
		} else {
			return null;
		}

	}

}
