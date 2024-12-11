package com.alumThy.alumnosThy.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.alumThy.alumnosThy.model.alumnosModel;

public interface alumnosService {

	public List<alumnosModel> listarTodos();
	public alumnosModel guardarEstudiante(@RequestBody alumnosModel alumno);
}
