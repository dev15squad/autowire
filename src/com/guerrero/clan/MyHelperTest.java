package com.guerrero.clan;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
// http://net.tutsplus.com/tutorials/php/expressive-tests-with-hamcrest/

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MyHelperConfiguration.class)
public class MyHelperTest{
         
        @Autowired
        private PersonService personService;
        
        @Autowired
        private MyHelper myHelper;
        
        private Assistant assistant; 


        
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