package br.com.gels.devsuperior.dspesquisa.entities;

import br.com.gels.devsuperior.dspesquisa.entities.enums.Platform;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "TB_GAME")
public class Game implements Serializable {
    private static final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Platform platform;

    @ManyToOne
    @JoinColumn(name = "GENRE_ID")
    private Genre genre;

    @OneToMany(mappedBy = "game")
    private List<Record> records = new ArrayList<>();

    public Game() {
    }

    public Game(Long id, String title, Platform platform, Genre genre) {
        this.id = id;
        this.title = title;
        this.platform = platform;
        this.genre = genre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Record> getRecords() {
        return records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        return id.equals(game.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
