package assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AssertionsDemo {
    @Test
    void groupedAssertions() {
        // Test case with the age is a numeric string
        String age = "100";
        Double expAge = Double.valueOf(age);
        Double actual = Double.parseDouble(age);

        assertAll("Do many assertions.", () -> {
            assertNotNull(null);
            assertEquals(expAge, actual);
        });
    }

    @Test
    void exceptionTesting() {
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
    }
}
