package com.example.demoMiddleware.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoMiddleware.models.ConversionDocumentoModel;
import com.example.demoMiddleware.models.RequestModel;
import com.example.demoMiddleware.models.ResponseModel;
import com.example.demoMiddleware.models.TipoDocumentoModel;
import com.example.demoMiddleware.models.UsuarioModel;
import com.example.demoMiddleware.repositories.ConversionDocumentoRepository;
import com.example.demoMiddleware.repositories.TipoDocumentoRepository;
import com.example.demoMiddleware.repositories.UsuarioRepository;


@Service
public class ConsultaService {
	@Autowired
	ConversionDocumentoRepository conversionDocumentoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
	BackEndService backEndService;
	
	public ResponseModel obtenerSaldo(RequestModel request) {		
		
//		Validación
		if( !(request.getNumeroDocumento() == null) && !(request.getTipoDocumento() == null) ) {
			
		}
		ArrayList<ConversionDocumentoModel> tipoDocConversion = new ArrayList<ConversionDocumentoModel>();
		ArrayList<UsuarioModel> usuario = new ArrayList<UsuarioModel>();
		Optional<TipoDocumentoModel> tipoDocumento = Optional.ofNullable(new TipoDocumentoModel());
		ResponseModel respuesta = new ResponseModel();
		Long tipoDocRequest;
        respuesta.setSaldoActual("0,00");
        respuesta.setCode(400);
        respuesta.setStatus(false);
        respuesta.setDescripcion("Error 400: se ha producido un error inesperado");       
        
        tipoDocRequest = request.getTipoDocumento();
        if(tipoDocRequest == null) {
        	return respuesta;
        }
        
        
//      Traducción (simula busqueda de datos en cache para la traducción)
        System.out.println("respuesta");
        System.out.println("request.getTipoDocumento() "+tipoDocRequest);
        tipoDocConversion = conversionDocumentoRepository.findByIdFrontEnd(tipoDocRequest);
        System.out.println("tipoDoc id_conver "+ tipoDocConversion.get(0).getId());
        System.out.println("tipoDoc id_back "+ tipoDocConversion.get(0).getIdBackEnd());
        System.out.println("tipoDoc id_front "+ tipoDocConversion.get(0).getIdFrontEnd());       
        
        
//      Armo request del back y lo envío 
        tipoDocumento = tipoDocumentoRepository.findById(tipoDocConversion.get(0).getIdBackEnd());
        System.out.println("tipoDocumento: "+tipoDocumento);
        if(!tipoDocumento.isEmpty()) {       	      	 
        //clase para simular el back-end        	 
        	 usuario = backEndService.obtenerSaldoDesdeElBack(tipoDocumento, request.getNumeroDocumento());
        }
        

        
//      Traducción de datos para el response del front
        usuario.get(0).setMonto(usuario.get(0).getMonto()*10);
        double d = usuario.get(0).getMonto();
        DecimalFormat format = new DecimalFormat("0.000");
        //Obtenemos el valor formateado
        String aux = format.format(d);
        //Reemplazamos las comas
        aux = aux.replace(".",",");

      
//      Armamos el response para el front
        if(!usuario.isEmpty()) {
        	System.out.println("usuario: "+usuario.get(0));
        	respuesta.setSaldoActual(aux);
            respuesta.setCode(200);
            respuesta.setStatus(true);
            respuesta.setDescripcion("el saldo del cliente es :");
            return respuesta;
        } else {
        	return respuesta;
        }
		
	}

}
