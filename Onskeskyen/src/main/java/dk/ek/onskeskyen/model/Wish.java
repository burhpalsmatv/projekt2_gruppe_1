package dk.ek.onskeskyen.model;

public class Wish {
    private String title;
    private double price;
    private String img;
    private String link;
    private String note;


    public Wish(String title, double price, String link) {
        this.title = title;
        this.price = price;
        this.link = link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle(){
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public String getLink() {
        return link;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return String.format("Ønske title: %s, pris: %.2f, billede: %s, link: %s, note: %s", getTitle(), getPrice(), getImg(), getLink(), getNote());
    }
}
