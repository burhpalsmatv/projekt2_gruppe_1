package dk.ek.onskeskyen.model;

public class Wish {
    private int wishId;
    private String title;
    private double price;
    private String wishImg;
    private String link;
    private String note;
    private boolean priority = false;


    public Wish(String title, double price, String link) {
        this.title = title;
        this.price = price;
        this.link = link;
    }

    public Wish(){}

    public void setWishId(int wishId) {
        this.wishId = wishId;
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

    @Override
    public String toString() {
        return String.format("Ønske title: %s, pris: %.2f, billede: %s, link: %s, note: %s", getTitle(), getPrice(), getWishImg(), getLink(), getNote());
    }
}
