package main.java.file_system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String name;
    private String path;
    private LocalDate date;
    private List<Directory> directoryList;
    private List<File> fileList;
    private final int size = 1; // представим, что папка весит хоть что-то (1 байт) :)

    public Directory(String name) {
        this.name = name;
        this.path = getName();
        this.date = LocalDate.now();
        this.directoryList = new ArrayList<>();
        this.fileList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public Directory getDirectory(int index) {
        return directoryList.get(index);
    }

    public File getFile(int index) {
        return fileList.get(index);
    }

    public String getPath() {
        return path;
    }

    public StringBuilder getDirectoryContents() {
        StringBuilder content = new StringBuilder();
        for (Directory directory : directoryList) {
            content.append(" - " + directory.getName() + "/ Creation date: " + directory.getDate() + "\n");

        }
        for (File file : fileList) {
            content.append(" - " + file.getName() + " Creation date: " + file.getDate() + " Size: " + file.getSize() + " bytes \n");
        }
        return content;
    }

    public void setParentDirectory(String parentDirectory) {
        path = parentDirectory + "/" + getName();
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