package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ExceptionNotFound;
import com.example.demo.model.UsuarioEntity;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.security.JwtTokenUtil;

@Service
public class UsuarioService {
	private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
    UsuarioRepository repository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	public UsuarioEntity create(UsuarioEntity entity) throws ExceptionNotFound,Exception {
		// Patrón para validar el email
        Pattern pattern = Pattern
                .compile("^(?=.*$)(?=.*[a-z])(?=.*[A-Z])(?=(?:.*[0-9]){2}).*[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})*$");
 
        Matcher mather = pattern.matcher(entity.getEmail());

        if (mather.find() == false) {
        	logger.error("El email ingresado es inválido, no cumple con formato.");
        	throw new ExceptionNotFound("El email ingresado es inválido, no cumple con formato.");
        }
        else {
        	List<UsuarioEntity> obj = repository.findByEmail(entity.getEmail());
        	if(obj.isEmpty()==false) {
        		logger.error("El email ingresado ya existe en nuestros registros.");
        		throw new ExceptionNotFound("El email ingresado ya existe en nuestros registros.");
        		}
        }
        
        //fechas
        logger.info("Setea fechas de crección");
        Date fecha = new Date();
        entity.setCreated(fecha);
        entity.setLast_login(fecha);
        
        //generar token
		entity.setToken(jwtTokenUtil.generateToken(entity));
		//generar UUID
		logger.info("Generar UUID");
		entity.setUuid(UUID.randomUUID().toString());
		//activa usuario
		entity.setIsactive(1); //"1=activo 0=inactivo"
		
		//guardar usuario
		entity = repository.save(entity);	
		logger.info("Usuario creado");
		return entity;

	}
}
