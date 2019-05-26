package com.huazai.b2c.aiyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 首页
 *              </ul>
 * @className HomePageController
 * @package com.huazai.b2c.aiyou.controller
 * @createdTime 2017年06月07日
 *
 * @version V1.0.0
 */
@Controller
public class HomePageController
{
	@RequestMapping("/")
	public String getIndex()
	{
		return "index";
	}

	@RequestMapping("{page}")
	public String getItemList(@PathVariable String page)
	{

		return page;
	}

}
