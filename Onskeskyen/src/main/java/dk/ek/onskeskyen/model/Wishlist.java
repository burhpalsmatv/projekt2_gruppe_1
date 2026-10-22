package dk.ek.onskeskyen.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Wishlist {
    private int wishlistId;
    private String wishlistTitle;
    private String coverImg;

    public Wishlist(int wishlistId, String wishlistTitle, String coverImg) {
        this.wishlistId = wishlistId;
        this.wishlistTitle = wishlistTitle;
        this.coverImg = coverImg;
    }

    public Wishlist(){}

    public int getWishlistId() {
        return wishlistId;
    }

    public String getWishlistTitle() {
        return wishlistTitle;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setWishlistId(int wishlistId) {
        this.wishlistId = wishlistId;
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
                ", wishListId=" + wishlistId +
                ", coverImg='" + coverImg + '\'' +
                '}';
    }
}
