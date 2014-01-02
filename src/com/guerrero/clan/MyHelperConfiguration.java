package com.guerrero.clan;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

public class MyHelperConfiguration{
        @Bean
        public PersonService accountService() {
        	return Mockito.mock(PersonService.class);
        }
         
        @Bean
        public MyHelper myHelper() {
        	return new MyHelper();
        }
}

