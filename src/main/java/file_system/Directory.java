package main.java.file_system;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystem{
    private List<Directory> directoryList;
    private List<File> fileList;
    private final int size = 1; // представим, что папка весит хоть что-то (1 байт) :)

    public Directory(String name) {
        super(name);
        this.directoryList = new ArrayList<>();
        this.fileList = new ArrayList<>();
    }

    @Override
    public int getSize() {
        int size = this.size;
        for (Directory directory : directoryList) {
            size += directory.getSize();
        }
        for (File file : fileList) {
            size += file.getSize();
        }
        return size;
    }

    public Directory getDirectory(int index) {
        return directoryList.get(index);
    }

    public File getFile(int index) {
        return fileList.get(index);
    }

    public StringBuilder getDirectoryContents() {
        StringBuilder content = new StringBuilder("Contents of directory " + getName() + ":\n");
        for (Directory directory : directoryList) {
            content.append(" - " + directory.getName() + "/ Creation date: " + directory.getDate() + "\n");

        }
        for (File file : fileList) {
            content.append(" - " + file.getName() + " Creation date: " + file.getDate() + " Size: " + file.getSize() + " bytes \n");
        }
        return content;
    }

    public void add(Directory... directories) {
        for (Directory directory : directories) {
            if (directory == this) {
                System.out.println("Error. You can't move the folder into itself");
            } else {
                directory.setParentDirectory(getPath());
                directoryList.add(directory);
            }
        }
    }

    public void add(File... files) {
        for (File file : files) {
            file.setParentDirectory(getPath());
            fileList.add(file);
        }
    }
    //TODO: сделать удаление файлов и папок.
}