package project;

import java.util.Map;


// This class represents a User
public class User extends DbObject {
    String username;
    String password;

    User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    User(Map<String, Object> user) {
        this(user.get("username").toString(), user.get("password").toString());
    }

    @Override
    String getValues() {
        return String.format("values (%s, \'%s\', \'%s\', \'%s\', %s);", username, password);
    }

    boolean verify(User user) {
        return this.password.equals(Utils.encrypt(user.password));
    }

}