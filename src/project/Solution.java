package project;

import java.util.Map;

public class Solution extends DbObject {
    final static String table = "solutions";

    String studID;
    String subID;
    String assNo;
    String filePath;

    Solution(String studID, String subID, String assNo, String filePath) {
        this.studID = studID;
        this.subID = subID;
        this.assNo = assNo;
        this.filePath = filePath;
    }

    Solution(Map<String, Object> sol) {
        this(sol.get("studID").toString(), sol.get("subID").toString(), sol.get("assNo").toString(), sol.get("filePath").toString());
    }

    @Override
    String getValues() {
        return String.format("values (\'%s\', \'%s\', \'%s\', \'%s\', \'%s\');", studID, subID, assNo, filePath);
    }

    @Override
    String getTableName() {
        return table;
    }
}
