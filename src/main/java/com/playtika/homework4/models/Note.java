package com.playtika.homework4.models;

public class Note {

    private int id;
    private String content;
    private String createdAt;
    private String modifiedAt;
    private int version;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", modifiedAt='" + modifiedAt + '\'' +
                ", version=" + version +
                '}';
    }
}