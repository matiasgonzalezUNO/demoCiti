package com.example.demoMiddleware.dataseed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demoMiddleware.models.*;
import com.example.demoMiddleware.repositories.*;

@Component
public class DataLoaderDemoMiddleware implements CommandLineRunner {
	
	@Autowired
	ConversionDocumentoRepository conversionDocumentoRepository;
	
	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
    public void run(String... args) throws Exception {
        loadConversionDocumentoData();
        loadTipoDocumento();
        loadUsuario();
       
    }
	
	private void loadConversionDocumentoData() {
		if (conversionDocumentoRepository.count() == 0) {
			ConversionDocumentoModel conversionDocumento1 = new ConversionDocumentoModel(100l,1l);
			ConversionDocumentoModel conversionDocumento2 = new ConversionDocumentoModel(200l,2l);
			ConversionDocumentoModel conversionDocumento3 = new ConversionDocumentoModel(300l,3l);
			ConversionDocumentoModel conversionDocumento4 = new ConversionDocumentoModel(400l,4l);
			conversionDocumentoRepository.save(conversionDocumento1);
			conversionDocumentoRepository.save(conversionDocumento2);
			conversionDocumentoRepository.save(conversionDocumento3);
			conversionDocumentoRepository.save(conversionDocumento4);
        }
        System.out.println(conversionDocumentoRepository.count());		
	}

	private void loadTipoDocumento() {
		
		if (tipoDocumentoRepository.count() == 0) {
			TipoDocumentoModel tipoDocumento1 = new TipoDocumentoModel(
                    "DNI",
                    "Documento Nacional de Identidad");
			TipoDocumentoModel tipoDocumento2 = new TipoDocumentoModel(
                    "LE",
                    "Libreta de Enrolamiento");
			TipoDocumentoModel tipoDocumento3 = new TipoDocumentoModel(
                    "PA",
                    "Pasaporte");;
            TipoDocumentoModel tipoDocumento4 = new TipoDocumentoModel(
                     "CI",
                     "Cédula de Identidad");
			tipoDocumentoRepository.save(tipoDocumento1);
			tipoDocumentoRepository.save(tipoDocumento2);
			tipoDocumentoRepository.save(tipoDocumento3);
			tipoDocumentoRepository.save(tipoDocumento4);
        }
        System.out.println(tipoDocumentoRepository.count());
		
		
	}
	
	private void loadUsuario() {
		
		if (usuarioRepository.count() == 0) {
			TipoDocumentoModel tipoDoc = tipoDocumentoRepository.findByNombre("DNI");
			
			UsuarioModel usuarioModel1 = new UsuarioModel(
                    "Matias Gonzalez",
                    "Matias@gmail.com",
                    1,
                    tipoDoc,
                    35311001,
                    1234567890789l,
                    5000
                    );


            usuarioRepository.save(usuarioModel1);
//            usuarioRepository.save(tipoDocumento2);
//            usuarioRepository.save(tipoDocumento3);
//            usuarioRepository.save(tipoDocumento4);
        }
        System.out.println(usuarioRepository.count());
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
