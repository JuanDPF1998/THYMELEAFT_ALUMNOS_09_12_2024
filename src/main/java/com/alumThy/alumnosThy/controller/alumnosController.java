package com.alumThy.alumnosThy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alumThy.alumnosThy.model.alumnosModel;
import com.alumThy.alumnosThy.service.alumnosService;

/*
 * SE UTILIZA PARA MARCAR UNA CLASE COMO UN CONTROLADOR DE REST (REPRESENTATIONAL 
 * STATE TRANSFER). Se utiliza EN SERVICIOS WEB RESFULT, ES DECIR, PARA MANEJAR 
 * LAS SOLICITUDES HTTP Y RESPONDER CON DATOS EN FORMATO JSON (AUN QUE EL FORMATO MAS
 * COMUN ES JSON O XML).
 */
@RestController
@RequestMapping("/api/alumnos")
public class alumnosController {

	/*
	 * SE UTILIZA PARA INYECTAR AUTOMATICAMENTE DEPENDENCIAS EN LOS COMPONENTES GESTIONADOS
	 * POR EL CONTENEDOR DE SPRING, COMO SERVICIOS, CONTROLADORES, REPOSITORIOS.
	 */
	@Autowired
	private alumnosService servicio;
	
	@GetMapping("/listado")
	public List<alumnosModel> listarAlumnos()
	{
		return servicio.listarTodos();
	}
}
