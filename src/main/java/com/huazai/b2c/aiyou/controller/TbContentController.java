package com.huazai.b2c.aiyou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huazai.b2c.aiyou.common.EasyUIDataGrid;
import com.huazai.b2c.aiyou.pojo.TbContent;
import com.huazai.b2c.aiyou.service.TbContentService;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description TbContent的Controller类
 *              </ul>
 * @className TbContentController
 * @package com.huazai.b2c.aiyou.controller
 * @createdTime 2017年06月11日
 *
 * @version V1.0.0
 */
@Controller
@RequestMapping(value = "/content/query")
public class TbContentController
{

	@Autowired
	private TbContentService tbContentService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public EasyUIDataGrid getContentList(Integer page, Integer rows,TbContent tbContent)
	{
		/*TbContent tbContent = new TbContent();
		tbContent.setCategoryId(categoryId);*/
		EasyUIDataGrid tbContentList = tbContentService.getTbContentList(page, rows, tbContent);
		return tbContentList;
	}

}
