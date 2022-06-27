package main.java.file_system;

public class Main {
    public static void main(String[] args) {
        Directory dir1 = new Directory("dir1");

        dir1.add(new File("file1.txt", 10), new File("file2.mp3", 20));
        dir1.add(new Directory("dir2"), new Directory("dir3"), dir1);

        dir1.getDirectory(0).add(new Directory("dir4"));
        dir1.getDirectory(0).getDirectory(0).add(new File("zipka.zip",128_000));
        dir1.getDirectory(0).add(new File("file3.mp4", 12_650));
        dir1.getDirectory(1).add(new File("file4.avi", 40_100));

        System.out.println(dir1.getDirectory(0).getDirectory(0).getFile(0).getPath());

        System.out.println(dir1.getDirectory(0).getDirectoryContents());
    }
}
