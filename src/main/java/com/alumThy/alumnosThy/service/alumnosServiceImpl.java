package com.alumThy.alumnosThy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alumThy.alumnosThy.model.alumnosModel;
import com.alumThy.alumnosThy.reposity.alumnosRepositorio;

@Service
public class alumnosServiceImpl implements alumnosService{

	/*
	 * SE UTILIZA PARA INYECTAR AUTOMATICAMENTE DEPENDENCIAS EN LOS COMPONENTES GESTIONADOS
	 * POR EL CONTENEDOR DE SPRING, COMO SERVICIOS, CONTROLADORES, REPOSITORIOS.
	 */
	@Autowired
	private alumnosRepositorio repositorio;
	
	/*
	 * METODO LISTAR TODOS, ESTE METODO SE ENCARGA DE BUSCAR TODOS LOS REGISTROS
	 * DE LA BASE DE DATOS, REGRESA UNA RESPUESTA ACCEDIENDO AL OBJETO REPOSITORIO DE LA
	 * INTERFAZ ALUMNOSREPOSITORIO QUE HEREDA DE JPAREPO ACCEDIENDO A TODOS LOS METODOS
	 * EN ESTE CASO FINALL (BUSCA TODOS).
	 */
	@Override
	public List<alumnosModel> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public alumnosModel guardarNuevo(alumnosModel alumnos) {
		return repositorio.save(alumnos);
	}

	@Override
	public alumnosModel actualizarAlumno(alumnosModel alumno) {
		return repositorio.save(alumno);
	}
	
	@Override
	public alumnosModel obtenerEstudiantePorId(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminarEstudiantePorId(Long id) {
		repositorio.deleteById(id);
	}
}
