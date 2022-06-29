package main.java.file_system;

abstract class File {
    private String name;
    private Directory parent;

    File(String name) {
        this.name = name;
    }

    File(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public abstract int getSize();

    public Directory getParent() {
        return this.parent;
    }

    public void move(Directory moveTo) {
        ((Directory) this.getParent()).getFileList().remove(this);
        moveTo.getFileList().add(this);
        this.parent = moveTo;
    }

    public String getPath() {
        if (this.parent != null) {
            return this.parent.getPath()  + this.parent.getName()+ "/";
        } else{
            return "";
        }
    }
}
