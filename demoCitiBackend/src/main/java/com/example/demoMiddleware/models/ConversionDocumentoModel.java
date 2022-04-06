package com.example.demoMiddleware.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONVERSION_DOCUMENTOS")
public class ConversionDocumentoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, name="ID_CONVERSION_DOCUMENTOS")
	private Long idConversionDocumentos;
	@Column(name="ID_FRONT_END")
	private Long idFrontEnd;
	@Column(name="ID_BACK_END")
	private Long idBackEnd;
	
	
	public Long getId() {
		return idConversionDocumentos;
	}
	public void setId(Long idConversionDocumentos) {
		this.idConversionDocumentos = idConversionDocumentos;
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
