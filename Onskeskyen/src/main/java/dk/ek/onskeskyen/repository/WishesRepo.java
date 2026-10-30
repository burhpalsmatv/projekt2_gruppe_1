package dk.ek.onskeskyen.repository;

import dk.ek.onskeskyen.model.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class WishesRepo {

    @Autowired
    protected DataSource dataSource;


    /**
     * Gets all wishes.
     *
     * @param wishlistId the wishlist id
     * @return the all wishes
     *
     * <p>
     * Executes an SQL query that selects all wishes where the wishlistId is x
     * Each wish record is mapped to a wish object and is added to a list that
     * is uded in the controller.
     */
    public ArrayList<Wish> getAllWishes(int wishlistId) {
        ArrayList<Wish> listOfWishes = new ArrayList<>();
        String sql = "SELECT * FROM wishes WHERE wishlistId = ?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setInt(1, wishlistId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Wish wish = new Wish();

                    wish.setWishId(resultSet.getInt("wishId"));
                    wish.setTitle(resultSet.getString("title"));
                    wish.setPrice(resultSet.getDouble("price"));
                    wish.setNote(resultSet.getString("note"));
                    wish.setLink(resultSet.getString("link"));
                    wish.setWishImg(resultSet.getString("wishImg"));
                    wish.setWishlistId(resultSet.getInt("wishlistId"));
                    wish.setPriority(resultSet.getBoolean("priority"));

                    listOfWishes.add(wish);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listOfWishes;
    }


    public void deleteWish(int wishId) {
        String sql = "DELETE FROM wishes WHERE wishId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, wishId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWish(int wishId, String title, double price, String note, String link, String wishImg, boolean priority) {

        String sql1 = "SELECT title, price, note, link, wishImg, priority FROM wishes WHERE wishId = ? FOR UPDATE";
        String sql2 = "UPDATE wishes SET title = ?, price = ?, note = ?, link = ?, wishImg =?, priority=? WHERE wishId = ?";

        try (Connection con = dataSource.getConnection()) {
            try {
                con.setAutoCommit(false);
                PreparedStatement ps1 = con.prepareStatement(sql1);

                ps1.setInt(1, wishId);
                ResultSet rs = ps1.executeQuery();
                con.commit();

                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setString(1, title);
                ps2.setDouble(2, price);
                ps2.setString(3, note);
                ps2.setString(4, link);
                ps2.setString(5, wishImg);
                ps2.setBoolean(6, priority);
                ps2.setInt(7, wishId);
                if (ps2.executeUpdate() == 0) throw new Exception("Failed. Unknown account " + wishId);

                // Commit and unlock row
                con.commit();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Wish wish) {
        String sql = "INSERT INTO wishes(title, price, note, link, wishImg, priority, wishlistId)" +
                "VALUES(?,?,?,?,?,?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, wish.getTitle());
            statement.setDouble(2, wish.getPrice());
            statement.setString(3, wish.getNote());
            statement.setString(4, wish.getLink());
            statement.setString(5, wish.getWishImg());
            statement.setBoolean(6, wish.getPriority());
            statement.setInt(7, wish.getWishlistId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
