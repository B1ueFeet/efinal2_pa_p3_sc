package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ProductoRepoImpl implements IProductoRepo {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Producto buscarCodigoB(String codigoB) {
		TypedQuery<Producto> query = this.manager.createQuery("SELECT p FROM Producto p WHERE p.codigoB = :datoCodigo",
				Producto.class);
		query.setParameter("datoCodigo", codigoB);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			System.out.println("HAY MAS DE UNO O NO EXISTE");
			return null;
		}
	}

	@Override
	public void insertar(Producto producto) {
		this.manager.persist(producto);

	}

	@Override
	public Integer actualizarStock(Integer stock, Integer id) {
		Query query = this.manager.createQuery("UPDATE Producto e SET e.stock = :datoStock where e.id = :datoId");
		query.setParameter("datoStock", stock);
		query.setParameter("datoId", id);
		return query.executeUpdate();
	}
}
