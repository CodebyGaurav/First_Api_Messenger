package org.gaurav.codebygaurav.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.gaurav.codebygaurav.messenger.model.Message;
import org.gaurav.codebygaurav.messenger.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<Long, Message>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
}
