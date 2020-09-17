package Server.DataLayer;

/**
 * Single MyDatabase instance. This is safe to do because all of
 * MyDatabase's methods open and close the connections.
 *
 * @author Georgi Sariev
 *
 */

public final class MyDBSingleton extends MyDatabase {

    private static MyDBSingleton dbInstance;

    private MyDBSingleton() throws ClassNotFoundException {
        super("org.postgresql.Driver",
                "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
    }

    /**
     * Returns singleton instance.
     * @return
     * @throws ClassNotFoundException
     */
    static synchronized MyDBSingleton getDBinstance() throws ClassNotFoundException {
        if (dbInstance == null) {
            dbInstance = new MyDBSingleton();
        }
        return dbInstance;
    }

}