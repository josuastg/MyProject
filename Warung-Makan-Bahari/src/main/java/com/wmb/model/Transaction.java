package com.wmb.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name_pic")
	private String name;

	@Column
	private Date date;

	@Column
	private Integer total;
	
	@Column
	private Integer qty_customer;

	@Column
	private String status;



	@ManyToOne
	@JoinColumn(name = "cashier_id", nullable = false)
	private Cashier cashier;

	@OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
	private List<Order> orders;

	@ManyToOne
	@JoinColumn(name = "desk_id", nullable = true)
	private Tables tables;

	public Transaction() {
		this.date = new Date(System.currentTimeMillis());
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Cashier getCashier() {
		return cashier;
	}
	
	
	public Integer getQty_customer() {
		return qty_customer;
	}

	public void setQty_customer(Integer qty_customer) {
		this.qty_customer = qty_customer;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public List<Order> getOrders() {
		return orders;
	}
//
//	public void setOrders(List<Order> orders) {
//		this.orders = orders;
//	}

	public Tables getTables() {
		return tables;
	}

	public void setTables(Tables tables) {
		this.tables = tables;
	}
}
