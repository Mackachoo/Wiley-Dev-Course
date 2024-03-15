package com.sg.dvdlibrary.dto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class DVD {

    String title;
    String release;
    String rating;
    String director;
    String studio;
    String review;

    public DVD(String title) {
        this.title = title.replace("::", "").strip();
    }

    public static DVD parseDVD(String s) {
        try {
            String[] studentTokens = s.split("::");

            DVD DVDFromFile = new DVD(studentTokens[0]);

            DVDFromFile.setRelease(studentTokens[1]);
            DVDFromFile.setRating(studentTokens[2]);
            DVDFromFile.setDirector(studentTokens[3]);
            DVDFromFile.setStudio(studentTokens[4]);
            DVDFromFile.setReview(studentTokens[5]);

            return DVDFromFile;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Failure to parse DVD...");
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        List<String> strings = Arrays.asList(title, release, rating, director, studio, review);
        Stream<String> stream = strings.stream().map(s -> s == null ? "NaN" : s);
        return String.join("::", stream.toArray(String[]::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVD dvd = (DVD) o;
        return Objects.equals(title, dvd.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public void setRelease(String release) {
        this.release = release.replace("::", "").strip();
    }

    public void setRating(String rating) {
        this.rating = rating.replace("::", "").strip();
    }

    public void setDirector(String director) {
        this.director = director.replace("::", "").strip();
    }

    public void setStudio(String studio) {
        this.studio = studio.replace("::", "").strip();
    }

    public void setReview(String review) {
        this.review = review.replace("::", "").strip();
    }

    public String getTitle() {
        return title;
    }

    public String getRelease() {
        return release;
    }

    public String getRating() {
        return rating;
    }

    public String getDirector() {
        return director;
    }

    public String getStudio() {
        return studio;
    }

    public String getReview() {
        return review;
    }
}
