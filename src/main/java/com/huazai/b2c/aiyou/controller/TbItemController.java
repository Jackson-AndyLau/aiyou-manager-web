package com.huazai.b2c.aiyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huazai.b2c.aiyou.common.EasyUIDataGrid;
import com.huazai.b2c.aiyou.pojo.TbItem;
import com.huazai.b2c.aiyou.repo.AiyouResultData;
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

	@Description(value = "获取商品列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGrid getItemList(Integer page, Integer rows)
	{

		EasyUIDataGrid easyUIDataGrid = tbItemService.getTbItemList(page, rows, null);
		return easyUIDataGrid;
	}

	@Description(value = "添加商品")
	@RequestMapping(value = "/save")
	@ResponseBody
	public AiyouResultData addTbItem(TbItem item, String desc)
	{
		AiyouResultData resultData = tbItemService.addTbItem(item, desc);
		return resultData;
	}
}
