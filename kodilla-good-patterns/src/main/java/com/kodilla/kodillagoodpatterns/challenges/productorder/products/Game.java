package com.kodilla.kodillagoodpatterns.challenges.productorder.products;

import java.util.Objects;

public class Game implements Product {
    private final String productId;
    private final String name;
    private final String genre;
    private final String medium;
    private double price;

    public Game(String productId, String name, String genre, String medium, double price) {
        this.productId = productId;
        this.name = name;
        this.genre = genre;
        this.medium = medium;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getMedium() {
        return medium;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (Double.compare(game.price, price) != 0) return false;
        if (!Objects.equals(productId, game.productId)) return false;
        if (!Objects.equals(name, game.name)) return false;
        if (!Objects.equals(genre, game.genre)) return false;
        return Objects.equals(medium, game.medium);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (medium != null ? medium.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", medium='" + medium + '\'' +
                '}';
    }
}
