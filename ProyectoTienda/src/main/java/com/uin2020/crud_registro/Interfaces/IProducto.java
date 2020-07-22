package com.uin2020.crud_registro.Interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uin2020.crud_registro.Modelo.Productos;

@Repository
public interface IProducto extends JpaRepository<Productos, Integer>{
	
}
