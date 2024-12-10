package com.alumThy.alumnosThy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alumThy.alumnosThy.service.alumnosService;

/*
 * SE UTILIZA PARA MARCAR UNA CLASE COMO UN CONTROLADOR EN UNA APLICACION WEB 
 * BASADA EN EL PATRON MVC (MODEL-VIEW-CONTROLLER). EL PROPOSITO DE ESTA ANOTACION 
 * ES MANEJAR SOLICITUDES HTTP Y DEVOLVER VISTAS COMO RESPUESTA, TIPICAMENTE PAGINAS HTML 
 * UTILIZANDO UN MOTOR DE PLANTILLAS COMO THYMELEAFT O JSP
 */
@Controller
@RequestMapping("/api/alumnos")
public class alumnosController {

	/*
	 * SE UTILIZA PARA INYECTAR AUTOMATICAMENTE DEPENDENCIAS EN LOS COMPONENTES GESTIONADOS
	 * POR EL CONTENEDOR DE SPRING, COMO SERVICIOS, CONTROLADORES, REPOSITORIOS.
	 */
	@Autowired
	private alumnosService servicio;
	
	@GetMapping("/lista")
	public String Listado(Model model)
	{
		model.addAttribute("alumnos", servicio.listarTodos());
		return "Listado_estudiantes";
	}
}
