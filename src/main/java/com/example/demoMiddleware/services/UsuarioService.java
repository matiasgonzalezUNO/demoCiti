package com.example.demoMiddleware.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoMiddleware.models.UsuarioModel;
import com.example.demoMiddleware.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
	}
	
	public UsuarioModel guardarUsuario(UsuarioModel user) {
		return usuarioRepository.save(user);
	}
	
	public Optional<UsuarioModel> obtenerUsuarioPorId(Long id) {
		return usuarioRepository.findById(id);
	}
	
	public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(Integer prioridad) {
		return usuarioRepository.findByPrioridad(prioridad);
	}
	
	public Boolean eliminarUsuario(Long id) {
		try {
			usuarioRepository.deleteById(id);
			return true;
		}catch(Exception err){
			System.out.println("catch Exception err: "+ err);
			return false;
			
		}
		
	}
}
