package Ads;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;


public class MySQLAdsDao implements Ads {

    private Connection connection = null;


    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl();
                    config.getUser();
                    config.getPassword();
            );
        } catch (SQLException e) {
            throw new RuntimeException("error connecting to database");
        }

    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *");
            while (rs.next())
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("userid"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        catch (SQLException e) {
            throw new RuntimeException(e);
    }
}
