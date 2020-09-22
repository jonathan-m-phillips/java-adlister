import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

    private Connection connection;

    public MySQLAdsDao(Connection connection, Config config) {
        try {
            config = new Config();
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
            this.connection = connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MySQLAdsDao() {

    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ads");
            while (rs.next()) {
                Ad ad = new Ad(rs.getLong("id"), rs.getLong("userId"), rs.getString("title"), rs.getString("description"));
                ads.add(ad);
            }
            return ads;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        return ad.getId();
    }
}
