package com.niu2020.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

// despues de crear los getter a setter  agregar la anotacion de entidad
@Entity
//validacion que impide el ingreso de datos repetidos a la base de datos en este caso validaremos el correo para que
// que sea unico para el usuario asi evitar un registro de dato repetido  en diferentes usuarios 
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames ="correo") )
public class UsuarioModelo {
	//crear campo de usuario crear constructores de campo menos el de id 
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
private long idusuarios;
private String nombre1;
private String apellido;
private String correo;
private String claveusuario;
// array roles disponibles
// definimos el campo con una relacion de muchos a muchos y aplicamos una ejecucion es cascada para todos los datos que guarden relacion 
@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
@JoinTable(
		name = "users_roles",
		joinColumns = @JoinColumn(
	            name = "user_id", referencedColumnName = "idusuarios"),
		inverseJoinColumns = @JoinColumn(
			            name = "role_id", referencedColumnName = "idrol"))	
private Collection<RolModelo> roles; 
//crear constructores usando fields (escudos ) menos del campo id 
public UsuarioModelo(String nombre1, String apellido, String correo, String claveusuario, Collection<RolModelo> roles) {
	super();
	this.nombre1 = nombre1;
	this.apellido = apellido;
	this.correo = correo;
	this.claveusuario = claveusuario;
	this.roles = roles;
}
// generar los getter and setter menos del id 
public long getIdusuarios() {
	return idusuarios;
}
public void setIdusuarios(long idusuarios) {
	this.idusuarios = idusuarios;
}
public String getNombre1() {
	return nombre1;
}
public void setNombre1(String nombre1) {
	this.nombre1 = nombre1;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getClaveusuario() {
	return claveusuario;
}
public void setClaveusuario(String claveusuario) {
	this.claveusuario = claveusuario;
}
public Collection<RolModelo> getRoles() {
	return roles;
}
public void setRoles(Collection<RolModelo> roles) {
	this.roles = roles;
}

 }
