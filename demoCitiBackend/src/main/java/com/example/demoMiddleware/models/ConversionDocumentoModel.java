package com.example.demoMiddleware.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversionDocumentos")
public class ConversionDocumentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private Long idFrontEnd;
	private Long idBackEnd;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdFrontEnd() {
		return idFrontEnd;
	}
	public void setIdFrontEnd(Long idFrontEnd) {
		this.idFrontEnd = idFrontEnd;
	}
	public Long getIdBackEnd() {
		return idBackEnd;
	}
	public void setIdBackEnd(Long idBackEnd) {
		this.idBackEnd = idBackEnd;
	}
	
}
