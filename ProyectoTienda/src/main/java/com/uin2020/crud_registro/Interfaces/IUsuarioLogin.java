package com.uin2020.crud_registro.Interfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uin2020.crud_registro.Modelo.Usuario;

@Repository
public interface IUsuarioLogin extends CrudRepository<Usuario, Integer> {

	 Optional<Usuario> findByUsername(String Usuario);
	
}
