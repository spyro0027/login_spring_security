package com.uin2020.crud_registro.Interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uin2020.crud_registro.Modelo.Usuario;



@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer>{
	
	

}
