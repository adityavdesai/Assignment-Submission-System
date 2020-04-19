package project;

import java.util.Map;

public class Assignment extends DbObject{
    final static String table = "assignments";

    String tchID;
    String subID;
    String assNo;
    String title;
    String assDesc;
    String lastdate;

    Assignment(String tchID, String subID, String assNo, String title, String assDesc, String lastdate) {
        this.tchID = tchID;
        this.subID = subID;
        this.assNo = assNo;
        this.title = title;
        this.assDesc = assDesc;
        this.lastdate = lastdate;
    }

    Assignment(Map<String, Object> ass) {
        this(ass.get("tchID").toString(), ass.get("subID").toString(), ass.get("assNo").toString(), ass.get("title").toString(), ass.get("descrip").toString(), ass.get("lastdate").toString());
    }

    @Override
    String getValues() {
        return String.format("values (\'%s\', \'%s\', \'%s\', \'%s\', \'%s\', \'%s\');", tchID, subID, assNo, title, assDesc, lastdate);
    }

    @Override
    String getTableName() {
        return table;
    }
}
