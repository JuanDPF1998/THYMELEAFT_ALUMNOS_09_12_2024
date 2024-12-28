package com.alumThy.alumnosThy.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/verFormRegistrar")
	public String mostrarFormulario(Model model)
	{
		model.addAttribute("alumno", new alumnosModel());
		return "Insertar_estudiantes";
	}
	/*
	 * METODO ENCARGADO DE INSERTAR UN NUEVO REGISTRO ESTUDIANTE EN LA BASE DE DATOS
	 */
	@PostMapping("/guardar")
	public String registrarRegistro(@ModelAttribute alumnosModel alumno)
	{
		servicio.guardarNuevo(alumno);
		return "redirect:/api/alumnos/lista";
	}
	/*
	 * SOLO MUESTRA EL FORMULARIO EDITAR.
	 */
	@GetMapping("/verFormEditar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model model) 
	{
	model.addAttribute("alumno", servicio.obtenerEstudiantePorId(id));
	return "Actualizar_estudiantes";
	}
	
	/*
	 * ACCION O FUNCION ENCARGADA DE TRAER TRAER LOS DATOS Y VISUALIZARLOS EN EL FORMULARIO,
	 * A DEMAS DE PERMITIR LA MODIFICACION DEL MISMO REGISTRO, METODOS GET Y SET.
	 */
	@PostMapping("/actualizar/{id}")
	public String editarRegistroAlumno(@PathVariable Long id, @ModelAttribute("alumno") 
	alumnosModel alumno)
	{
		alumnosModel existeElRegistro = servicio.obtenerEstudiantePorId(id);
		existeElRegistro.setId(id);
		existeElRegistro.setNombres(alumno.getNombres());
		existeElRegistro.setApellidos(alumno.getApellidos());
		existeElRegistro.setMatricula(alumno.getMatricula());
		existeElRegistro.setCorreo(alumno.getCorreo());
		existeElRegistro.setTelefono(alumno.getTelefono());
		
		servicio.guardarNuevo(existeElRegistro);
		
		return "redirect:/api/alumnos/lista";
	}
	/*
	 * ACCION O FUNCION ELIMINAR POR ID
	 */
	@GetMapping("/eliminar/{id}")
	public String eliminarEstudiantePorId(@PathVariable Long id)
	{
		servicio.eliminarEstudiantePorId(id);
		return "redirect:/api/alumnos/lista";
	}
}
