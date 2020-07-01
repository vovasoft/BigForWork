package com.vova;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author WangYang - vova
 * @version Create in 5:33 PM 2020/7/1
 */


public class DemoHbase {

    public static Configuration conf;
    public static HBaseAdmin admin;
    public static Connection connection;
    static{
        //使用HBaseConfiguration的单例方法实例化
        conf = HBaseConfiguration.create();
        conf.set("HBase.zookeeper.quorum", "h11");
        conf.set("HBase.zookeeper.property.clientPort", "2181");
    }
    
    public static void main(String[] args) throws IOException {

        System.out.println("VOVA=="+isTableExist("apiTestTable"));
        
        /**创建表*/
        createTable("apiTestTable",new ArrayList<String>(){
            {
                add("f1");
                add("f2");
                add("f3");
            }
        });

        insertData("apiTestTable","row1", "f1", "name", "vova");
        
        /**删除表*/
//        delTable("apiTestTable");
        
        


        System.out.println("Done !!!");
    }


    /**判断表是否存在*/
    public static boolean isTableExist(String tableName) throws IOException {
        //在HBase中管理、访问表需要先创建HBaseAdmin对象
        admin = createAdmin();
        return admin.tableExists(tableName);

    }

    /**
     * 创建表
     */
    public static void createTable(String tableName, ArrayList<String> columnFamily) throws IOException {
        admin = createAdmin();

        if (isTableExist(tableName)) {
            System.out.println("表" + tableName + "已存在");
        }

        //创建表属性对象,表名需要转字节
        HTableDescriptor descriptor = new HTableDescriptor(TableName.valueOf(tableName));
        //创建多个列族
        for(String cf : columnFamily){
            descriptor.addFamily(new HColumnDescriptor(cf));
        }

        admin.createTable(descriptor);
        
    }

    /**删除表*/
    public static void delTable(String tableName) throws IOException {
        admin = createAdmin();

        if (!isTableExist(tableName)) {
            System.out.println("表" + tableName + "不存在");
        }
        admin.disableTable(tableName);
        admin.deleteTable(tableName);

        System.out.println("删除后查询表是否存在"+"表："+tableName+"，isExist = "+isTableExist(tableName));
        
    }
    
    /**向表中插入数据*/
    public static void insertData(String tableName,String rowKey,String family,String key,String value) throws IOException {
        admin = createAdmin();

        if (!isTableExist(tableName)) {
            System.out.println("表" + tableName + "不存在");
        }
        //创建Table对象
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(rowKey.getBytes());


        put.addColumn(family.getBytes(), key.getBytes(), value.getBytes());

        table.put(put);
        table.close();

        System.out.println("插入数据成功");
        

    }
    
    
    
    
    /**公共方法，创建admin*/
    private static HBaseAdmin createAdmin() {
        admin = null;
        try {
            connection = ConnectionFactory.createConnection(conf);
            admin = (HBaseAdmin) connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
