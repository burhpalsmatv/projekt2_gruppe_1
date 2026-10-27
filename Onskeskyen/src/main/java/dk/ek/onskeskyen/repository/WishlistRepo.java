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
import java.util.List;



@Repository
public class WishlistRepo {

    @Autowired
    protected DataSource dataSource;

    public WishlistRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Wishlist> getAllWishlists() {
        List<Wishlist> listOfWishlist = new ArrayList<>();
        String sql = "SELECT * FROM wishlist";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Wishlist wishlist = new Wishlist();
                wishlist.setWishlistId(resultSet.getInt("wishlistId"));
                wishlist.setUserWishlistId(resultSet.getInt("userWishlistId"));
                wishlist.setWishlistTitle(resultSet.getString("wishlistTitle"));
                wishlist.setCoverImg(resultSet.getString("coverImg"));
                listOfWishlist.add(wishlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOfWishlist;
    }


    public Wishlist getWishlist(int wishlistId) {
        Wishlist wishlist = new Wishlist();
        String sql = "SELECT * FROM wishlist WHERE wishlistId =?";

        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, wishlistId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                wishlist.setWishlistId(resultSet.getInt("wishlistId"));
                wishlist.setUserWishlistId(resultSet.getInt("userWishlistId"));
                wishlist.setWishlistTitle(resultSet.getString("wishlistTitle"));
                wishlist.setCoverImg(resultSet.getString("coverImg"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return wishlist;
    }


    public void deleteWishlist(int wishlistId, int userWishlistId) { // userId
        String sql = "DELETE FROM wishlist WHERE wishlistId = ? AND userWishlistId = ?";
        // Eventuelt find et bedre lag, hvor man tjekker om useren har adgang til denne wishlist
        // -- DET ER FOR AT SØRGE FOR AT USERS IKKE KAN SLETTE WISHLISTS DE IKKE SELV EJER --
        // Lige nu tjekkes det kun i "WHERE wishlistId = ? and userid = ?"
        // "userId = ?"

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, wishlistId);
            statement.setInt(2, userWishlistId);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void save(Wishlist wishlist) {


        String sql = "INSERT INTO wishlist(userWishlistId, wishlistTitle, coverImg)" +
                "VALUES(?,?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, wishlist.getUserWishlistId());
            statement.setString(2, wishlist.getWishlistTitle());
            statement.setString(3, wishlist.getCoverImg());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateWishlist(Wishlist updatedWishlist) {
        String sql = "UPDATE wishlist SET userWishlistId = ?, wishlistTitle = ?, coverImg = ?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, updatedWishlist.getUserWishlistId());
            statement.setString(2, updatedWishlist.getWishlistTitle());
            statement.setString(3, updatedWishlist.getCoverImg());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

