package model;

import java.util.ArrayList;
import java.util.List;

public class Serie {
    private String name;
    private BroadcastDay broadcastDay;
    private List<String> genres;
    private Status status;
    private int seasons;
    private int chapters;
    private String description;

    public Serie() {
        name = "";
        broadcastDay = BroadcastDay.LUNES;
        genres = new ArrayList<>();
        status = Status.ACTIVA;
        seasons = 0;
        chapters = 0;
        description = "";
    }

    public Serie(String name, List<String> genres, Status status, int seasons, int chapters, String description, BroadcastDay broadcastDay) {
        this.name = name;
        this.genres = genres;
        this.status = status;
        this.seasons = seasons;
        this.chapters = chapters;
        this.description = description;
        this.broadcastDay = broadcastDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BroadcastDay getBroadcastDay() {
        return broadcastDay;
    }

    public void setBroadcastDay(BroadcastDay broadcastDay) {
        this.broadcastDay = broadcastDay;
    }

    public void addGenre(String genre) {
        genres.add(genre);
    }

    public String toStringGenres() {
        String message = "";
        for (int i = 0; i < genres.size(); i++) {
            message += genres.get(i);
        }
        return message;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "name='" + name + '\'' +
                '}';
    }
}