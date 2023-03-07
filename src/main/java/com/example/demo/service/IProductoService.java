package com.example.demo.service;

import com.example.demo.modelo.Producto;

public interface IProductoService {

	public Producto encontrar(String codigoB);

	public void crear(Producto producto);

	public Integer actualizarCatalogo(Integer stock, Integer id);

}
