package db;

public class dbconfig {
    private static final String DB_NAME = "emokua";

    private static final String DB_HOST = "localhost";

    private static final String DB_USERNAME = "emokua";

    private static final String DB_PASSWORD = "1920";

    private static int DB_PORT = 5432;

    static private final String DB_URL = "jdbc:pstgresql://localhost:5432/emokua";
//    private static final String MEMORY_DB =
    private static String getDBurl() { return DB_URL;}

    public static String getDbUsername(){ return DB_USERNAME;}

    public static int getDbPort() {return DB_PORT;}

    public static String getDbPassword() {return DB_PASSWORD;}
}
