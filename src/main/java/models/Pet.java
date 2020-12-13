package models;

import java.util.ArrayList;

public class Pet {
    public Object getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public ArrayList<String> getPhotoUrls() {
        return photoUrls;
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Object id;
    private String name;
    private Category category;
    private ArrayList <String> photoUrls;
    private ArrayList <Tags> tags;
    private String status;



}
