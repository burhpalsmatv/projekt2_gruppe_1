package dk.ek.onskeskyen.repository;

import dk.ek.onskeskyen.model.Wish;
import dk.ek.onskeskyen.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class WishRepo {

    @Autowired
    protected DataSource dataSource;


    public ArrayList<Wish> getAllWishes(int wishListId) {
        ArrayList<Wish> listOfWishes = new ArrayList<>();
        String sql = "SELECT * FROM wish WHERE wishlistId = ?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {

            statement.setInt(1, wishListId);

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
        String sql = "DELETE FROM wish WHERE wishId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, wishId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWish(Wish updatedWish) {
        String sql = "UPDATE wish SET title = ?, price = ?, note = ?, link = ?, wishImg =?, priority=?, wishlistId=?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, updatedWish.getTitle());
            statement.setDouble(2, updatedWish.getPrice());
            statement.setString(3, updatedWish.getNote());
            statement.setString(4, updatedWish.getLink());
            statement.setString(5, updatedWish.getWishImg());
            statement.setBoolean(6, updatedWish.getPriority());
            statement.setInt(7, updatedWish.getWishlistId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Wish wish) {
        String sql = "INSERT INTO wish(title, price, note, link, wishImg, priority, wishlistId)" +
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
