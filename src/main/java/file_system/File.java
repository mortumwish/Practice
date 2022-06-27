package main.java.file_system;

import java.time.LocalDate;

public class File {
    private String name;
    private String path;
    private int size;
    private LocalDate date;

    File(String name, int size) {
        this.name = name;
        this.size = size;
        this.date = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPath() {
        return path;
    }

    public void setParentDirectory(String parentDirectory) {
        path = parentDirectory + "/" + getName();
    }
}
