package dk.ek.onskeskyen.model;

public class User {

    private String firstName;
    private String lastName;
    private int userId;
    private String email;
    private String profilePicture;
    private String phoneNumber;
    private int age;

    public User(String firstName, String lastName, int userId, String email, String phoneNumber, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public User() {
    }

    public String toString() {
        return "first name: " + "last name: " + "email: " + email + " - tlf: " + phoneNumber + " - id: " + userId;
    }

    //GETTERS + SETTERS BELOW


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




}
