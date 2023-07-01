package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviePosterManagerTest {

    String item1 = "Бладшот";
    String item2 = "Вперед";
    String item3 = "Отель Белград";
    String item4 = "Джентельмены";
    String item5 = "Человек-невидимка";
    String item6 = "Тролли. Мировой тур";
    String item7 = "Номер один";

    @Test
    public void PosterTest() {
        MoviePosterManager movie = new MoviePosterManager();
        movie.add(item1);
        movie.add(item2);
        movie.add(item3);
        movie.add(item4);
        movie.add(item5);
        movie.add(item6);
        movie.add(item7);

        String[] expected = { item1, item2, item3, item4, item5, item6, item7 };
        String[] actual = movie.findAllFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void PosterTestEmpty() { //тест добавления "пустого" названия
        MoviePosterManager movie = new MoviePosterManager();
        String[] expected = {};
        String[] actual = movie.findAllFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsTest() { //тест на проверку последних добавленных фильмов с ограничением по умолчанию
        MoviePosterManager movie = new MoviePosterManager();
        movie.add(item1);
        movie.add(item2);
        movie.add(item3);
        movie.add(item4);
        movie.add(item5);
        String[] expected = {item5, item4, item3, item2, item1};
        String[] actual = movie.findLastAddedFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findLastFilmsWithLimit() { //тест на проверку последних добавленных фильмов с заданным ограничением (3)
        MoviePosterManager movie = new MoviePosterManager(3);
        movie.add(item1);
        movie.add(item2);
        movie.add(item3);
        movie.add(item4);
        movie.add(item5);
        String[] expected = {item5, item4, item3};
        String[] actual = movie.findLastAddedFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void MoviePostersMaxTest() { //максимальное кол-в0
        MoviePosterManager movie = new MoviePosterManager();
        movie.add(item1);
        movie.add(item2);
        movie.add(item3);
        movie.add(item4);
        movie.add(item5);
        movie.add(item6);
        movie.add(item7);
        String[] expected = {item1, item2, item3, item4, item5, item6, item7};
        String[] actual = movie.findAllFilms();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void MoviePostersMinTest() { //минимальное кол-во
        MoviePosterManager movie = new MoviePosterManager();
        movie.add(item1);
        movie.add(item2);
        movie.add(item3);
        String[] expected = {item3, item2, item1};
        String[] actual = movie.findLastAddedFilms();
        Assertions.assertArrayEquals(expected, actual);
    }
}