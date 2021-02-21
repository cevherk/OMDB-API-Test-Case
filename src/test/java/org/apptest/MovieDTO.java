package org.apptest;

public class MovieDTO {
    private String Title;
    private String Year;
    private String imdbID;
    private String Type;
    private String Poster;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        this.Year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        this.Poster = poster;
    }

    @Override
    public String toString() {
        return    "title: "+ Title
                +"\nyear: "+ Year
                +"\nimdbID: "+ imdbID
                +"\ntype: "+ Type
                +"\nposter: "+ Poster;
    }
}