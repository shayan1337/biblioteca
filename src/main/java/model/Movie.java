package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Movie implements Item {

    private final Title title;
    private final Person director;
    private final Year yearOfRelease;
    private final Rating rating;
    private final ItemType itemType;

    public Movie(Title title, Person director, Year yearOfRelease, Rating rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.itemType = ItemType.Movie;
    }

    @Override
    public boolean hasTitle(String title) {
        return this.title.toString().equalsIgnoreCase(title);
    }

    public Collection<String> getDetails() {
        Collection<String> details = new ArrayList<>();
        Collections.addAll(details, toString().split("\t"));
        return details;
    }

    public ItemType getItemType() {
        return itemType;
    }

    @Override
    public String toString() {
        return title.toString() + "\t" + director.toString() + "\t" + yearOfRelease.toString() + "\t" + rating.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(title, movie.title) &&
                Objects.equals(director, movie.director) &&
                Objects.equals(yearOfRelease, movie.yearOfRelease) &&
                Objects.equals(rating, movie.rating) &&
                itemType == movie.itemType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, director, yearOfRelease, rating, itemType);
    }
}
