import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao() {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            Config config = new Config();
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ads");
            while (rs.next()) {
                Ad ad = new Ad(rs.getLong("id"), rs.getLong("user_id"), rs.getString("title"), rs.getString("description"));
                ads.add(ad);
            }
            return ads;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) throws SQLException {
        String query = String.format("INSERT INTO ads(user_id, title, description) VALUES(%d, '%s', '%s')",
                ad.getUserId(), ad.getTitle(), ad.getDescription());
//        creating and executing
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        // System.out.println(rs);
        if (rs.next()) {
            System.out.println("Inserted a new Ads! New id: " + rs.getLong(1));
        }
        return ad.getId();
    }
}
