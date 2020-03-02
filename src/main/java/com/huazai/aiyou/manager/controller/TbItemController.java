package com.huazai.aiyou.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huazai.aiyou.common.module.EasyUIDataGrid;
import com.huazai.aiyou.common.response.AiyouResultData;
import com.huazai.aiyou.manager.pojo.TbItem;
import com.huazai.aiyou.manager.service.TbItemDescService;
import com.huazai.aiyou.manager.service.TbItemService;

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

	@Autowired
	private TbItemDescService tbItemDescService;

	@Description(value = "获取商品列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGrid getItemList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "row", defaultValue = "30") Integer rows)
	{
		EasyUIDataGrid easyUIDataGrid = tbItemService.getTbItemList(page, rows, null);
		return easyUIDataGrid;
	}

	@Description(value = "添加商品")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData addTbItem(TbItem item, String desc)
	{
		AiyouResultData resultData = tbItemService.addTbItem(item, desc);
		return resultData;
	}

	@Description(value = "删除商品")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData deleteTbItem(String ids)
	{
		AiyouResultData resultData = tbItemService.deleteTbItem(ids);
		return resultData;
	}

	@Description(value = "下架商品")
	@RequestMapping(value = "/instock", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData instockTbItem(String ids)
	{
		AiyouResultData resultData = tbItemService.instockTbItem(ids);
		return resultData;
	}

	@Description(value = "上架商品")
	@RequestMapping(value = "/reshelf", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData reshelfTbItem(String ids)
	{
		AiyouResultData resultData = tbItemService.reshelfTbItem(ids);
		return resultData;
	}

	@Description(value = "查询商品参数")
	@RequestMapping(value = "/param/item/query/{itemId}")
	@ResponseBody
	public AiyouResultData queryTbItemParam(@PathVariable(value = "itemId") Long itemId)
	{
		AiyouResultData resultData = tbItemService.findTbItemById(itemId);
		return resultData;
	}

	@Description(value = "查询商品描述信息")
	@RequestMapping(value = "/query/item/desc/{itemId}")
	@ResponseBody
	private AiyouResultData queryTbItemDesc(@PathVariable(value = "itemId") Long itemId)
	{
		AiyouResultData resultData = tbItemDescService.findTbItemDescById(itemId);
		return resultData;
	}

	@Description(value = "修改商品信息")
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData updateTbItem(TbItem tbItem, String desc)
	{
		AiyouResultData resultData = tbItemService.updateTbItem(tbItem, desc);
		return resultData;
	}

}
