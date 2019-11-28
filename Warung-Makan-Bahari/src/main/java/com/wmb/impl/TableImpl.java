package com.wmb.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmb.model.Tables;
import com.wmb.repository.TableRepo;
import com.wmb.service.TableServices;

@Service
public class TableImpl implements TableServices {
	
	@Autowired
	TableRepo tableRepo;
	
	public List<Tables> findAll() {
		return tableRepo.findAll();
	}


	public Tables findById(Integer id) throws Exception {
		if (findAll().isEmpty()) {
			throw new Exception("404 List Not Found");
		} else {
			for (int i = 0; i < findAll().size(); i++) {
				Tables index = findAll().get(i);
				if (index.getId() == id) {
					return index;
				}
			}
		}
		throw new Exception("Eror 404 Id Not Found");
	}
	public Tables save(Tables table) {
		return tableRepo.save(table);
	}
	public void delete(Integer id) {
		tableRepo.deleteById(id);
	}

}
