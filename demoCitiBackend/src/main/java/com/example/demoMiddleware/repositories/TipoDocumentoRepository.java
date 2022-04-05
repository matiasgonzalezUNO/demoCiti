package com.example.demoMiddleware.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demoMiddleware.models.TipoDocumentoModel;

@Repository
public interface TipoDocumentoRepository extends CrudRepository<TipoDocumentoModel, Long>{

}
