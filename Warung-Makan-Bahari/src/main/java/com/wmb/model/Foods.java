package com.wmb.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "foods")
public class Foods {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column
	private Integer price;

	@Column
	private Integer stock;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Foods)) return false;
		Foods foods = (Foods) o;
		return Objects.equals(getId(), foods.getId()) &&
				Objects.equals(getName(), foods.getName()) &&
				Objects.equals(getPrice(), foods.getPrice()) &&
				Objects.equals(getStock(), foods.getStock());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getPrice(), getStock());
	}

	@OneToMany(mappedBy = "foods", cascade = CascadeType.ALL)
	private List<Order> orders;

	public Foods() {
	}
	

	public Foods(Integer id) {
		super();
		this.id = id;
	}


	public Foods(Integer id, String name, Integer price, Integer stock) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
}