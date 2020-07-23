package com.how2java.tmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.how2java.tmall.dao.CategoryDAO;
import com.how2java.tmall.pojo.Category;

@Service
public class CategoryService {
	@Autowired CategoryDAO categoryDAO;


	public List<Category> list() {
    	Sort sort = new Sort(Sort.Direction.DESC, "id");
		return categoryDAO.findAll(sort);
	}

	public Category save(Category bean) {
		return categoryDAO.save(bean);
	}

	public String delete(int id){
		 categoryDAO.delete(id);
		 return "delete is successfully";
	}

	public Category get(int id){
		Category c = categoryDAO.findOne(id);
		return c;
	}
}
