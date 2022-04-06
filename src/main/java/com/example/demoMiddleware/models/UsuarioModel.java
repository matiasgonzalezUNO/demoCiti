package com.example.demoMiddleware.models;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	private String nombre;
	
	private String email;
	
	private Integer prioridad;
	
	
	@ManyToOne
	private TipoDocumentoModel tipoDocumento;
	
	private Integer numeroDocumento;
	
	private Long numeroCuentaBancaria;
	
	private Integer monto;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	
	//Otros datos	
	public TipoDocumentoModel getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumentoModel tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public Long getNumeroCuentaBancaria() {
		return numeroCuentaBancaria;
	}
	public void setNumeroCuentaBancaria(Long numeroCuentaBancaria) {
		this.numeroCuentaBancaria = numeroCuentaBancaria;
	}
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	
	
	public UsuarioModel() {
		
	}
	public UsuarioModel(String nombre, String email, Integer prioridad, TipoDocumentoModel tipoDocumento,
			Integer numeroDocumento, Long numeroCuentaBancaria, Integer monto) {
		this.nombre = nombre;
		this.email = email;
		this.prioridad = prioridad;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.numeroCuentaBancaria = numeroCuentaBancaria;
		this.monto = monto;
	}
	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", nombre=" + nombre + ", email=" + email + ", prioridad=" + prioridad
				+ ", tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento
				+ ", numeroCuentaBancaria=" + numeroCuentaBancaria + ", monto=" + monto + "]";
	}

	
}
