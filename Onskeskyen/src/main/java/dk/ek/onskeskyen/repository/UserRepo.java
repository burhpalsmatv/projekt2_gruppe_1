package dk.ek.onskeskyen.repository;

import dk.ek.onskeskyen.model.User;
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
public class UserRepo {

    @Autowired
    protected DataSource dataSource;


    public List<User> getAllUsers() {
        List<User> listOfUsers = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection con = dataSource.getConnection();
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("userId"));
                user.setAge(resultSet.getInt("age"));
                user.setEmail(resultSet.getString("email"));
                user.setProfilePicture(resultSet.getString("profilePicture"));
                user.setPhoneNumber(resultSet.getString("phoneNumber"));
                user.setPassword(resultSet.getString("password"));
                user.setProfilePicture(resultSet.getString("profilePicture"));

                listOfUsers.add(user);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listOfUsers;
    }


    public void deleteUser(int userId) {
        String sql = "DELETE * FROM users WHERE userId = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser (User user){
        String sql = "INSERT INTO users(firstName, lastName, userId, age, email, phoneNum, password, profilePicture )" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getUserId());
            statement.setInt(4, user.getAge());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getPhoneNumber());
            statement.setString(7, user.getProfilePicture());


            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

