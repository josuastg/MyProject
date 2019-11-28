package com.wmb.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmb.model.Foods;
import com.wmb.model.Tables;
import com.wmb.model.Cashier;
import com.wmb.model.Drinks;
import com.wmb.model.Order;
import com.wmb.model.Transaction;
import com.wmb.repository.TransactionRepo;
import com.wmb.service.FoodsServices;
import com.wmb.service.CashierServices;
import com.wmb.service.DrinksServices;
import com.wmb.service.TableServices;
import com.wmb.service.TransactionServices;

@Service
public class TransactionImpl implements TransactionServices {

	@Autowired
	TransactionRepo transactionRepo;

	@Autowired
	FoodsServices foodServices;

	@Autowired
	DrinksServices drinksServices;

	@Autowired
	TableServices tableServices;
	@Autowired
	CashierServices cashierServices;

	public void delete(Integer id) {
		transactionRepo.deleteById(id);
	}

	public List<Transaction> findAll() {
		return transactionRepo.findAll();
	}

	public List<Transaction> findByStatus(String status) {
		return transactionRepo.findByStatus(status);
	}

	public Transaction findById(Integer id) throws Exception {
		if (findAll().isEmpty()) {
			throw new Exception("404 List Not Found");
		} else {
			for (int i = 0; i < findAll().size(); i++) {
				Transaction index = findAll().get(i);
				if (index.getId() == id) {
					return index;
				}
			}
		}
		throw new Exception("Eror 404 Id Not Found");
	}

	public void validTableCust(Transaction transaction) throws Exception {
		Tables tables = tableServices.findById(transaction.getTables().getId());
		if (transaction.getQty_customer() > tables.getCapacity()) {
			throw new Exception("Table are not enough");
		}
		if (tables.getStatus().equals("NON AVAILABLE")) {
			throw new Exception("Dining table is used");
		}
		tables.setStatus("NON AVAILABLE");
		transaction.setTables(tables);
		transaction.setCashier(transaction.getCashier());
		}

	public void validStockMenu(Order order) throws Exception {
		Foods foods = foodServices.findById(order.getFoods().getId());
		if (foods.getStock() < order.getQty_foods()) {
			throw new Exception("Stock are not enough");}
		Integer stock_fds = foods.getStock() - order.getQty_foods();
		order.getFoods().setStock(stock_fds);
		Drinks drinks = drinksServices.findById(order.getDrinks().getId());
		if (drinks.getStock() < order.getQty_drinks()) {
			throw new Exception("Stock area not enough");}
		Integer stock_drks = drinks.getStock() - order.getQty_drinks();
		order.getDrinks().setStock(stock_drks);
	}

	public void setOrder(Transaction transaction) throws Exception {
		Integer totall = 0;
		for (Order order : transaction.getOrders()) {
			for (Drinks drinks : drinksServices.findAll()) {
				if (drinks.getId().equals(order.getDrinks().getId())) {order.setDrinks(drinks);}}
			for (Foods foods : foodServices.findAll()) {
				if (foods.getId().equals(order.getFoods().getId())) {order.setFoods(foods);}}

			Integer subtotal = (order.getFoods().getPrice() * order.getQty_foods()) + (order.getDrinks().getPrice() * order.getQty_drinks());
			order.setSubTotal(subtotal);
			totall += subtotal;
			validStockMenu(order);
			order.setTransaction(transaction);
		}	transaction.setTotal(totall);
	}

	public Transaction create(Transaction transaction) throws Exception, NumberFormatException {
		for (Cashier cashier : cashierServices.findAll()) {
			if (cashier.getId().equals(transaction.getCashier().getId())) {
				transaction.setCashier(cashier);
			}}
		transaction.setQty_customer(transaction.getQty_customer());
		validTableCust(transaction);
		setOrder(transaction);
		transaction.setStatus("Unpaid");
		return transactionRepo.save(transaction);
	}

	public Transaction update(Transaction transaction) throws Exception {
		transaction.setStatus("Paid");
		transaction.getTables().setStatus("AVAILABLE");
		return transactionRepo.save(transaction);
	}

}
