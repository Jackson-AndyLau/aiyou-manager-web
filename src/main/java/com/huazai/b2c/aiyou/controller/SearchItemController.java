package com.huazai.b2c.aiyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huazai.b2c.aiyou.repo.AiyouResultData;
import com.huazai.b2c.aiyou.service.SearchItemService;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 搜索商品Controller层
 *              </ul>
 * @className SearchItemController
 * @package com.huazai.b2c.aiyou.controller
 * @createdTime 2017年06月15日
 *
 * @version V1.0.0
 */
@Controller
@RequestMapping(value = "/search/item")
public class SearchItemController {

	@Autowired
	private SearchItemService searchItemService;

	@RequestMapping(value = "/importall", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData importItemAll() {
		AiyouResultData resultData = searchItemService.importItemAll();
		return resultData;
	}

}
