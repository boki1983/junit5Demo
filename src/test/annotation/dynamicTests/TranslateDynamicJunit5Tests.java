package annotation.dynamicTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TranslateDynamicJunit5Tests {
    private TranslatorEngine translatorEngine;

    @BeforeEach
    public void setUp() {
        translatorEngine = new TranslatorEngine();
    }

    /**
     * An example for a {@link TestFactory} with JUnit 5.
     * {@link DynamicTest # stream(Iterator, Function, ThrowingConsumer)} provides an easy way to
     * factorize multiple tests, which will be executed automatically.
     * It's basically similar to a for-loop that reads data and asserts, but these test will be
     * grouped and displayed separately in the test results.
     *
     * @return A stream of dynamic tests
     */
    @TestFactory
    public Iterator<DynamicTest> translateDynamicTestsFromIterator() {

        List<String> inPhrases =
                new ArrayList<>(Arrays.asList("Hello", "Yes", "No", "Goodbye", "Good night", "Thank you"));
        List<String> outPhrases =
                new ArrayList<>(Arrays.asList("Bonjour", "Oui", "Non", "Au revoir", "Bonne nuit", "Merci"));

        return inPhrases.stream().map(phrs -> DynamicTest.dynamicTest("Test translate " + phrs, () -> {
            int idx = inPhrases.indexOf(phrs);
            assertEquals(outPhrases.get(idx), translatorEngine.translate(phrs));
        })).iterator();
    }
}
