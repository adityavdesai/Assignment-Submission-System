package project;

import java.util.Map;

public class Student extends DbObject {
    final static String table = "students";

    String studentID;
    String password;
    String name;
    String sclass;

    Student(String studentID, String password, String name, String sclass) {
        this.studentID = studentID;
        this.password = password;
        this.name = name;
        this.sclass = sclass;
    }

    Student(String username, String password) {
        this(username, password, "", "");
    }


    Student(Map<String, Object> student) {
        this(student.get("studentID").toString(), student.get("password").toString(), student.get("stName").toString(), student.get("sClass").toString());
    }

    @Override
    String getValues() {
        return String.format("values (\'%s\', \'%s\', \'%s\', \'%s\');", studentID, password, name, sclass);
    }

    @Override
    String getTableName() {
        return table;
    }

    boolean verify(Student student) {
        return this.password.equals(Utils.encrypt(student.password));
    }
}
