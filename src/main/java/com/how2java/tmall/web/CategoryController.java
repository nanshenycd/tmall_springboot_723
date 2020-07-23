package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
 
@RestController
public class CategoryController {
	@Autowired CategoryService categoryService;

	/**
	 * 遍历查询分类商品信息的接口
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/categories")
    public List<Category> list() throws Exception {
    	return categoryService.list();
    }

	/**
	 * 保存分类商品信息的接口
	 * @param category
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/categories")
    public Category save(Category category)throws Exception {
		Category save = categoryService.save(category);
		return save;
	}

	/**
	 * 删除分类商品信息的接口
	 * @param id
	 * @param request
	 * @return
	 */
	@DeleteMapping("categories/{id}")
	public String delete(@PathVariable("id") int id, HttpServletRequest request){
		categoryService.delete(id);
		return "delete successfully";
	}

	/**
	 * 编辑分类商品信息的接口
	 * @param id
	 * @param request
	 * @return
	 */
	@GetMapping("categories/{id}")
	public Category get(@PathVariable("id")int id,HttpServletRequest request){
		Category bean = categoryService.get(id);
		return bean;
	}
}

