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
import java.util.List;

@Repository
public class WishlistRepo {

    @Autowired
    private DataSource dataSource;

    public List<Wishlist> getAllWishlists() {
        List<Wishlist> listOfWishlist = new ArrayList<>();
        String sql = "SELECT * FROM wishlist";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Wishlist wishlist = new Wishlist();
                wishlist.setWishlistId(resultSet.getInt("wishlistId"));
                wishlist.setWishlistTitle(resultSet.getString("wishlistTitle"));
                wishlist.setCoverImg(resultSet.getString("coverImg"));
                listOfWishlist.add(wishlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfWishlist;
    }


    public Wishlist getWishList(int wishlistId) {
        Wishlist wishlist = new Wishlist();
        String sql = "SELECT * FROM wishlist WHERE wishlistId =?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, wishlistId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                wishlist.setWishlistId(resultSet.getInt("wishlistId"));
                wishlist.setWishlistTitle(resultSet.getString("wishlistTitle"));
                wishlist.setCoverImg(resultSet.getString("coverImg"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wishlist;
    }


    public void deleteWishList(int wishlistId, int userId) { // userId
        String sql = "DELETE FROM wishlist WHERE wishlistId = ? AND userId = ?";
        // Eventuelt find et bedre lag, hvor man tjekker om useren har adgang til denne wishlist
        // -- DET ER FOR AT SØRGE FOR AT USERS IKKE KAN SLETTE WISHLISTS DE IKKE SELV EJER --
        // Lige nu tjekkes det kun i "WHERE wishlistId = ? and userid = ?"
        // "userId = ?"

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, wishlistId);
            statement.setInt(2, userId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void save (Wishlist wishlist) {
        String sql = "INSERT INTO wishlist(wishlistTitle, coverImg)" +
                "VALUES(?,?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(2, wishlist.getWishlistTitle());
            statement.setString(3, wishlist.getCoverImg());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

