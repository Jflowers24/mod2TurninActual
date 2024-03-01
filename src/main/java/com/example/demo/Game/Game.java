package com.example.demo.Game;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

import static com.sun.tools.javac.resources.CompilerProperties.Fragments.Local;


@Entity
@Table
public class Game {
    @Id
    @SequenceGenerator(
            name = "game_sequence",
            sequenceName =  "game_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "game_sequence"
    )
    private Long SerialNum;
    private String Title;
    private LocalDate releaseDate;

    @Transient
    private Integer age;
    private String Genre;

    public Game() {
    }

    public Game(Long serialNum,
                String title,
                LocalDate releaseDate,
                String genre) {
        SerialNum = serialNum;
        Title = title;
        this.releaseDate = releaseDate;
        Genre = genre;
    }

    public Game(String title,
                LocalDate releaseDate,
                String genre) {
        Title = title;
        this.releaseDate = releaseDate;
        Genre = genre;
    }

    public Long getSerialNum() {
        return SerialNum;
    }

    public void setSerialNum(Long serialNum) {
        SerialNum = serialNum;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getAge() {
        return Period.between(this.releaseDate, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    @Override
    public String toString() {
        return "Game{" +
                "SerialNum=" + SerialNum +
                ", Title='" + Title + '\'' +
                ", releaseDate=" + releaseDate +
                ", age=" + age +
                ", Genre='" + Genre + '\'' +
                '}';
    }
}
