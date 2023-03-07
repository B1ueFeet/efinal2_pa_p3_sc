package com.example.demo.repo;

import com.example.demo.modelo.Producto;

public interface IProductoRepo {

	public Producto buscarCodigoB(String codigoB);

	public void insertar(Producto producto);

	public Integer actualizarStock(Integer stock, Integer id);

}
