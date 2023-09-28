package com.ipartek.formacion.ejemplo.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private LocalDate fechaCaducidad;
}
