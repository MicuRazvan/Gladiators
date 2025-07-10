package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class Database {

        private static Database instance;
        private Connection connection;
        private String url = "jdbc:postgresql://localhost:5432/Gladiatori";
        private String username = "postgres";
        private String password = "g";

        private Database() throws SQLException {
            try {
                Class.forName("org.postgresql.Driver");
                this.connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException ex) {
                System.out.println("Database Connection Creation Failed : " + ex.getMessage());
            }
        }

        public static Database getInstance() throws SQLException {
            if (instance == null) {
                instance = new Database();
            } else if (instance.getConnection().isClosed()) {
                instance = new Database();
            }

            return instance;
        }

        public Connection getConnection() {
            return connection;
        }

        public static void closeConnection() throws SQLException { instance.getConnection().close(); }
    }

