package com.master.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.master.model.Test;
import com.master.plugin.Page;
import com.master.service.TestService;
import com.master.util.dwz.AjaxObject;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String preCreate(Map<String, Object> map) {
		return "test/create";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public @ResponseBody String create(Test test) {
		testService.insert(test);
		return AjaxObject.newOk("添加成功！").toString();
	}
	
	@RequestMapping("/list")
	public String testpagelist(Model model,Page page,Test test) {
		test.setPage(page);
		List<Test> infoList = testService.listPageTest2(test);
		model.addAttribute("testList", infoList);
		model.addAttribute("page", page);
		return "test/list";
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public @ResponseBody String deleteTest(Long ids[]){
		for (int i = 0; i < ids.length; i++) {
			Long id = Long.valueOf(ids[i]);
			testService.deleteTestById(id);
		}
		return AjaxObject.newOk("任务删除成功！").setCallbackType("").toString();
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String preUpdate(@PathVariable Long id, Map<String, Object> map) {
		Test test = testService.getObject(id);
		map.put("test", test);
		return "test/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody String update(Test test) {
		testService.updateObject(test);
		return AjaxObject.newOk("修改成功！").toString();
	}

}
