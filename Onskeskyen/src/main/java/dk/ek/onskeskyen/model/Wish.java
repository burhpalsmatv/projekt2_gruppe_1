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

    public Wish() {
    }

    public Wish(String title, double price, String note, String link, String wishImg, int wishlistId, boolean priority) {
        this.title = title;
        this.price = price;
        this.note = note;
        this.link = link;
        this.wishImg = wishImg;
        this.wishlistId = wishlistId;
        this.priority = priority;
    }

    // Getters

    public int getWishlistId(){
        return wishlistId;
    }

    public int getWishId() {
        return wishId;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getWishImg() {
        return this.wishImg;
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

    // Setters
    public void setWishId(int wishId) {
        this.wishId = wishId;
    }

    public void setWishlistId(int wishlistId){
        this.wishlistId = wishlistId;
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

    @Override
    public String toString() {
        return String.format("Ønske title: %s, pris: %.2f, billede: %s, link: %s, note: %s", getTitle(), getPrice(), getWishImg(), getLink(), getNote());
    }
}
