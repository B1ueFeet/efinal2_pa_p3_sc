package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repo.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo productoRepo;

	@Override
	public Producto encontrar(String codigoB) {
		// TODO Auto-generated method stub
		return this.productoRepo.buscarCodigoB(codigoB);
	}

	@Override
	public void crear(Producto producto) {
		// TODO Auto-generated method stub
		this.productoRepo.insertar(producto);
	}

	@Override
	public Integer actualizarCatalogo(Integer stock, Integer id) {
		// TODO Auto-generated method stub
		return this.productoRepo.actualizarStock(stock, id);
	}

}
