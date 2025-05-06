package com.lit.consulting.pruebatecnica.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Entity
@Data
@Table(name ="tmCustomer")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message = "El nombre es obligatorio")
	private String nombres;
	@NotBlank(message = "El Apellido Paterno es obligatorio")
	private String apellidoPaterno;
	@NotBlank(message = "El Apellido Materno es obligatorio")
	private String apellidoMaterno;
	
	@Size(min = 1, max = 1, message = "Debe ser exactamente un carácter")
	private String sexo;
	private String fechaNacimiento;
	private String direccion;
	
	@Email(message = "Correo inválido")
    @NotBlank(message = "El correo es obligatorio")
	private String correo;
}
