package com.niu2020.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class RolModelo {
	//preparar campo id para mapeo y generacion automatico 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Se basa en una columna de base de datos con incremento automático y permite que la base de datos genere un nuevo valor con cada operación de inserción.
	//Desde el punto de vista de la base de datos, esto es muy eficiente porque las columnas de incremento automático están altamente optimizadas y no requiere ninguna declaración adicional.
// Este enfoque tiene un inconveniente importante si usa Hibernate, ya que requiere un valor de clave principal para cada entidad administrada y, por lo tanto, debe realizar la instrucción de inserción de inmediato. Esto evita que utilice diferentes técnicas de optimización  como el procesamiento por lotes JDBC.
	
	private Long idrol;
	private String nrol;
	//generar getter and setter
	public Long getIdrol() {
		return idrol;
	}
	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}
	public String getNrol() {
		return nrol;
	}
	public void setNrol(String nrol) {
		this.nrol = nrol;
	}
	
}
