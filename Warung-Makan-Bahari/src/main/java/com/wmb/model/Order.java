package com.wmb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private Integer qty_foods;

	@Column
	private Integer qty_drinks;

	@Column(name = "sub_total")
	private Integer subTotal;

	@ManyToOne
	@JoinColumn(name = "foods_id", nullable = true)
	private Foods foods;

	@ManyToOne
	@JoinColumn(name = "drinks_id", nullable = true)
	private Drinks drinks;

	@ManyToOne
	@JoinColumn(name = "transaction_id", nullable = false)
	@JsonIgnore
	private Transaction transaction;

	public Order() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQty_foods() {
		return qty_foods;
	}

	public void setQty_foods(Integer qty_foods) {
		this.qty_foods = qty_foods;
	}

	public Integer getQty_drinks() {
		return qty_drinks;
	}

	public void setQty_drinks(Integer qty_drinks) {
		this.qty_drinks = qty_drinks;
	}

	public Integer getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Integer subTotal) {
		this.subTotal = subTotal;
	}

	public Foods getFoods() {
		return foods;
	}

	public void setFoods(Foods foods) {
		this.foods = foods;
	}

	public Drinks getDrinks() {
		return drinks;
	}

	public void setDrinks(Drinks drinks) {
		this.drinks = drinks;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
}
