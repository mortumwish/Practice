package main.java.file_system;

public class Main {
    public static void main(String[] args) {
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");
        Directory dir3 = new Directory("dir3");
        Directory dir4 = new Directory("dir4");
        Directory dir5 = new Directory("dir5");

        File file1 = new File("file1.txt", 10);
        File file2 = new File("file2.txt", 30);

//        вложенность:
//        dir1
//            dir2
//                dir3
//                    dir4
//                    file1.txt
//                    file2.txt
//            dir5

        dir1.addElement(dir2);
        dir2.addElement(dir3);
        dir3.addElement(dir4);
        dir3.addElement(file1);
        dir3.addElement(file2);
        dir2.addElement(dir5);

        System.out.println("old path for dir3: " + dir3.getPath());

        dir3.setParentDirectory(dir1);

        System.out.println("new path:\nfor dir3: " + dir3.getPath());

        System.out.println("for dir4: " + dir4.getPath());
        System.out.println("for file1: " + file1.getPath());
        System.out.println("for file2: " + file2.getPath() + "\n");


    }
}
