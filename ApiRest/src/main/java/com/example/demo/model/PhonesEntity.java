package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Phones")
public class PhonesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne//(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
	@JsonIgnore
    private UsuarioEntity usuario;
    
    @Column(name="number")
    private String number;
     
    @Column(name="city_code")
    private String cityCode;
    
    @Column(name="country_code")
    private String countryCode; 
    
	public PhonesEntity(Long id, UsuarioEntity usuario, String number, String cityCode, String countryCode) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}
    
    public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

 
    public PhonesEntity() {}
}
