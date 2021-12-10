package com.example.LittlebitDonuttt;

public class Ayam {
    private String title;
    private int harga;
    private String description;
    private int image;

    public Ayam(String title, int harga, int image, String description) {
        this.setTitle(title);
        this.setHarga(harga);
        this.setImage(image);
        this.setDescription(description);
    }

    public String getTitle() {
        return title;
    }

    public int getHarga() {
        return harga;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
