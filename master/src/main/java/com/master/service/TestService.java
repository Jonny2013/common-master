package com.master.service;

import java.util.List;

import com.master.model.Test;
import com.master.plugin.Page;

public interface TestService {
	List<Test> listPageTest(Page page);
}
