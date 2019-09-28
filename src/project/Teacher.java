package project;

import java.util.Map;

public class Teacher extends DbObject {
    final static String table = "teachers";

    String teacherID;
    String name;
    String password;
    String tClass;
    String subID;

    Teacher(String teacherID, String name, String password, String tClass, String subID) {
        this.teacherID = teacherID;
        this.name = name;
        this.password = password;
        this.tClass = tClass;
        this.subID = subID;
    }

    Teacher(String username, String password) {
        this(username, "", password, "", "");
    }


    Teacher(Map<String, Object> teacher) {
        this(teacher.get("teacherID").toString(), teacher.get("tName").toString(), teacher.get("password").toString(), teacher.get("tClass").toString(), teacher.get("subID").toString());
    }

    @Override
    String getValues() {
        return String.format("values (\'%s\', \'%s\', \'%s\', \'%s\', \'%s\');", teacherID, name, password, tClass, subID);
    }

    @Override
    String getTableName() {
        return table;
    }

    boolean verify(Teacher teacher) {
        return this.password.equals(Utils.encrypt(teacher.password));
    }
}
