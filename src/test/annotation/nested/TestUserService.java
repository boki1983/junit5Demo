package annotation.nested;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

public class TestUserService {
    private UserService userService = null;

    @BeforeEach
    public void init() {
        userService = new UserService();
    }

    @Nested
    @DisplayName("Test Login Feature")
    class LoginFeature {
        @Test
        void loginUsernamePasswordAreCorrect() {
            boolean actual = userService.login("admin", "password123");
            assertTrue(actual);
        }

        @Test
        void loginUsernamePasswordAreInCorrect() {
            boolean actual = userService.login("admin", "password123456");
            assertFalse(actual);
        }

        @Test
        void loginUsernamePasswordAreNulls() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                userService.login(null, null);
            });
            assertEquals("Username and password must not be null or empty", exception.getMessage());
        }

        @Test
        void loginUsernamePasswordAreEmpty() {
            assertThrows(IllegalArgumentException.class, () -> {
                userService.login("", "");
            });
        }
    }
}
