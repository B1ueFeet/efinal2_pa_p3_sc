package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Bodega;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class BodegaRepoImpl implements IBodegaRepo {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Bodega buscarNumero(String numero) {
		TypedQuery<Bodega> query = this.manager.createQuery("SELECT b FROM Bodega b WHERE b.numero = :datoNumero",
				Bodega.class);
		query.setParameter("datoNumero", numero);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			System.out.println("HAY MAS DE UNO O NO EXISTE");
			return null;
		}
	}

	@Override
	public void insertar(Bodega bodega) {
		this.manager.persist(bodega);

	}

}
