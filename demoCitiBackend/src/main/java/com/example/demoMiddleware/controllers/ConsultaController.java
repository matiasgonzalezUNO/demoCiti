package com.example.demoMiddleware.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoMiddleware.models.RequestModel;
import com.example.demoMiddleware.models.ResponseModel;
import com.example.demoMiddleware.services.ConsultaService;


// Punto de entrada de la api 

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
	@Autowired
	ConsultaService consultaService;
	
	//2- Endpoint expuesto para realizar pedido
	@GetMapping( path = "/obtenerSaldo")
	public @ResponseBody ResponseModel ObtenerSaldo(@RequestBody RequestModel request) {
		return consultaService.obtenerSaldo(request);
	} 

}
