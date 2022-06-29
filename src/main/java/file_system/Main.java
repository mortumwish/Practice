package main.java.file_system;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");

        Directory dir1 = new Directory("dir1", root);
        Directory dir2 = new Directory("dir2", dir1);
        Directory dir3 = new Directory("dir3", dir2);
        TextFile file1 = new TextFile("file1.txt", 10, dir3);
        TextFile file2 = new TextFile("file2.txt", 30, dir3);
//        вложенность:
//        dir1
//            dir2
//                dir3
//                    dir4
//                    file1.txt
//                    file2.txt
//                dir5
        System.out.println(root.getDirectoryContents());
        System.out.println("file1 path before: " + file1.getPath());
        dir3.move(dir1);
        file2.move(root);
        System.out.println(root.getDirectoryContents());
        System.out.println("file1 path after: " + file1.getPath());

        System.out.println("\nroot's size: " + root.getSize());
        System.out.println("dir3's size: " + dir3.getSize());

    }
}
