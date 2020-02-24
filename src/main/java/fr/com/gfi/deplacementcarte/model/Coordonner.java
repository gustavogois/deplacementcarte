package fr.com.gfi.deplacementcarte.model;

import java.util.Objects;

public class Coordonner {
    private int x;
    private int y;

    public Coordonner(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonner that = (Coordonner) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordonner{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
