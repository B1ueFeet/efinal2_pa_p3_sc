package com.example.demo.repo;

import com.example.demo.modelo.Bodega;

public interface IBodegaRepo {

	public Bodega buscarNumero(String numero);

	public void insertar(Bodega bodega);

}
