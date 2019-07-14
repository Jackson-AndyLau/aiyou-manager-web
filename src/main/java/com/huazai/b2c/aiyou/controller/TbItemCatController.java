package com.huazai.b2c.aiyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huazai.b2c.aiyou.common.EasyUITreeNode;
import com.huazai.b2c.aiyou.service.TbItemCatService;

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

	@RequestMapping(value = "/list")
	@ResponseBody
	public List<EasyUITreeNode> getTbItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId)
	{
		List<EasyUITreeNode> list = tbItemCatService.getTbItemCatList(parentId);
		return list;
	}

}
