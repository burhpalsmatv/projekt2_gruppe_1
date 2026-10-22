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

    public List<Wish> getAllWishes() {
        List<Wish> listOfWishes = new ArrayList<>();
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
                wish.setPriority(resultSet.get);
                accountList.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accountList;
    }
    }
}
