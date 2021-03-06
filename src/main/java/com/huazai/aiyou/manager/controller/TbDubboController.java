package com.huazai.aiyou.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huazai.aiyou.manager.service.TbDubboService;

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
public class TbDubboController
{

	@Autowired
	private TbDubboService tDubboService;

	@RequestMapping("/getLocalDate")
	public String getLocalDate()
	{

		return tDubboService.getLocalDate();
	}

}
