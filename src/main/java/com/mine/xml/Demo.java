package com.mine.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Demo {
	
	public static void main(String[] args) {
		
		Users users = new Users();
		List<User> us = new ArrayList<User>();
		User user = new User(1, "patrick");
		us.add(user);
		users.setUsers(us);
		
		try {
			
			JAXBContext context = JAXBContext.newInstance(Users.class);
			Marshaller mashaller = context.createMarshaller();
			mashaller.marshal(users, System.out);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
