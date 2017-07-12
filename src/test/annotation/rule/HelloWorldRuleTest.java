package annotation.rule;

import org.junit.Rule;
import org.junit.Test;

public class HelloWorldRuleTest {
    @Rule
    public HelloWorldRule rule = new HelloWorldRule();

    @Test
    public void testHelloWorldRule(){
        System.out.println("Inside testHelloWorldRule");
    }
}
