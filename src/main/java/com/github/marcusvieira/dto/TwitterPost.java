package com.github.marcusvieira.dto;

import java.time.LocalDate;
import java.util.Objects;

public class TwitterPost {

    private final String userId;
    private final String thema;
    private final LocalDate date;

    public TwitterPost(String userId, String thema, LocalDate date) {
        this.userId = userId;
        this.thema = thema;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public String getThema() {
        return thema;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "TwitterPost{" +
                "userId='" + userId + '\'' +
                ", thema='" + thema + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwitterPost that = (TwitterPost) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getThema(), that.getThema()) &&
                Objects.equals(getDate(), that.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getThema(), getDate());
    }
}
