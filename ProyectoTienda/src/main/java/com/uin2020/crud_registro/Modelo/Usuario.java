package com.uin2020.crud_registro.Modelo;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="tab_usuarios")
public class Usuario {
	
	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private int IdUsuario;
	@Column(name="nombres")
	private String nombres;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	@Column(name="foto")
	private String Foto;
	@Column(name="correo")
	private String Correo;
	@Column(name="fecha_creacion")
	private String FechaCreacion;

	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="roles_usuario", joinColumns=@JoinColumn(name="id_user"),
				inverseJoinColumns=@JoinColumn(name="id_rol"))
	private Set<Cargos> FkCargo;


	public Usuario() {
		
		// TODO Auto-generated constructor stub
	}





	public Usuario(int idUsuario,String nombres, String apellidos, String username, String password, String foto, String correo, String fechaCreacion,
			Set<Cargos> fkCargo) {
		super();
		IdUsuario = idUsuario;
		this.nombres= nombres;
		this.apellidos= apellidos;
		this.username = username;
		this.password = password;
		Foto = foto;
		Correo = correo;
		FechaCreacion = fechaCreacion;
		FkCargo = fkCargo;
	}





	public int getIdUsuario() {
		return IdUsuario;
	}





	public void setIdUsuario(int idUsuario) {
		IdUsuario = idUsuario;
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





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEnabled() {
		return enabled;
	}





	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}





	public String getFoto() {
		return Foto;
	}





	public void setFoto(String foto) {
		Foto = foto;
	}





	public String getCorreo() {
		return Correo;
	}





	public void setCorreo(String correo) {
		Correo = correo;
	}





	public String getFechaCreacion() {
		return FechaCreacion;
	}





	public void setFechaCreacion(String fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}





	public Set<Cargos> getFkCargo() {
		return FkCargo;
	}





	public void setFkCargo(Set<Cargos> fkCargo) {
		FkCargo = fkCargo;
	}





}
