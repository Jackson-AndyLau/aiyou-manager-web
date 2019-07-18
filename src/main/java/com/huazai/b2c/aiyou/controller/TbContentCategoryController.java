package com.huazai.b2c.aiyou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huazai.b2c.aiyou.common.EasyUITreeNode;
import com.huazai.b2c.aiyou.repo.AiyouResultData;
import com.huazai.b2c.aiyou.service.TbContentCategoryService;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TbContentCategory 的 Controller 层
 *              </ul>
 * @className TbContentCategoryController
 * @package com.huazai.b2c.aiyou.controller
 * @createdTime 2017年06月10日
 *
 * @version V1.0.0
 */
@RequestMapping(value = "/content/category")
@Controller
public class TbContentCategoryController
{

	@Autowired
	private TbContentCategoryService tbContentCategoryService;

	@Description("获取网站内容分类列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<EasyUITreeNode> getContentCategoryList(@RequestParam(value = "id", defaultValue = "0") Long parentId)
	{
		List<EasyUITreeNode> contentCategoryList = tbContentCategoryService.getTbContentCategoryList(parentId);
		return contentCategoryList;
	}

	@Description("创建网站内容分类")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData createContentCategory(Long parentId, String name)
	{
		AiyouResultData aiyouResultData = tbContentCategoryService.addTbContentCategory(parentId, name);
		return aiyouResultData;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData updateContentCategory(Long id, String name)
	{
		AiyouResultData resultData = tbContentCategoryService.updateTbContentCategory(id, name);
		return resultData;
	}

	@Description("删除网站内容分类")
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AiyouResultData deleteTbContentCategory(Long id)
	{
		AiyouResultData resultData = tbContentCategoryService.deleteTbContentCategory(id);
		return resultData;
	}

}
