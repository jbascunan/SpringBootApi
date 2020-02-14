package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.exception.ExceptionNotFound;
import com.example.demo.model.UsuarioEntity;
import com.example.demo.service.UsuarioService;
import static org.junit.Assert.*;

@SpringBootTest
class DemoWsApplicationTests {
	@Autowired
	private UsuarioService userService;
	

	@Test
	void createTest() throws ExceptionNotFound, Exception {
		UsuarioEntity entity = new UsuarioEntity();	
		entity.setName("prueba");
		entity.setEmail("testT09@gmail.com");
		
		assertNotNull("Result", userService.create(entity));
    }	
	

}
