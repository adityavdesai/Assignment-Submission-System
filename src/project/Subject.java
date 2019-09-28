package project;

import java.util.Map;

public class Subject extends DbObject {
    final static String table = "subjects";

    String ID;
    String name;

    Subject(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    Subject(Map<String, Object> subject) {
        this(subject.get("subjectID").toString(), subject.get("name").toString());
    }

    @Override
    String getValues() {
        return String.format("values (\'%s\', \'%s\');", ID, name);
    }

    @Override
    String getTableName() {
        return table;
    }
}
