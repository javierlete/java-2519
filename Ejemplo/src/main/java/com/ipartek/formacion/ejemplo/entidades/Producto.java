package com.ipartek.formacion.ejemplo.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
	@Min(0)
	private Long id;
	
	@NotNull
	@Size(min = 3)
	@Pattern(regexp="^[A-Z][a-z ]*$")
	private String nombre;
	
	@NotNull
	@Min(0)
	private BigDecimal precio;

	@Future
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCaducidad;
}
