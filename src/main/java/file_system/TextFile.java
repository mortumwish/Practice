package main.java.file_system;

public class TextFile extends File {
    private int size;

    TextFile(String name, int size, Directory parent) {
        super(name, parent);
        this.size = size;
        parent.getFileList().add(this);
    }

    public int getSize(){
        return this.size;
    }

}
