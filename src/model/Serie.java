package model;

import java.util.List;

public class Serie {
    private String name;
    private List<String> genres;
    private Status status;
    private int seasons;
    private int id;
    private int chapters;
    private String descrption;
    private BroadcastDay broadcastDay;

    public Serie() {
    }

    public Serie(String name, List<String> genres, Status status, int seasons, int id, int chapters, String descrption, BroadcastDay broadcastDay) {
        this.name = name;
        this.genres = genres;
        this.status = status;
        this.seasons = seasons;
        this.id = id;
        this.chapters = chapters;
        this.descrption = descrption;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public String getDescription() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
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
}