package dk.ek.onskeskyen.model;

public class Wish {
    private int wishId;
    private String title;
    private double price;
    private String note;
    private String link;
    private String wishImg;
    private boolean priority = false;
    private int wishlistId;


    public Wish(String title, double price, String link) {
        this.title = title;
        this.price = price;
        this.link = link;
    }

    public Wish(int wishId, String title, double price, String note, String link, String wishImg, boolean priority, int wishListId) {
        this.wishId = wishId;
        this.title = title;
        this.price = price;
        this.note = note;
        this.link = link;
        this.wishImg = wishImg;
        this.priority = priority;
        this.wishlistId = wishListId;
    }

    public Wish(){}

    public Wish(String title, double price, String wishImg, String link, String note, boolean priority, int wishListId) {
        this.title = title;
        this.price = price;
        this.wishImg = wishImg;
        this.link = link;
        this.note = note;
        this.wishListId = wishListId;
        this.priority = priority;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
    }

    public void setWishlistId(int wishlistId){
        this.wishlistId = wishlistId;
    }

    public int getWishlistId(){
        return wishlistId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWishImg(String wishImg) {
        this.wishImg = wishImg;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public int getWishId() {
        return wishId;
    }

    public String getTitle(){
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getWishImg() {
        return wishImg;
    }

    public String getLink() {
        return link;
    }

    public String getNote() {
        return note;
    }

    public boolean getPriority() {
        return priority;
    }

    public boolean isPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return String.format("Ønske title: %s, pris: %.2f, billede: %s, link: %s, note: %s", getTitle(), getPrice(), getWishImg(), getLink(), getNote());
    }
}
