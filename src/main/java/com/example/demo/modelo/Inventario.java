package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {

	@Id
	@SequenceGenerator(name = "seq_inve", initialValue = 1, sequenceName = "seq_inve")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_inve")
	@Column(name = "inve_id")
	private Integer id;
	@Column(name = "inve_codigo_barras_individual")
	private String codigoBIndividual;
	@Column(name = "inve_numero")
	private String numero;

	// RELACIONES
	@ManyToOne
	@JoinColumn(name = "inve_codigo_producto")
	private Producto producto;
	@ManyToOne
	@JoinColumn(name = "inve_numero_bodega")
	private Bodega bodega;

	// GETTER & SETTER
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBIndividual() {
		return codigoBIndividual;
	}

	public void setCodigoBIndividual(String codigoBIndividual) {
		this.codigoBIndividual = codigoBIndividual;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}
	
	

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Inventario [id=" + id + ", codigoBIndividual=" + codigoBIndividual + "]";
	}

}
