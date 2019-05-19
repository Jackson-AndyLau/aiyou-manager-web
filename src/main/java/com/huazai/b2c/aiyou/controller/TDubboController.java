package com.huazai.b2c.aiyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huazai.b2c.aiyou.service.TDubboService;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TODO
 *              </ul>
 * @className TDubboController
 * @package com.huazai.b2c.aiyou.controller
 * @createdTime 2017年06月07日
 *
 * @version V1.0.0
 */
@RequestMapping("/test")
@Controller
public class TDubboController
{

	@Autowired
	private TDubboService tDubboService;

	@RequestMapping("/getLocalDate")
	public String getLocalDate()
	{

		return tDubboService.getLocalDate();
	}

}
