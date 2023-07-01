package ru.netology.repository;

public class MoviePosterManager {
    private String[] items = new String[0];
    private final int limit;

    public MoviePosterManager() {
        this.limit = 5;
    }

    public MoviePosterManager(int limit) {
        this.limit = limit;
    }


    public void add(String item) {
        String[] tmp = new String[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public String[] findAllFilms() {
        return items;
    }

    public String[] findLastAddedFilms() {
        int arraysLength;
        if (items.length <= limit) {
            arraysLength = items.length;
        } else {
            arraysLength = limit;
        }
        String[] tmp = new String[arraysLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = items[items.length - 1 - i];
        }
        return tmp;
    }
}
