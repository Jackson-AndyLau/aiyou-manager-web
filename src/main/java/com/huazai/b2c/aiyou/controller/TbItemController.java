package com.huazai.b2c.aiyou.controller;

import java.lang.invoke.MethodType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.Log;
import com.huazai.b2c.aiyou.common.EasyUIDataGrid;
import com.huazai.b2c.aiyou.service.TbItemService;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 商品信息controller层
 *              </ul>
 * @className TbItemController
 * @package com.huazai.b2c.aiyou.controller
 * @createdTime 2017年06月09日
 *
 * @version V1.0.0
 */
@Controller
@RequestMapping(value = "/item")
public class TbItemController
{

	@Autowired
	private TbItemService tbItemService;

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public EasyUIDataGrid getItemList(Integer page, Integer rows)
	{

		return tbItemService.getItemList(page, rows, null);
	}
}
