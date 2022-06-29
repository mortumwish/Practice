package main.java.file_system;


import java.util.ArrayList;
import java.util.List;

public class Directory extends File {
    private Directory parent;
    private List<File> files = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public Directory(String name, Directory parent) {
        super(name);
        this.parent = parent;
        parent.getFileList().add(this);
    }

    @Override
    public int getSize() {
        // представим, что папка весит хоть что-то (1 байт)
        int systemSize = 1;
        int size = systemSize;
        for (File element : this.getFileList()) {
            size += element.getSize();
        }
        return size;
    }

    public String getDirectoryContents() {
        StringBuilder content = new StringBuilder();
        for (File element : this.getFileList()) {
            if (element instanceof Directory) {
                content.append(((Directory) element).getDirectoryContents());
            } else {
                content.append(element.getName());
            }
        }
        return this.getName() + "(" + content + ")";
    }

    public File getParent() {
        return this.parent;
    }

    public List<File> getFileList() {
        return this.files;
    }

    public void move(Directory moveTo) {
        ((Directory)this.getParent()).getFileList().remove(this);
        moveTo.getFileList().add(this);
        this.parent = moveTo;
    }
}