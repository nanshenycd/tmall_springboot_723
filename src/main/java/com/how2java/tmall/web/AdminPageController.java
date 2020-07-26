package com.how2java.tmall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {
	/**
	 * 默认跳转到遍历
	 * @return
	 */
	@GetMapping(value="/admin")
    public String admin(){
		return "redirect:admin_category_list";
    }

	/**
	 * 遍历方法
	 * @return
	 */
	@GetMapping(value="/admin_category_list")
	public String listCategory(){
		return "admin/listCategory";
	}

	/**
	 * 增加方法
	 * @return
	 */
	@GetMapping(value = "/admin_category_delete")
	public String add(){
		return "redirect:admin_category_list";
	}

	/**
	 * 删除方法
	 * @return
	 */
	@GetMapping(value = "/admin_cateory_add")
	public String delete(){
		return "redirect:admin_category_list";
	}

	/**
	 * 修改方法
	 * @return
	 */
	@GetMapping(value = "admin_category_edit")
	public String update(){
		return "admin/editCategory";
	}
}
