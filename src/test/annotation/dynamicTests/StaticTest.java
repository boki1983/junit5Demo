package annotation.dynamicTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StaticTest {
    private TranslatorEngine translatorEngine;

    @BeforeEach
    public void setUp() {
        translatorEngine = new TranslatorEngine();
    }

    @Test
    public void testTranslateHello() {
        assertEquals("Bonjour", translatorEngine.translate("Hello"));
    }

    @Test
    public void testTranlsateYes() {
        assertEquals("Oui", translatorEngine.translate("Yes"));
    }

    @Test
    public void testTranlsateNo() {
        assertEquals("Non", translatorEngine.translate("No"));
    }

    @Test
    public void testTranlsateGoodbye() {
        assertEquals("Au revoir", translatorEngine.translate("Goodbye"));
    }

    @Test
    public void testTranlsateGoodnight() {
        assertEquals("Bonne nuit", translatorEngine.translate("Good night"));
    }

    @Test
    public void testTranlsateThankyou() {
        assertEquals("Merci", translatorEngine.translate("Thank you"));
    }
}
