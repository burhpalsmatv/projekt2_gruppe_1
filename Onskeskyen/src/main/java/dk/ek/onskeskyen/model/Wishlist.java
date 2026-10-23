package dk.ek.onskeskyen.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Wishlist {
    private int wishlistId;
    private String wishlistTitle;
    private String coverImg;
    private LocalDate date;

    public Wishlist(String wishlistTitle) {
        this.wishlistTitle = wishlistTitle;
        this.coverImg = "defaultcoverimg";
    }

    // Muligvis slet senere
    public Wishlist(String wishlistTitle, String coverImg) {
        this.wishlistTitle = wishlistTitle;
        this.coverImg = coverImg;
    }

    // Muligvis slet senere
    public Wishlist(int wishlistId, String wishlistTitle, String coverImg) {
        this.wishlistId = wishlistId;
        this.wishlistTitle = wishlistTitle;
        this.coverImg = coverImg;
    }

    // Tom Constructor
    public Wishlist() {}

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

    public LocalDate getDate() {
        return this.date;
    }

    // Setters
    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
    }

    public void setWishlistTitle(String wishlistTitle) {
        this.wishlistTitle = wishlistTitle;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                ", wishListId=" + wishlistId +
                ", coverImg='" + coverImg + '\'' +
                '}';
    }
}
