package org.gaurav.codebygaurav.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.gaurav.codebygaurav.messenger.database.DatabaseClass;
import org.gaurav.codebygaurav.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();
			
	public MessageService() {
		messages.put(1L, new Message(1, "Hi....there..!", "Gaurav"));
		messages.put(2L, new Message(2, "Hello____ World", "Cdac Author"));
		
	}
	
	//return all message 
	public List<Message> getAllMessages(){
	
		ArrayList<Message> arraylist = new ArrayList<Message>(messages.values());
		
		return arraylist;
	}
	
	//return all message by year(Filter and Pagination)
	public List<Message> getAllMessagesforYear(int year){
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
		
	}
	
	public List<Message> getAllMessagesPagination(int start, int size){
		ArrayList<Message>  list = new ArrayList<Message>(messages.values());
		if(start+size > list.size())
			return new ArrayList<Message>();
		return list.subList(start, size);
	}
	
	
	public Message getMessage(Long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId((messages.size()+1));
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	
	public Message removeMessage(Long id) {
		return messages.remove(id);
	}
}
