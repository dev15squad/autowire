package com.guerrero.clan;

import static org.junit.Assert.fail;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MyHelperTest{
         
        @Autowired
        private PersonService personService;
        
        @Autowired
        private MyHelper myHelper;
        
        private Assistant assistant; 


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
        
        
        @Before
        public void setDate() throws Exception {
        		assistant = new Assistant();
        }     
        
        @Test
        public void myHelper() throws Exception {
                Long id = new Long( 1234 );
                assistant.setId( id );
                Mockito.when(this.personService.getAssistant( id ) ).thenReturn( assistant );

                Assistant assistant = myHelper.getAssistant( id );

                assertThat(id, equalTo( assistant.getId() ) );
        }
        

}