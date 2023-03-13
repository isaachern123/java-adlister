import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

import javax.servlet.jsp.jstl.core.Config;

public class MySQLAdsDao implements Ads {

    private Connection connection = null;


    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver));
            connection = DriverManager.getConnection();
        }

    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT *");
            while (rs.next())
                ads.add(new Ad());
            }
        catch (SQLException e) {
            throw new RuntimeException(e);
    }
}
