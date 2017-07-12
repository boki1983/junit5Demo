package annotation.nested;

import org.junit.platform.commons.util.StringUtils;

public class UserService {
    public boolean login(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new IllegalArgumentException("Username and password must not be null or empty");
        } else if (username.equals("admin") && password.equals("password123")) {
            return true;
        }
        return false;
    }
}
