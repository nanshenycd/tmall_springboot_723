package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.how2java.tmall.dao.CategoryDAO;
import com.how2java.tmall.pojo.Category;

@Service
public class CategoryService {
	@Autowired CategoryDAO categoryDAO;


	public Page4Navigator<Category> list(int start, int size, int navigatePages) {
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		Pageable pageable = new PageRequest(start, size,sort);
		Page pageFromJPA =categoryDAO.findAll(pageable);

		return new Page4Navigator<>(pageFromJPA,navigatePages);
	}

	/**
	 * 遍历的方法
	 * @return
	 */
	public List<Category> list() {
		//分页
    	Sort sort = new Sort(Sort.Direction.DESC, "id");
		return categoryDAO.findAll(sort);
	}

	/**
	 * 增加的方法
	 * @param bean
	 * @return
	 */
	public Category save(Category bean) {
		return categoryDAO.save(bean);
	}

	/**
	 * 删除的方法
	 * @param id
	 * @return
	 */
	public String delete(int id){
		 categoryDAO.delete(id);
		 return "delete is successfully";
	}

	/**
	 * 获取的方法
	 * @param id
	 * @return
	 */
	public Category get(int id){
		Category c = categoryDAO.findOne(id);
		return c;
	}
}
