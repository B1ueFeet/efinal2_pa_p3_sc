package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Inventario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class InventarioRepoImpl implements IInventarioRepo {
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Inventario inventario) {
		this.manager.persist(inventario);

	}

}
