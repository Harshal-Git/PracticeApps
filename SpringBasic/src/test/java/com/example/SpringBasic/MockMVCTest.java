/**
 * 
 */
package com.example.SpringBasic;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

/**
 * @author hcharadava
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class MockMVCTest {

	@Autowired
	private MockMvc mockMVC;
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMVC.perform(get("/hello?name=harshal")).andDo(print()).andExpect(status().isOk())
				.andExpect((ResultMatcher) content().string(containsString("Hello harshal!")));
	}
}
