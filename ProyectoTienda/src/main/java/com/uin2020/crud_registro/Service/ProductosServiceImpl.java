package com.uin2020.crud_registro.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uin2020.crud_registro.InterfaceService.IProductosService;
import com.uin2020.crud_registro.Interfaces.IProducto;
import com.uin2020.crud_registro.Modelo.Productos;

@Service
@Transactional
public class ProductosServiceImpl implements IProductosService {

	@Autowired
	IProducto crud;
	
	@Override
	public List<Productos> listarProductos() {
		
		return (List<Productos>) crud.findAll();
	}

	@Override
	public Optional<Productos> listarProductoPorId(int idProducto) {
		
		return crud.findById(idProducto);
	}

	@Override
	public int guardarProducto(Productos p) {
		int con= 0;
		Productos producto= crud.save(p);
		
		if(!producto.equals(null)) {
			con= 1;
		}
		
		return con;
	}

	@Override
	public void eliminarProducto(int idProducto) {
		crud.deleteById(idProducto);
	}

}
