package com.huazai.b2c.aiyou.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.huazai.b2c.aiyou.utils.JsonUtils;
import com.huazai.b2c.aiyou.web.util.FastDFSClient;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 图片操作 Controller
 *              </ul>
 * @className PictureController
 * @package com.huazai.b2c.aiyou.controller
 * @createdTime 2017年06月11日
 *
 * @version V1.0.0
 */
@Controller
@RequestMapping("/pic")
public class PictureController
{

	// @Value("${AIYOU_IMAGE_BASE_URL}")
	private String AIYOU_IMAGE_BASE_URL = "http://192.168.159.159:7070/";

	// private String DFS_CONF = "classpath:resources/fdfs_client.conf";

	/**
	 * 
	 * @author HuaZai
	 * @contact who.seek.me@java98k.vip
	 * @title fileUpload
	 *        <ul>
	 * @description 上传图片
	 *              <li>KindEditor的图片上传插件，对浏览器兼容性不好，不能使用JSON响应
	 *              <li>@ResponseBody注解返回java对象实际上是JSON数据，返回的Content-Type为：application/json;charset=UTF-8
	 *              <li>返回字符串时的Content-Type为：text/plain;charset=UTF-8，所需要修改为：
	 *              produces = "text/plain;charset=utf-8"
	 *              </ul>
	 * @createdTime 2017年06月11日
	 * @param multipartFile
	 * @return
	 * @return Map
	 *
	 * @version : V1.0.0
	 */
	@RequestMapping(value = "/upload", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String fileUpload(MultipartFile uploadFile)
	{
		try
		{
			// 1、获取上传文件的扩展
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
			// 2、创建一个FastDFS对象
			FastDFSClient dfsClient = new FastDFSClient("src/main/resources/resources/fdfs_client.conf");
			// 3、执行上传操作
			String filePath = dfsClient.uploadFile(uploadFile.getBytes(), extName);
			String url = AIYOU_IMAGE_BASE_URL + filePath;
			// 4、封装返回数据
			Map<String, Object> success = new HashMap<>();
			// success.put("code", 0);
			// success.put("msg", "图片上传成功");
			// success.put("data", url);
			success.put("error", 0);
			success.put("url", url);
			return JsonUtils.objectToJson(success);
		} catch (Exception e)
		{
			// 打印堆栈异常
			e.printStackTrace();
			Map<String, Object> fail = new HashMap<>();
			// fail.put("code", -1);
			// fail.put("msg", "图片上传失败");
			// fail.put("data", null);
			fail.put("error", 0);
			fail.put("message", "图片上传失败");
			return JsonUtils.objectToJson(fail);
		}
	}
}
