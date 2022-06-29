package main.java.file_system;


import java.util.ArrayList;
import java.util.List;

public class Directory extends File {
    private List<File> files = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    public Directory(String name, Directory parent) {
        super(name,parent);
        parent.files.add(this);
    }

    public int getSize() {
        // представим, что папка весит хоть что-то (1 байт)
        int systemSize = 1;
        int size = systemSize;
        for (File element : this.files) {
            if (element instanceof Directory){
                size += ((Directory)element).getSize();
            } else {
                size += element.getSize();
            }
        }
        return size;
    }

    public String getDirectoryContents() {
        StringBuilder content = new StringBuilder();
        for (File element : this.files) {
            if (element instanceof Directory) {
                content.append(((Directory) element).getDirectoryContents());
            } else {
                content.append(element.getName());
            }
        }
        return this.getName() + "(" + content + ")";
    }

    public List<File> getFileList() {
        return this.files;
    }

    public void add(File file){
        file.move(this);
    }

}