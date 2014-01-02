package com.guerrero.clan;

import org.springframework.beans.factory.annotation.Autowired;

public class MyHelper {

	@Autowired
	private PersonService personService;
	
	public Assistant getAssistant(Long id) {
		Assistant assistant = personService.getAssistant(id );
		return assistant;
	}

}
