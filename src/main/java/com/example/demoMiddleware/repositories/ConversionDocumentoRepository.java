package com.example.demoMiddleware.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demoMiddleware.models.ConversionDocumentoModel;


@Repository
public interface ConversionDocumentoRepository extends CrudRepository<ConversionDocumentoModel, Long>{
	
	public abstract ArrayList<ConversionDocumentoModel> findByIdFrontEnd(Long idFrontEnd);

}
