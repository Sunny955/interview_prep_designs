package org.lld.prep.design_patterns.singleton;


class DatabaseInstance {
    private static DatabaseInstance instance;
    private DatabaseInstance() {}
    public static DatabaseInstance getInstance() {
        if(instance == null) {
            instance = new DatabaseInstance();
        }
        return instance;
    }
    public void query(String sql) {
        System.out.println("SQL QUERY: "+sql);
    }
}

public class Database {
    public static void main(String[] args) {
        DatabaseInstance instance = DatabaseInstance.getInstance();

        instance.query("SELECT * FROM USERS");
    }
}


