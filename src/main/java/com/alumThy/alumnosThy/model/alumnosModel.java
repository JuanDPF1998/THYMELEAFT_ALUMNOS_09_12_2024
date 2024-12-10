package com.alumThy.alumnosThy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/*
 * INDICAMOS QUE NUESTRA CLASE MODELO SERA NUESTRA ENTIDAD CON @ENTITY
 * INDICAMOS EL NOMBRE DE LA TABLA QUE HIBERNATE ME GESTIONARA PARA LA PERSISTENCIA 
 */
@Entity
@Table(name = "alumnosThy_Ejemplo")
public class alumnosModel {

	/*
	 * INDICAMOS CUAL SERA NUESTRA PROPIEDAD PRIMARIA CON @ID,
	 * INDICAR QUE EL VALOR EL VALOR DE LA CLAVE PRIMARIA (@Id) SE VA A GENERAR,
	 * AUTOMATICAMENTE POR LA BASE DE DATOS UTILIZANDO UNA ESTRATEGIA DE AUTO-INCREMENT
	 *   
	 * LA ESTRATEGIA IDENTITY INDICA QUE LA BASE DE DATOS ES LA ENCARGADA DE ASIGNAR 
	 * LA CLAVE PRIMARIA USANDO UNA COLUMNA CON AUTO-INCREMENTO
	 */

	/*
	 * @column DEFINIMOS LA COLUMNA DE LA BASE DE DATOS, LA PROPIEDAD Y EL TAMAÑO
	 * DE CAPACIDAD DE ALMACENAMIENTO DE INFORMACION A DEMAS QUE DEFINIMOS QUE NO PUEDE
	 * ALMACENAR VALORES NULOS
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombres", nullable = false, length = 20)
	private String nombres;
	@Column(name = "apellidos", nullable = false, length = 20)
	private String apellidos;
	@Column(name = "matricula", nullable = false, length = 15)
	private String matricula;
	@Column(name = "correo", nullable = false, length = 40)
	private String correo;
	@Column(name = "telefono", nullable = false, length = 12)
	private String telefono;
	
	/*
	 * ESTE ES UN CONTROLADOR VACIO, ES NECESARIO EN SPRING BOOT
	 */
	public alumnosModel()
	{
		super();
	}
	/*
	 * ESTE ES UN CONSTRUCTOR CARGADO CON PARAMETROS, 
	 * LOS CONSTRUCTORES CARGADOS EN Spring Boot FACILITAN LA INYECCION DE 
	 * DEPENDENCIAS PROMUEVEN LA INMUTABILIDAD, Y MEJORAN LA TESTABILIDAD Y CLARIDAD 
	 * DEL CODIGO. 
	 */
	public alumnosModel(Long id, String nombres, String apellidos, String matricula, String correo, String telefono) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.matricula = matricula;
		this.correo = correo;
		this.telefono = telefono;
	}

	/*
	 * ESTOS SON LOS METODOS GETTER Y SETTER, SON ESCENCIALES PARA MANTENER 
	 * LA ENCAPSULACION EN JAVA, PROTEGIENDO LOS DATOS INTERNOS DE LAS CLASES Y  
	 * PERMITIENDO UN ACCESO Y MODIFICACION CONTROLADOS A LOS ATRIBUTOS.
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
