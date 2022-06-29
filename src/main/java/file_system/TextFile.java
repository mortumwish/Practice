package main.java.file_system;

public class TextFile extends File {
    private Directory parent;

    TextFile(String name, int size, Directory parent) {
        super(name, size);
        this.parent = parent;
        parent.getFileList().add(this);
    }

    public File getParent() {
        return this.parent;
    }

    public void move(Directory moveTo) {
        ((Directory)this.getParent()).getFileList().remove(this);
        moveTo.getFileList().add(this);
        this.parent = moveTo;
    }
}
