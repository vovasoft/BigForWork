import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author WangYang - vova
 * @version Create in 2:36 PM 2020/6/23
 */


public class DemoHdfs {
    /**
 * 1. FileSystem: 文件系统的抽象基类
 * 			FileSystem的实现取决于fs.defaultFS的配置！
 * 				
 * 		有两种实现！
 *     LocalFileSystem： 本地文件系统   fs.defaultFS=file:///
 *     DistributedFileSystem： 分布式文件系统  fs.defaultFS=hdfs://xxx:9000
 *     
 *     声明用户身份：
 *     	 FileSystem fs = FileSystem.get(new URI("hdfs://hadoop101:9000"), conf, "atguigu");
 *     
 *  2. Configuration : 功能是读取配置文件中的参数
 *  		
		Configuration在读取配置文件的参数时，根据文件名，从类路径按照顺序读取配置文件！
				先读取 xxx-default.xml，再读取xxx-site.xml
				
		Configuration类一加载，就会默认读取8个配置文件！
		将8个配置文件中所有属性，读取到一个Map集合中！
		
		也提供了set(name,value)，来手动设置用户自定义的参数！
		
	3. FileStatus
			代表一个文件的状态(文件的属性信息)
			
	4. offset和length
			offset是偏移量： 指块在文件中的起始位置
			length是长度，指块大小
			
			sts.zip 390M
								length    offset
			blk1:   0-128M      128M		0
			blk2:    128M-256M  128M        128M
			...
			blk4:    384M-390M  6M          384M
			
	5. LocatedFileStatus
			LocatedFileStatus是FileStatus的子类，除了文件的属性，还有块的位置信息！
 * 			
 */

    private FileSystem fs;

    private Configuration conf = new Configuration();

    @Before
    public void init() throws IOException, URISyntaxException {
        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        //创建一个客户端对象
        fs=FileSystem.get(new URI("hdfs://h11:9000"),conf);

    }

    @After
    public void close() throws IOException {

        if (fs !=null) {
            fs.close();
        }

    }
    
    
    @Test 
    public void fun() throws URISyntaxException, IOException, InterruptedException {

        
        System.out.println(fs.getCanonicalServiceName());        
        
        fs.mkdirs(new Path("/vova_j"));
    }
    
    
}
