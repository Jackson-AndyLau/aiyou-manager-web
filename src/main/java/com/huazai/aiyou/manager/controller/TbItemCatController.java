package com.huazai.aiyou.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huazai.aiyou.common.module.EasyUIDataGrid;
import com.huazai.aiyou.common.module.EasyUITreeNode;
import com.huazai.aiyou.manager.service.TbItemCatService;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TbItemCat 的 Controller
 *              </ul>
 * @className TbItemCatController
 * @package com.huazai.b2c.aiyou.controller
 * @createdTime 2017年06月11日
 *
 * @version V1.0.0
 */
@Controller
@RequestMapping(value = "/item/cat")
public class TbItemCatController
{

	@Autowired
	private TbItemCatService tbItemCatService;

	@Description("根据父级ID获取商品规格列表")
	@RequestMapping(value = "/list")
	@ResponseBody
	public List<EasyUITreeNode> getTbItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId)
	{
		List<EasyUITreeNode> list = tbItemCatService.getTbItemCatListById(parentId);
		return list;
	}
	
	@Description(value = "获取商品规格列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGrid getItemList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "row", defaultValue = "30") Integer rows)
	{
		EasyUIDataGrid easyUIDataGrid = tbItemCatService.getTbItemCatList(page, rows, null);
		return easyUIDataGrid;
	}

}
