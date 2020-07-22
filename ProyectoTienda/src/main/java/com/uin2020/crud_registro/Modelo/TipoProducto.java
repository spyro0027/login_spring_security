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
@Table(name="tab_tipoproducto")
public class TipoProducto implements Serializable {

	private static final long serialVersionUID = 4997326348669327874L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="native")
	@GenericGenerator(name="native", strategy="native")
	@Column(name="id_tipo")
	private int idTipo;
	@Column(name="tipo_producto")
	private String tipoProducto;

	public TipoProducto(int idTipo, String tipoProducto) {
		super();
		this.idTipo = idTipo;
		this.tipoProducto = tipoProducto;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	
}
