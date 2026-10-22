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
import java.util.List;

@Repository
public class WishRepo {

    @Autowired
    protected DataSource dataSource;

    public ArrayList<Wish> getAllWishes() {
        ArrayList<Wish> listOfWishes = new ArrayList<>();
        String sql = "SELECT * FROM wish";

        try (Connection con = dataSource.getConnection();
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Wish wish = new Wish();
                wish.setWishId(resultSet.getInt("wishId"));
                wish.setTitle(resultSet.getString("title"));
                wish.setPrice(resultSet.getDouble("price"));
                wish.setNote(resultSet.getString("note"));
                wish.setLink(resultSet.getString("link"));
                wish.setWishImg(resultSet.getString("wishImg"));
                wish.setWishListId(resultSet.getInt("wishListId"));
                if (resultSet.getInt("priority") == 1) {
                    wish.setPriority(true);
                } else {
                    wish.setPriority(false);
                }
                listOfWishes.add(wish);
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
}
