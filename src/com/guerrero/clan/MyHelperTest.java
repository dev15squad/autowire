package com.guerrero.clan;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
public class MyHelperTest{
         
        @Autowired
        private PersonService accountService;
        
        @Autowired
        private MyHelper myHelper;


        @Configuration
        static class MyHelperConfiguration{
                @Bean
                public PersonService accountService() {
                	return Mockito.mock(PersonService.class);
                }
                 
                @Bean
                public MyHelper myHelper() {
                	return new MyHelper();
                }
        }

}