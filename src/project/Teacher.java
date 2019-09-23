package project;

import java.util.Map;

public class Teacher extends DbObject {
    final static String table = "teachers";

    String teacherID;
    String password;
    String name;
    long phone;
    String email;

    Teacher(String teacherID, String password, String name, long phone, String email) {
        this.teacherID = teacherID;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    Teacher(String username, String password) {
        this(username, password, "", -1, "");
    }


    Teacher(Map<String, Object> teacher) {
        this(teacher.get("teacherID").toString(), teacher.get("password").toString(), teacher.get("name").toString(), Long.parseLong(teacher.get("phone").toString()), teacher.get("email").toString());
    }

    @Override
    String getValues() {
        return String.format("values (%s, \'%s\', \'%s\', \'%s\', %s);", teacherID, password, name, phone, email);
    }

    @Override
    String getTableName() {
        return table;
    }

    boolean verify(Teacher teacher) {
        return this.password.equals(Utils.encrypt(teacher.password));
    }
}
