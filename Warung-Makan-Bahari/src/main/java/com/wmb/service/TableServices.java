package com.wmb.service;

import java.util.List;
import com.wmb.model.Tables;

public interface TableServices {
	List<Tables> findAll();
	Tables findById(Integer id) throws Exception;
	Tables save(Tables table);
	void delete(Integer id);
}
