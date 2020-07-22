package com.uin2020.crud_registro.InterfaceService;

import java.util.List;
import java.util.Optional;

import com.uin2020.crud_registro.Modelo.Productos;

public interface IProductosService {

	public List<Productos> listarProductos();
	public Optional<Productos> listarProductoPorId(int idProducto);
	public int guardarProducto(Productos p);
	public void eliminarProducto(int idProducto);
}
