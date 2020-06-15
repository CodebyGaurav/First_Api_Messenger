package org.gaurav.codebygaurav.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.gaurav.codebygaurav.messenger.database.DatabaseClass;
import org.gaurav.codebygaurav.messenger.model.Profile;

public class ProfileServices {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileServices() {
		profiles.put("Don", new Profile(1l,"Don","Don2","Don3"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}
