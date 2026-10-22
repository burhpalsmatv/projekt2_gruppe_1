package dk.ek.onskeskyen.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Wishlist {
    private ArrayList<Wish> wishList;
    private String owner;
    private LocalDate date;
    private int wishListId;
    private String coverImg;

    public Wishlist(String owner, LocalDate date, int wishListId, String coverImg) {
        wishList = new ArrayList<>();
        this.owner = owner;
        this.date = date;
        this.wishListId = wishListId;
        this.coverImg = coverImg;
    }

    public Wishlist(int wishListId, String coverImg) {
        wishList = new ArrayList<>();
        this.wishListId = wishListId;
        this.coverImg = coverImg;
    }

    public ArrayList<Wish> getWishList() {
        return wishList;
    }

    public void setWishList(ArrayList<Wish> wishList) {
        this.wishList = wishList;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getWishListId() {
        return wishListId;
    }

    public void setWishListId(int wishListId) {
        this.wishListId = wishListId;
    }


    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "owner='" + owner + '\'' +
                ", date=" + date +
                ", wishListId=" + wishListId +
                ", coverImg='" + coverImg + '\'' +
                '}';
    }
}
