package main.java.file_system;

import java.time.LocalDate;

abstract class FileSystemObjects {
    private String name;
    private String path;
    private LocalDate date;
    private int size;

    FileSystemObjects(String name) {
        this.name = name;
        this.path = name;
        this.date = LocalDate.now();
    }

    FileSystemObjects(String name, int size) {
        this.name = name;
        this.path = name;
        this.size = size;
        this.date = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return this.size;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public String getPath() {
        return path;
    }

    public void setParentDirectory(FileSystemObjects parentDirectory) {
        this.path = parentDirectory.getPath() + "/" + this.getName();
    }
}
