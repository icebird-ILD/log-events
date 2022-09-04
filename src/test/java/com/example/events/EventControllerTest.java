package com.example.events;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.events.entity.Event;

public class EventControllerTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void findAllEvents() throws Exception {
		String uri = "/api/v1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Event[] eventList = super.mapFromJson(content, Event[].class);
		assertTrue(eventList.length > 0);
	}

//	@Test
//	public void createProduct() throws Exception {
//		String uri = "/products";
//		Product product = new Product();
//		product.setId("3");
//		product.setName("Ginger");
//		String inputJson = super.mapToJson(product);
//		MvcResult mvcResult = mvc.perform(
//				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
//				.andReturn();
//
//		int status = mvcResult.getResponse().getStatus();
//		assertEquals(201, status);
//		String content = mvcResult.getResponse().getContentAsString();
//		assertEquals(content, "Product is created successfully");
//	}
}
