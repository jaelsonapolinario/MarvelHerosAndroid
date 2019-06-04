package br.com.jaelsonapolinario.marvelherosandroid.model;

public class Thumbnail {

    private String path;
    private String extension;

    public Thumbnail(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPathFormatted() {
        return this.path + "/portrait_medium.}" + this.extension;
    }

    public String getPathStandardXlarge() {
        return this.path + "/standard_xlarge.}" + this.extension;
    }
}
