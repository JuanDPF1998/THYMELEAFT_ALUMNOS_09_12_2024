package com.alumThy.alumnosThy.service;

import java.util.List;


import com.alumThy.alumnosThy.model.alumnosModel;

public interface alumnosService {

	public List<alumnosModel> listarTodos();
	public alumnosModel guardarNuevo(alumnosModel alumnos);
	public alumnosModel actualizarAlumno(alumnosModel alumno);
	public alumnosModel obtenerAlumnoPorId(Long id);
}
