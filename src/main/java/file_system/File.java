package main.java.file_system;

import java.util.ArrayList;
import java.util.List;

abstract class File {
    private String name;
    private int size;

    File(String name) {
        this.name = name;
    }

    File(String name, int size) { // TextFile
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return this.size;
    }

    public String getPath() {
        String path = this.getName();
        if (this.getParent() != null) {
            path = this.getParent().getPath() + "/" + path;
        }
        return path;
    }

    public abstract File getParent();




}
