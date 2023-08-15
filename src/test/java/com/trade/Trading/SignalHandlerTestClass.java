package com.trade.Trading;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

import org.apache.catalina.connector.ClientAbortException;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.trade.Trading.external.Algo;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class SignalHandlerTestClass {

	   @Autowired
	    private TestRestTemplate restTemplate;
	    
	    @LocalServerPort
	    int randomServerPort;

	    @Test
	    public void testSendSignalSuccess() throws URISyntaxException 
	    {
	        final String baseUrl = "http://localhost:"+randomServerPort+"/algo/";
	        URI uri = new URI(baseUrl);
	        Algo algo = new Algo(2);
	        
	        HttpHeaders headers = new HttpHeaders(null);
	        headers.set("X-COM-PERSIST", "true");      

	        HttpEntity<Algo> request = new HttpEntity<>(algo, headers);
	        
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	        
	        //Verify request succeed
	        Assert.assertEquals(201, result.getStatusCodeValue());
	    }
	    
	    @Test
	    public void testAddEmployeeMissingHeader() throws URISyntaxException 
	    {
	        final String baseUrl = "http://localhost:"+randomServerPort+"/algo/";
	        URI uri = new URI(baseUrl);
	        Algo algo = new Algo(8);
	        
	        HttpHeaders headers = new HttpHeaders();

	        HttpEntity<Employee> request = new HttpEntity<>(algo, headers);
	        
	        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
	        
	        //Verify bad request and missing header
	        Assert.assertEquals(400, result.getStatusCodeValue());
	        
	    }

	}
