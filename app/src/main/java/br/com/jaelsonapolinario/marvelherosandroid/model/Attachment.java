package br.com.jaelsonapolinario.marvelherosandroid.model;

import java.util.ArrayList;

public class Attachment {
    private int available;
    private String collectionURI;
    private ArrayList<Reference> items;
    private int returned;

    public Attachment(int available, String collectionURI, ArrayList<Reference> items, int returned) {
        this.available = available;
        this.collectionURI = collectionURI;
        this.items = items;
        this.returned = returned;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public ArrayList<Reference> getItems() {
        return items;
    }

    public void setItems(ArrayList<Reference> items) {
        this.items = items;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }
}
