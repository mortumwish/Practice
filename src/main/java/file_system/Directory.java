package main.java.file_system;


public class Directory extends File {
    private Directory parent;

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

    public void move(Directory moveTo) {
        super.move(moveTo);
        this.parent = moveTo;
    }

    public File getParent() {
        return this.parent;
    }

}