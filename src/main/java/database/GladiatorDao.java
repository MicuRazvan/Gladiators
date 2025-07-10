package database;

import gladiatori.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GladiatorDao {
    public void create(String nume, String clasa, int hp, int sp, int dex, String power,
                       int turneeCastigate, int lupteCasualCastigate, int lupteCasualCastigateLaRand, int expeditii, int expeditiiLaRand,
                       int level, int helmetLevel, int chestLevel, int weaponLevel, int bootsLevel, String immuneTo) throws SQLException {
        Connection con = Database.getInstance().getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO gladiators (nume, clasa, hp, sp, dex, power, turnee_castigate, lupte_casual_castigate," +
                        " lupte_casual_castigate_la_rand, expeditii, expeditii_la_rand," +
                        " level, helmet_level, chest_level, weapon_level, boots_level, immune_to)" +
                        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            pstmt.setString(1, nume);
            pstmt.setString(2, clasa);
            pstmt.setInt(3, hp);
            pstmt.setInt(4, sp);
            pstmt.setInt(5, dex);
            pstmt.setString(6, power);
            pstmt.setInt(7, turneeCastigate);
            pstmt.setInt(8, lupteCasualCastigate);
            pstmt.setInt(9, lupteCasualCastigateLaRand);
            pstmt.setInt(10, expeditii);
            pstmt.setInt(11, expeditiiLaRand);
            pstmt.setInt(12, level);
            pstmt.setInt(13, helmetLevel);
            pstmt.setInt(14, chestLevel);
            pstmt.setInt(15, weaponLevel);
            pstmt.setInt(16, bootsLevel);
            pstmt.setString(17, immuneTo);
            pstmt.executeUpdate();
        }
    }

    public void deleteAll() throws SQLException {
        Connection con = Database.getInstance().getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("DELETE FROM gladiators WHERE ID >= 0")) {
            pstmt.executeUpdate();
        }
    }

    public List<Gladiator> findAll() throws SQLException {
        List<Gladiator> gladiatori = new ArrayList<>();
        Connection con = Database.getInstance().getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select nume, clasa, hp, sp, dex, power, turnee_castigate, lupte_casual_castigate, lupte_casual_castigate_la_rand, expeditii," +
                             "expeditii_la_rand, level, helmet_level, chest_level, weapon_level, boots_level, immune_to from gladiators")) {
            while (rs.next()) {
                if (rs.getString(2).equals("Archer"))
                    gladiatori.add(new Archer(
                            rs.getString(1),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getInt(8),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getInt(11),
                            rs.getInt(12),
                            rs.getInt(13),
                            rs.getInt(14),
                            rs.getInt(15),
                            rs.getInt(16),
                            rs.getString(17)));

                if(rs.getString(2).equals("Brutal"))
                    gladiatori.add(new Brutal(
                            rs.getString(1),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getInt(8),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getInt(11),
                            rs.getInt(12),
                            rs.getInt(13),
                            rs.getInt(14),
                            rs.getInt(15),
                            rs.getInt(16),
                            rs.getString(17)));

                if(rs.getString(2).equals("Assasin"))
                    gladiatori.add(new Assasin(
                            rs.getString(1),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getInt(8),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getInt(11),
                            rs.getInt(12),
                            rs.getInt(13),
                            rs.getInt(14),
                            rs.getInt(15),
                            rs.getInt(16),
                            rs.getString(17)));

                if(rs.getString(2).equals("Fighter"))
                    gladiatori.add(new Fighter(
                            rs.getString(1),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getInt(7),
                            rs.getInt(8),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getInt(11),
                            rs.getInt(12),
                            rs.getInt(13),
                            rs.getInt(14),
                            rs.getInt(15),
                            rs.getInt(16),
                            rs.getString(17)));
            }
            return gladiatori;
        }
    }
}