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
@Table(name = "desk")
public class Tables {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column
	private Integer capacity;

	@Column
	private String status;

	@OneToMany(mappedBy = "tables", cascade = CascadeType.ALL)
	private List<Transaction> transactions;

	public Tables() {
	}

	public Tables(Integer id, String name, Integer capacity, String status) {
		this.name = name;
		this.capacity = capacity;
		this.status = status;
		this.id = id;
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tables tables = (Tables) o;
		return Objects.equals(id, tables.id) &&
				Objects.equals(name, tables.name) &&
				Objects.equals(capacity, tables.capacity) &&
				Objects.equals(status, tables.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, capacity, status);
	}
}
