package main.java.lampochka;

public class Main {
    public static void main(String[] args){
        Lamp lamp = new Lamp("White"); // создание объекта класса Lamp и проверка всех условий.
        lamp.on();
        lamp.on();
        lamp.status();
        lamp.off();
        lamp.status();
        lamp.setBrightness(30);
        lamp.status();
        lamp.off();
        lamp.on();
        lamp.setBrightness(130);
        lamp.setBrightness(30);
        lamp.status();
        lamp.off();
        lamp.on();
        lamp.off();
        lamp.on();
        lamp.status();
        lamp.on();
        lamp.on();
        lamp.status();
    }
}
