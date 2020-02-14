package com.example.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.Response;
import com.example.demo.model.UsuarioEntity;
import com.example.demo.security.JwtTokenUtil;
import com.example.demo.service.UsuarioService;



/**
 * @author jbascunan
 *
 */
@RestController
@RequestMapping("usuario")
public class UsuarioController {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);
	@Autowired
	private UsuarioService userService;

	
	/*
	 * @RequestMapping(method = RequestMethod.POST) public
	 * ResponseEntity<List<UserDetails>> create(@RequestBody UserDetails
	 * userDetails) { try { userService.create(userDetails); } catch (Exception e) {
	 * //logger.error("Error occurred while trying to process api request", e);
	 * //response.put("status", "fail"); } List<UserDetails> lista =
	 * userService.getUserDetails(); return new ResponseEntity<>(lista,
	 * HttpStatus.OK); }
	 */
	
    @PostMapping
    public ResponseEntity<UsuarioEntity> create(@RequestBody UsuarioEntity entity) throws Exception{
    	logger.info("Inicio creación usuario");
    	UsuarioEntity usuario = userService.create(entity);
    	Response response = new Response();
    	response.setMensaje("Usuario registrado correctamente.");
        return new ResponseEntity<UsuarioEntity>(usuario, new HttpHeaders(), HttpStatus.CREATED);
    }
    
	/*
	 * @PostMapping("/sign-up") public void signUp(@RequestBody UsuarioEntity user)
	 * { user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	 * applicationUserRepository.save(user); }
	 */

}
