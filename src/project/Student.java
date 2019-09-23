package project;

import java.util.Map;

public class Student extends DbObject {
    final static String table = "students";

    String studentID;
    String password;
    String name;
    long phone;
    String email;

    Student(String studentID, String password, String name, long phone, String email) {
        this.studentID = studentID;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    Student(String username, String password) {
        this(username, password, "", -1, "");
    }


    Student(Map<String, Object> student) {
        this(student.get("studentID").toString(), student.get("password").toString(), student.get("name").toString(), Long.parseLong(student.get("phone").toString()), student.get("email").toString());
    }

    @Override
    String getValues() {
        return String.format("values (%s, \'%s\', \'%s\', \'%s\', %s);", studentID, password, name, phone, email);
    }

    @Override
    String getTableName() {
        return table;
    }

    boolean verify(Student student) {
        return this.password.equals(Utils.encrypt(student.password));
    }
}
