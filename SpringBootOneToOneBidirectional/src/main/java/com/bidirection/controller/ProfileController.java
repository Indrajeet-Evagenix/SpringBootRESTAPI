//package com.bidirection.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bidirection.model.Profile;
//import com.bidirection.services.ProfieServicesEmpl;
//
//@RestController
//public class ProfileController {
//
//	@Autowired
//	private ProfieServicesEmpl profieServicesEmpl;
//
//	@PostMapping("/addProfiles")
//	public String addProfile(@RequestBody Profile profile) {
//		profieServicesEmpl.insertProfile(profile);
//		return "Profile Details Added Successfully";
//	}
//
////	@GetMapping("/getProfileById/{id}")
////	public Profile getProfileById(@PathVariable Long id) {
////		Profile profile = profieServicesEmpl.getProfileDetailsById(id);
////		return profile;
////	}
////
//	@GetMapping("/getAllProfile")
//	public List<Profile> getAllProfile() {
//		List<Profile> list = profieServicesEmpl.getAllProfileDetails();
//		return list;
//	}
//
////	@DeleteMapping("deleteById/{id}")
////	public String deleteProfileById(@PathVariable Long id) {
////		Long idGet = id;
////		profieServicesEmpl.deleteProfileDetailsById(id);
////		if (idGet != null) {
////			return "Profile Deleted with this id: " + id + " Successfully";
////		} else {
////			return "Profile with this id: " + id + " Not Found!";
////		}
////	}
////
////	@DeleteMapping("/deleteAllProfile")
////	public String deleteAllProfile() {
////		profieServicesEmpl.deleteAllProfileDetails();
////		return "All Profile Deleted Successfully";
////	}
////
////	@PutMapping("/updateProfile")
////	public String updateProfile(@RequestBody Profile profile) {
////		profieServicesEmpl.updateProfileDetails(profile);
////		return "Profile Updated Successfully";
////	}
//
//}
