package com.huazai.b2c.aiyou.fdfs;

import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

/**
 * 
 * @author HuaZai
 * @contact who.seek.me@java98k.vip
 *          <ul>
 * @description 测试FastDFS Java 客户端
 *              </ul>
 * @className TFastDFS
 * @package com.huazai.b2c.aiyou.fdfs
 * @createdTime 2017年06月11日
 *
 * @version V1.0.0
 */
public class TFastDFS
{

	@Test
	public void TFileUpload() throws IOException, MyException
	{
		// 1、加载配置文件 /aiyou-manager-web/src/main/resources/resources/fdfs_client.conf
		ClientGlobal.init("src/main/resources/resources/fdfs_client.conf");
		// 2、创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		// 3、通过TrackerClient创建与TrackerServer的连接
		TrackerServer trackerServer = trackerClient.getConnection();
		// 4、创建一个StorageServer
		StorageServer storageServer = null;
		// 5、创建一个StorageClient对象
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 6、上传图片，注意后缀名不需要 . 符号
		String[] file = storageClient.upload_file("D:\\timg2.jpg", "jpg", null);
		// 7、打印文件路径
		for (String string : file)
		{
			System.out.println(string);
		}

	}
}
