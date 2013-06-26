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

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping()
	public String testpagelist(Model model,Page page,HttpServletRequest request) {
		List<Test> infoList = testService.listPageTest(page);
		model.addAttribute("testList", infoList);
		model.addAttribute("page", page);
		return "test/list";
		//return "test";
	}

}
