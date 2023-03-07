package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Bodega;
import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Producto;
import com.example.demo.repo.IBodegaRepo;
import com.example.demo.repo.IInventarioRepo;
import com.example.demo.repo.IProductoRepo;

@Service
public class InventarioServiceImpl implements IInventarioService {

	@Autowired
	private IBodegaRepo bodegaRepo;

	@Autowired
	private IProductoRepo productoRepo;

	@Autowired
	private IInventarioRepo inventarioRepo;

	@Override
	public void ingresar(String numero, String codigo, Integer cantidad) {
		// TODO Auto-generated method stub
		Bodega bodega = this.bodegaRepo.buscarNumero(numero);
		Producto producto = this.productoRepo.buscarCodigoB(codigo);

		if (bodega == null) {
			System.out.println("Bodega es nulo");
		} else if (producto == null) {
			System.out.println("producto es nulo");
		} else {
			for (int i = 1; i <= cantidad; i++) {
				Inventario inventario = new Inventario();
				inventario.setBodega(bodega);
				inventario.setCodigoBIndividual(codigo + i);
				inventario.setProducto(producto);
				this.inventarioRepo.insertar(inventario);
			}

			this.productoRepo.actualizarStock(cantidad, producto.getId());
		}
	}

}
