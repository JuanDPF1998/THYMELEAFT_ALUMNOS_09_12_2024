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

}
