package br.com.jaelsonapolinario.marvelherosandroid.model;

import java.util.ArrayList;
import java.util.Date;

public class Result {

    private int id;
    private String name;
    private String description;
    private Date modified;
    private Thumbnail thumbnail;
    private String resourceURI;
    private Attachment comics;
    private Attachment series;
    private Attachment stories;
    private Attachment events;

    public Result(int id, String name, String description, Date modified) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;

        this.thumbnail = new Thumbnail(description,"");

        ArrayList<Reference> references = new ArrayList<Reference>();
        references.add(new Reference("","AAAA",""));
        references.add(new Reference("","BBB",""));
        references.add(new Reference("","CCC",""));

        this.comics = new Attachment(3,"",references,3);
        this.series = new Attachment(3,"",references,3);
        this.stories = new Attachment(3,"",references,3);
        this.events = new Attachment(3,"",references,3);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Attachment getComics() {
        return comics;
    }

    public void setComics(Attachment comics) {
        this.comics = comics;
    }

    public Attachment getSeries() {
        return series;
    }

    public void setSeries(Attachment series) {
        this.series = series;
    }

    public Attachment getStories() {
        return stories;
    }

    public void setStories(Attachment stories) {
        this.stories = stories;
    }

    public Attachment getEvents() {
        return events;
    }

    public void setEvents(Attachment events) {
        this.events = events;
    }
}
