
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


public class TestTemplate extends TestCase {

    @Override
    protected void setUp() throws Exception {
        System.out.println("set up ready");
    }

    @Override
    protected void runTest() throws Throwable {
        System.out.println("running...");
        test();
    }

    @Override
    protected void tearDown() throws Exception {
        System.out.println("over");

    }

    @Test
    public void test(){
        System.out.println("result:");
        Assert.assertNull("");

    }

}
