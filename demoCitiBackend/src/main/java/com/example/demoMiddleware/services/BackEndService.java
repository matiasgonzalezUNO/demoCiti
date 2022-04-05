package com.example.demoMiddleware.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demoMiddleware.models.TipoDocumentoModel;
import com.example.demoMiddleware.models.UsuarioModel;
import com.example.demoMiddleware.repositories.UsuarioRepository;

//clase para simular el back-end

@Service
public class BackEndService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public ArrayList<UsuarioModel> obtenerSaldoDesdeElBack(Optional<TipoDocumentoModel> tipoDocumentoModel, Integer numeroDocumento) {
		
		ArrayList<UsuarioModel> usuario = new ArrayList<UsuarioModel>();
		usuario = usuarioRepository.findBytipoDocumentoAndNumeroDocumento(tipoDocumentoModel, numeroDocumento );
		
		return usuario;
	}

}
