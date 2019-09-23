package project;

import java.util.Map;

public class Subject extends DbObject {
    final static String table = "subjects";

    String ID;
    String name;
    String coordinator;

    Subject(String ID, String name, String coordinator) {
        this.ID = ID;
        this.name = name;
        this.coordinator = coordinator;
    }

    Subject(Map<String, Object> subject) {
        this(subject.get("ID").toString(), subject.get("name").toString(), subject.get("coordinator").toString());
    }

    @Override
    String getValues() {
        return String.format("values (%s, \'%s\', %s);", ID, name, name);
    }

    @Override
    String getTableName() {
        return table;
    }
}
