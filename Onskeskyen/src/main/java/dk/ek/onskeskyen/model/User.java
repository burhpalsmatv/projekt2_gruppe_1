package dk.ek.onskeskyen.model;

public class User {

    private String email;
    private String profilePicture;
    private String phoneNumber;
    private int age;

    public User(String email, String phoneNumber, int age) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String toString() {
        return "email: " + email + " - tlf: " + phoneNumber;
    }

    //GETTERS + SETTERS BELOW

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
