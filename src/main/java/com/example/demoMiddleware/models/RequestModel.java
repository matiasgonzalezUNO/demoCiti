package com.example.demoMiddleware.models;

import java.io.Serializable;

public class RequestModel  implements Serializable {
    private Long tipoDocumento;
    private Integer numeroDocumento;
    
	public Long getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(Long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
}
