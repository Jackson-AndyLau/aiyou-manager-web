package com.huazai.aiyou.manager.web.util;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description FastDFS Java 客户端工具类
 *              </ul>
 * @className FastDFSClient
 * @package com.huazai.b2c.aiyou.web.util
 * @createdTime 2017年06月11日
 *
 * @version V1.0.0
 */
public class FastDFSClient
{

	private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	private StorageServer storageServer = null;
	private StorageClient1 storageClient = null;

	public FastDFSClient(String conf) throws Exception
	{
		// 1、加载配置文件
		if (conf.contains("classpath:"))
		{
			conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
		}
		// 2、初始化配置
		ClientGlobal.init(conf);
		// 3、创建trackerClient对象
		trackerClient = new TrackerClient();
		// 4、创建连接并获得trackerServer对象
		trackerServer = trackerClient.getConnection();
		// 5、创建一个storageServer的引用
		storageServer = null;
		// 6、创建一个storageClient对象
		storageClient = new StorageClient1(trackerServer, storageServer);
	}

	/**
	 * 上传文件方法
	 * <p>
	 * Title: uploadFile
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param fileName 文件全路径
	 * @param extName  文件扩展名，不包含（.）
	 * @param metas    文件扩展信息
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception
	{
		String result = storageClient.upload_file1(fileName, extName, metas);
		return result;
	}

	public String uploadFile(String fileName) throws Exception
	{
		return uploadFile(fileName, null, null);
	}

	public String uploadFile(String fileName, String extName) throws Exception
	{
		return uploadFile(fileName, extName, null);
	}

	/**
	 * 上传文件方法
	 * <p>
	 * Title: uploadFile
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param fileContent 文件的内容，字节数组
	 * @param extName     文件扩展名
	 * @param metas       文件扩展信息
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception
	{

		String result = storageClient.upload_file1(fileContent, extName, metas);
		return result;
	}

	public String uploadFile(byte[] fileContent) throws Exception
	{
		return uploadFile(fileContent, null, null);
	}

	public String uploadFile(byte[] fileContent, String extName) throws Exception
	{
		return uploadFile(fileContent, extName, null);
	}
}
