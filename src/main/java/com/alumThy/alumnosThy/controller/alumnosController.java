package com.alumThy.alumnosThy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alumThy.alumnosThy.model.alumnosModel;
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
	
	/*
	 * ACCEDEMOS A LA URL CON GETMAPPING, MAPEA NUESTRA RUTA E INGRESAMOS AL NAVEGADOR,
	 * CON EL METODO LISTAR, MUESTRA TODOS LOS REGISTROS EN MI SITIO WEB. 
	 */
	@GetMapping("/lista")
	public String Listado(Model model)
	{
		model.addAttribute("alumnos", servicio.listarTodos());
		return "Listado_estudiantes";
	}
	/*
	 * ACCION MOSTRAR FORMULARIO, SE ENCARGA DE MOSTRAR EL FORMULARIO DE REGISTRAR NUEVO ESTUDIANTE,
	 * EN UNA NUEVA VENTANA Y RUTA, ESTA ACCION VA DE LA MANO DEL METODO QUE INSERTARARA UN NUEVO REGISTRO,
	 * ES DECIR LA ACCION MOSTRAR FORMULARIO Y METODO INSERTAR. 
	 */
	@GetMapping("/NuevoRegistro")
	public String mostrarFormulario(Model model)
	{
		model.addAttribute("alumno", new alumnosModel());
		return "Insertar_estudiantes";
	}
	/*
	 * METODO ENCARGADO DE INSERTAR UN NUEVO REGISTRO ESTUDIANTE EN LA BASE DE DATOS
	 */
	@GetMapping("/guardar")
	public String agregarRegistro(@ModelAttribute alumnosModel alummodel)
	{
		 servicio.guardarEstudiante(alummodel);
		 return "redirect:/api/alumnos/listar";
	}
}
