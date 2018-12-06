package com.martinezjavier.hellotest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.martinezjavier.hello.HelloServlet;

import junit.framework.TestCase;

public class HelloServletTest extends TestCase {
	
	
	public void testHello() {
		assertEquals("Hello world.", new HelloServlet().sayHello());
	}

}
