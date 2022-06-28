package main.java.file_system;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemObjects {
    private List<FileSystemObjects> elements = new ArrayList<>();
    private final int systemSize = 1; // представим, что папка весит хоть что-то (1 байт)

    public Directory(String name) {
        super(name);
    }

    @Override
    public int getSize() {
        int size = this.systemSize;
        for (FileSystemObjects element : this.elements) {
            size += element.getSize();
        }
        return size;
    }

    public void addElement(FileSystemObjects... elements) {
        for (FileSystemObjects element : elements) {
            if (element == this) {
                System.out.println("Error. You can't move the folder into itself");
            } else {

                element.setParentDirectory(this);
                this.elements.add(element);
            }
        }
    }

    @Override
    public void setParentDirectory(FileSystemObjects parentDirectory) {
        super.setParentDirectory(parentDirectory);
        for (FileSystemObjects element : this.elements) {
            element.setParentDirectory(this);
        }
    }
}