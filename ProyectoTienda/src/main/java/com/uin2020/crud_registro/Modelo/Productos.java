package com.uin2020.crud_registro.Modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tab_productos")
public class Productos implements Serializable {

	private static final long serialVersionUID = -8936872608082175798L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="native")
	@GenericGenerator(name="native", strategy="native")
	@Column(name="id_producto")
	private int idProducto;
	@Column(name="CodProducto")
	private String codProducto;
	@Column(name="NombreProducto")
	private String nombreProducto;
	@Column(name="Existencia")
	private int existencia;
	@Column(name="fk_tipo_producto")
	private int fkTipoProducto;
	
	public Productos() {
		
	}
	
	public Productos(int idProducto, String codProducto, String nombreProducto, int existencia, int fkTipoProducto) {
		super();
		this.idProducto = idProducto;
		this.codProducto = codProducto;
		this.nombreProducto = nombreProducto;
		this.existencia = existencia;
		this.fkTipoProducto = fkTipoProducto;
	}


	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public String getCodProducto() {
		return codProducto;
	}


	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}


	public String getNombreProducto() {
		return nombreProducto;
	}


	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}


	public int getExistencia() {
		return existencia;
	}


	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}


	public int getFkTipoProducto() {
		return fkTipoProducto;
	}


	public void setFkTipoProducto(int fkTipoProducto) {
		this.fkTipoProducto = fkTipoProducto;
	}
	
}
