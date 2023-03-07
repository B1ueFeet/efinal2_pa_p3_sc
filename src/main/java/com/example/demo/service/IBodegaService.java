package com.example.demo.service;

import com.example.demo.modelo.Bodega;

public interface IBodegaService {

	public Bodega encontrar(String numero);

	public void crear(Bodega bodega);

}
