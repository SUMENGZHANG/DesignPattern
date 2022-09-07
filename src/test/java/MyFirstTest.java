import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

@DisplayName("我的第一个测试")
public class MyFirstTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        System.out.println("set up ready");
    }



    @Override
    protected void tearDown() throws Exception {
        System.out.println("over");
    }

    @Test
    public void test(){
        System.out.println("result:");
        Assertions.assertTrue(1==1);


    }



}
