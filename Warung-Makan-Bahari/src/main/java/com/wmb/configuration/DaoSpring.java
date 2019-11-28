package com.wmb.configuration;

import org.springframework.context.annotation.Bean;

import com.wmb.impl.OrderImpl;
import com.wmb.impl.TableImpl;
import com.wmb.impl.CashierImpl;
import com.wmb.impl.DrinksImpl;
import com.wmb.impl.FoodsImpl;
import com.wmb.impl.TransactionImpl;
import com.wmb.service.OrderServices;
import com.wmb.service.TableServices;
import com.wmb.service.CashierServices;
import com.wmb.service.DrinksServices;
import com.wmb.service.FoodsServices;
import com.wmb.service.TransactionServices;

public class DaoSpring {

	@Bean
	public TransactionServices transaksiServices() {
		return new TransactionImpl();
	}

	@Bean
	public FoodsServices foodsServices() {
		return new FoodsImpl();
	}

	@Bean
	public DrinksServices drinksServices() {
		return new DrinksImpl();
	}

	@Bean
	public TableServices tableServices() {
		return new TableImpl();
	}

	@Bean
	public OrderServices orderServices() {
		return new OrderImpl();
	}
	
	@Bean
	public CashierServices cashierServices() {
		return new CashierImpl();
	}

}
