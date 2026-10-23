package dk.ek.onskeskyen.model;

public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String profilePicture;
    private String phoneNumber;
    private String password;
    private int age;

    public User(int userId, String firstName, String lastName, String email, String profilePicture, String phoneNumber, String password, int age) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profilePicture = profilePicture;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.age = age;
    }

    public User() {
    }

    public String toString() {
        return "first name: " + "last name: " + "email: " + email + " - tlf: " + phoneNumber + " - id: " + userId;
    }

    //GETTERS + SETTERS BELOW


    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
