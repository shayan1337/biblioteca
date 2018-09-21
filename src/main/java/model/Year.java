package model;

public class Year {

    private final int value;

    public Year(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
