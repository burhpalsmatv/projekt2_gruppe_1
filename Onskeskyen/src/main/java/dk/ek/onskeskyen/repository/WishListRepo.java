package dk.ek.onskeskyen.repository;

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
public class WishListRepo {

    @Autowired
    private DataSource dataSource;

    public ArrayList<Wishlist> getAllWishLists() {
        ArrayList<Wishlist> lists = new ArrayList<>();
        String sql = "SELECT * FROM wishlist";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int wishListId = resultSet.getInt("wishListId");
                String coverImg = resultSet.getString("coverImg");
                lists.add(new Wishlist(wishListId, coverImg));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lists;
    }


    public Wishlist getWishList(int wishListId) {
        Wishlist wishlist = null;
        String sql = "SELECT * FROM wishlist WHERE wishListId =?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, wishListId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int wishListID = resultSet.getInt("wishListId");
                String coverImg = resultSet.getString("coverImg");
                wishlist = new Wishlist(wishListId, coverImg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wishlist;
    }


    public void delete(int wishListId) {
        String sql = "DELETE FROM wishlist WHERE wishListId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, wishListId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void save (Wishlist wishlist){
        String sql = "INSERT INTO wishlist(wishListId, wishId, amountOfWishes, coverImg)" +
                "VALUES(?,?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, wishlist.getWishListId());
            statement.setString(4, wishlist.getCoverImg());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

