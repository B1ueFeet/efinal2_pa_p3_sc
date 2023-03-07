package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@SequenceGenerator(name = "seq_prod", initialValue = 1, sequenceName = "seq_prod")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_prod")
	@Column(name = "produ_id")
	private Integer id;
	@Column(name = "produ_codigo_barras")
	private String codigoB;
	@Column(name = "produ_categoria")
	private String categoria;
	@Column(name = "produ_stock")
	private Integer stock = 0;
	@Column(name = "produ_nombre")
	private String Nombre;

	// RELACIONES
	@OneToMany(mappedBy = "producto")
	private List<Inventario> inventarios;

	// GETTER SETTER
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoB() {
		return codigoB;
	}

	public void setCodigoB(String codigoB) {
		this.codigoB = codigoB;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<Inventario> getInventarios() {
		return inventarios;
	}

	public void setInventarios(List<Inventario> inventarios) {
		this.inventarios = inventarios;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigoB=" + codigoB + ", categoría=" + categoria + ", stock=" + stock + "]";
	}

}
