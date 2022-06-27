package main.java.file_system;

import java.time.LocalDate;

public abstract class FileSystem {
    private String name;
    private String path;
    private LocalDate date;
    private int size;

    public FileSystem(String name) {
        this.name = name;
        this.path = getName();
        this.date = LocalDate.now();
    }

    public FileSystem(String name, int size) {
        this.name = name;
        this.date = LocalDate.now();
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getSize(){
        return size;
    }

    public void setParentDirectory(String parentDirectory) {
        path = parentDirectory + "/" + getName();
    }

}
