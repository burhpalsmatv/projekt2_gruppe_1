package dk.ek.onskeskyen.model;


public class Wishlist {
    private int wishlistId;
    private int userWishlistId;
    private String wishlistTitle;
    private String coverImg;

    public Wishlist(String wishlistTitle) {
        this.wishlistTitle = wishlistTitle;
        this.coverImg = "defaultcoverimg";
    }

    public Wishlist(int wishlistId, int userWishlistId, String wishlistTitle, String coverImg) {
        this.wishlistId = wishlistId;
        this.userWishlistId = userWishlistId;
        this.wishlistTitle = wishlistTitle;
        this.coverImg = coverImg;
    }

    public Wishlist(String wishlistTitle, String coverImg) {
        this.wishlistTitle = wishlistTitle;
        this.coverImg = coverImg;
    }

    public Wishlist(int wishlistId, String wishlistTitle, String coverImg) {
        this.wishlistId = wishlistId;
        this.wishlistTitle = wishlistTitle;
        this.coverImg = coverImg;
    }

    public Wishlist() {}

    public Wishlist(int userWishlistId, String wishlistTitle) {
        this.userWishlistId = userWishlistId;
        this.wishlistTitle = wishlistTitle;
    }

    public int getUserWishlistId() {
        return userWishlistId;
    }

    // Getters
    public int getWishlistId() {
        return wishlistId;
    }

    public String getWishlistTitle() {
        return wishlistTitle;
    }

    public String getCoverImg() {
        return coverImg;
    }

    // Setters
    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public void setUserWishlistId(int userWishlistId) {
        this.userWishlistId = userWishlistId;
    }

    public void setWishlistTitle(String wishlistTitle) {
        this.wishlistTitle = wishlistTitle;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                ", wishlistId=" + wishlistId +
                ", coverImg='" + coverImg + '\'' +
                '}';
    }
}
