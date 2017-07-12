package annotation.rule;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;

@RunWith(JUnitPlatform.class)
public class HelloWorldRule implements TestRule {
    @Override
    public Statement apply(Statement stmt, Description desc) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                System.out.println("Before executing method "+ desc.getMethodName());
                stmt.evaluate();
                System.out.println("After executing method "+ desc.getMethodName());
            }
        };
    }
}
