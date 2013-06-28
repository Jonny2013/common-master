package com.master.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.master.model.Test;
import com.master.plugin.Page;
import com.master.service.TestService;
import com.master.util.dwz.AjaxObject;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/list")
	public String testpagelist(Model model,Page page,Test test) {
		test.setPage(page);
		List<Test> infoList = testService.listPageTest2(test);
		model.addAttribute("testList", infoList);
		model.addAttribute("page", page);
		return "test/list";
		//return "test";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteTest(Long ids[]){
		String[] titles = new String[ids.length];
		for (int i = 0; i < ids.length; i++) {
			
		}
		return "";
	}

}
