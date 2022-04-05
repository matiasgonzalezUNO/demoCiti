package com.example.demoMiddleware.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demoMiddleware.models.TipoDocumentoModel;
import com.example.demoMiddleware.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long>{
	
	public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
	
	public abstract ArrayList<UsuarioModel> findBytipoDocumentoAndNumeroDocumento(Optional<TipoDocumentoModel> tipoDocumentoModel, Integer numeroDocumento);

}
