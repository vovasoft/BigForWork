package test.java;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.junit.Test;

/**
 * @author WangYang - vova
 * @version Create in 2:25 PM 2020/6/19
 */



public class TestCanssandra {
    
    
    @Test 
    public void fun(){

        System.out.println(123);
    
    }

    /**
     * 注意版本问题
     */
    @Test 
    public void fun1(){
        Cluster cluster = Cluster.builder().withPort(9042).
                addContactPoint("192.168.0.11").build();
        Session session = cluster.connect("test");
        

        System.out.println(session.isClosed());


    }
}
