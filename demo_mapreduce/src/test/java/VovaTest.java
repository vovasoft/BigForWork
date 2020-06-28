import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * @author WangYang - vova
 * @version Create in 10:04 AM 2020/6/28
 */


public class VovaTest {
    
    
    @Test 
    public void fun1(){
        
        
        String value = "3\t13956435636\t192.196.100.3\t\t\t132\t1512\t200";
        
        String[] words = value.toString().split("\t");
        
        for (String word : words) {
            System.out.println(word);
        }


    }
}
